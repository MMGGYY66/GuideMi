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
public class MuseumsFragment extends Fragment {


    public MuseumsFragment() {
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
        places.add(new Place(getString(R.string.pinacoteca_brera_name), getString(R.string.pinacoteca_brera_address), getString(R.string.pinacoteca_brera_desc), R.drawable.pinacoteca_brera, getString(R.string.pinacoteca_brera_url), getString(R.string.pinacoteca_brera_loc)));
        places.add(new Place(getString(R.string.museo_duomo_name), getString(R.string.museo_duomo_address), getString(R.string.museo_duomo_desc), R.drawable.museo_duomo, getString(R.string.museo_duomo_url), getString(R.string.museo_duomo_loc)));
        places.add(new Place(getString(R.string.museo_novecento_name), getString(R.string.museo_novecento_address), getString(R.string.museo_novecento_desc), R.drawable.museo_novecento, getString(R.string.museo_novecento_url), getString(R.string.museo_novecento_loc)));
        places.add(new Place(getString(R.string.museo_castello_name), getString(R.string.museo_castello_address), getString(R.string.museo_castello_desc), R.drawable.museo_castello, getString(R.string.museo_castello_url), getString(R.string.museo_castello_loc)));
        places.add(new Place(getString(R.string.museo_armani_name), getString(R.string.museo_armani_address), getString(R.string.museo_armani_desc), R.drawable.museo_armani, getString(R.string.museo_armani_url), getString(R.string.museo_armani_loc)));
        places.add(new Place(getString(R.string.museo_scienza_name), getString(R.string.museo_scienza_address), getString(R.string.museo_scienza_desc), R.drawable.museo_scienza, getString(R.string.museo_scienza_url), getString(R.string.museo_scienza_loc)));
        places.add(new Place(getString(R.string.museo_leonardo_name), getString(R.string.museo_leonardo_address), getString(R.string.museo_leonardo_desc), R.drawable.museo_leonardo, getString(R.string.museo_leonardo_url), getString(R.string.museo_leonardo_loc)));
        places.add(new Place(getString(R.string.museo_scala_name), getString(R.string.museo_scala_address), getString(R.string.museo_scala_desc), R.drawable.museo_scala, getString(R.string.museo_scala_url), getString(R.string.museo_scala_loc)));
        places.add(new Place(getString(R.string.museo_moderna_name), getString(R.string.museo_moderna_address), getString(R.string.museo_moderna_desc), R.drawable.museo_moderna, getString(R.string.museo_moderna_url), getString(R.string.museo_moderna_loc)));
        places.add(new Place(getString(R.string.museo_triennale_name), getString(R.string.museo_triennale_address), getString(R.string.museo_triennale_desc), R.drawable.museo_triennale, getString(R.string.museo_triennale_url), getString(R.string.museo_triennale_loc)));


        //Set the adapter for the places
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        ListView listView = (ListView) rootView.findViewById(R.id.place_list);

        listView.setAdapter(adapter);

        //Return the fragment rootview
        return rootView;
    }

}
