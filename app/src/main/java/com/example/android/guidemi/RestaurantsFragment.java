package com.example.android.guidemi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {


    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the list
        View rootView = inflater.inflate(R.layout.list, container, false);

        //Create the ArrayList for the places
        ArrayList<Place> places = new ArrayList<Place>();

        //Add the places to the ArrayList
        places.add(new Place(getString(R.string.ribot_name), getString(R.string.ribot_address), getString(R.string.ribot_desc), R.drawable.ribot, getString(R.string.ribot_url), getString(R.string.ribot_loc)));
        places.add(new Place(getString(R.string.rebelot_name), getString(R.string.rebelot_address), getString(R.string.rebelot_desc), R.drawable.rebelot, getString(R.string.rebelot_url), getString(R.string.rebelot_loc)));
        places.add(new Place(getString(R.string.ratana_name), getString(R.string.ratana_address), getString(R.string.ratana_desc), R.drawable.ratana, getString(R.string.ratana_url), getString(R.string.ratana_loc)));
        places.add(new Place(getString(R.string.drymilano_name), getString(R.string.drymilano_address), getString(R.string.drymilano_desc), R.drawable.drymilano, getString(R.string.drymilano_url), getString(R.string.drymilano_loc)));
        places.add(new Place(getString(R.string.joia_name), getString(R.string.joia_address), getString(R.string.joia_desc), R.drawable.joia, getString(R.string.joia_url), getString(R.string.joia_loc)));
        places.add(new Place(getString(R.string.cracco_name), getString(R.string.cracco_address), getString(R.string.cracco_desc), R.drawable.cracco, getString(R.string.cracco_url), getString(R.string.cracco_loc)));
        places.add(new Place(getString(R.string.posto_name), getString(R.string.posto_address), getString(R.string.posto_desc), R.drawable.posto, getString(R.string.posto_url), getString(R.string.posto_loc)));
        places.add(new Place(getString(R.string.mangiari_name), getString(R.string.mangiari_address), getString(R.string.mangiari_desc), R.drawable.mangiari, getString(R.string.mangiari_url), getString(R.string.mangiari_loc)));
        places.add(new Place(getString(R.string.berbere_name), getString(R.string.berbere_address), getString(R.string.berbere_desc), R.drawable.berbere, getString(R.string.berbere_url), getString(R.string.berbere_loc)));
        places.add(new Place(getString(R.string.brisa_name), getString(R.string.brisa_address), getString(R.string.brisa_desc), R.drawable.brisa, getString(R.string.brisa_url), getString(R.string.brisa_loc)));


        //Set the adapter for the places
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        ListView listView = (ListView) rootView.findViewById(R.id.place_list);

        listView.setAdapter(adapter);

        //Return the fragment rootview
        return rootView;
    }

}
