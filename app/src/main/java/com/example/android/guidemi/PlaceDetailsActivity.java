package com.example.android.guidemi;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlaceDetailsActivity extends AppCompatActivity {

    //Create a new MediaPlayer for the audio
    private MediaPlayer mMediaPlayer;
    //Create an AudioManager for the audio
    private AudioManager mAudioManager;
    //Set an OnAudioFocusChangeListener for the audio
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {

            //If temporarily loses AudioFocus, pause and go to the beginning
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }

            //If permanently loses AudioFocus, stop and release the resources
            else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                mMediaPlayer.stop();
                releaseMediaPlayer();
            }

            //If gains AudioFocus, start playing
            else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            }

        }
    };
    //Create an OnCompletionListener for the audio
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {

            //Release the MediaPlayer if the audio has finished
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        //Get the properties of the Place Object from the intent
        Bundle b = getIntent().getExtras();
        String placeName = b.getString(getString(R.string.name_var));
        String placeAddress = b.getString(getString(R.string.address_var));
        String placeDescription = b.getString(getString(R.string.desc_var));
        int placeImage = b.getInt(getString(R.string.img_var));
        final int placeAudio = b.getInt(getString(R.string.audio_var));
        final String placeSite = b.getString(getString(R.string.site_var));
        final String placeLocation = b.getString(getString(R.string.loc_var));

        //Set the name of the place as the title of the screen
        this.setTitle(placeName);

        //Activate Up Button to enable the navigation back to the MainActivity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Set the audio service to the AudioManager
        mAudioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);

        //Set the image to the ImageView in the activity_place_details.xml
        ImageView imageView = (ImageView) findViewById(R.id.detailed_image);
        imageView.setImageResource(placeImage);

        //Set the name to the TextView in the activity_place_details.xml
        TextView nameTextView = (TextView) findViewById(R.id.detailed_name);
        nameTextView.setText(placeName);

        //Set the address to the TextView in the activity_place_details.xml
        TextView addressTextView = (TextView) findViewById(R.id.detailed_address);
        addressTextView.setText(placeAddress);

        //Set the description to the TextView in the activity_place_details.xml
        TextView descriptionTextView = (TextView) findViewById(R.id.detailed_desc);
        descriptionTextView.setText(placeDescription);

        //Create an intent for the web page of the Place Object
        LinearLayout linkView = (LinearLayout) findViewById(R.id.link_webpage);
        linkView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //If clicking on the icon, goes to the site of the place
                Uri webpage = Uri.parse(placeSite);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);
                }
            }
        });

        //Create an intent for the web page of the Place Object
        LinearLayout mapView = (LinearLayout) findViewById(R.id.link_map);
        mapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //If clicking on the icon, goes to the site of the place
                Uri geoLocation = Uri.parse("geo:" + placeLocation + "?z=16");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, geoLocation);
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        //Creates a variable for the audio link
        LinearLayout audioView = (LinearLayout) findViewById(R.id.link_audio);

        //If exists an audio file for the current Place Object
        if (placeAudio != -1) {

            //Get the icon of the Audio Guide link
            final ImageView icon = (ImageView) findViewById(R.id.audio_icon);

            //Displays the icon for the Audio Guide
            audioView.setVisibility(View.VISIBLE);

            //Creates the MediaPlayer
            mMediaPlayer = MediaPlayer.create(PlaceDetailsActivity.this, placeAudio);


            audioView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Request Audio Focus
                    int audioFocusResult = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

                    //If AudioFocus is granted
                    if (audioFocusResult == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                        if (mMediaPlayer.isPlaying()) {

                            //If the audio is already playing, clicking on the icon pauses the audio and changes the icon to play
                            mMediaPlayer.pause();
                            icon.setImageResource(R.drawable.ic_play);
                        } else {

                            //If the audio is not playing, clicking on the icon starts the audio and changes the icon to stop
                            mMediaPlayer.start();
                            icon.setImageResource(R.drawable.ic_stop);
                        }

                        //Set an OnCompletionListener for the MediaPlayer
                        mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
                    }

                }
            });


        }

        //If an audio file doesn't exist, hides the icon
        else {
            audioView.setVisibility(View.GONE);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing
        if (mMediaPlayer != null) {
            // Release the audio resources because we no longer need it
            mMediaPlayer.release();

            // Set the media player to null
            mMediaPlayer = null;

            //Abandons AudioFocus
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
