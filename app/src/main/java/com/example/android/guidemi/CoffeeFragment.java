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
public class CoffeeFragment extends Fragment {


    public CoffeeFragment() {
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
        places.add(new Place(getString(R.string.marotin_name), getString(R.string.marotin_address), getString(R.string.marotin_desc), R.drawable.marotin, getString(R.string.marotin_url), getString(R.string.marotin_loc)));
        places.add(new Place(getString(R.string.como_name), getString(R.string.como_address), getString(R.string.como_desc), R.drawable.como, getString(R.string.como_url), getString(R.string.como_loc)));
        places.add(new Place(getString(R.string.gattullo_name), getString(R.string.gattullo_address), getString(R.string.gattullo_desc), R.drawable.gattullo, getString(R.string.gattullo_url), getString(R.string.gattullo_loc)));
        places.add(new Place(getString(R.string.sissi_name), getString(R.string.sissi_address), getString(R.string.sissi_desc), R.drawable.sissi, getString(R.string.sissi_url), getString(R.string.sissi_loc)));
        places.add(new Place(getString(R.string.cuccagna_name), getString(R.string.cuccagna_address), getString(R.string.cuccagna_desc), R.drawable.cuccagna, getString(R.string.cuccagna_url), getString(R.string.cuccagna_loc)));
        places.add(new Place(getString(R.string.pave_name), getString(R.string.pave_address), getString(R.string.pave_desc), R.drawable.pave, getString(R.string.pave_url), getString(R.string.pave_loc)));
        places.add(new Place(getString(R.string.cat_name), getString(R.string.cat_address), getString(R.string.cat_desc), R.drawable.cat, getString(R.string.cat_url), getString(R.string.cat_loc)));
        places.add(new Place(getString(R.string.bianco_name), getString(R.string.bianco_address), getString(R.string.bianco_desc), R.drawable.bianco, getString(R.string.bianco_url), getString(R.string.bianco_loc)));


        //Set the adapter for the places
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        ListView listView = (ListView) rootView.findViewById(R.id.place_list);

        listView.setAdapter(adapter);

        //Return the fragment rootview
        return rootView;
    }

}
