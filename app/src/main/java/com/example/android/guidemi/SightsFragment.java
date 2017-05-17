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
public class SightsFragment extends Fragment {


    public SightsFragment() {
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
        places.add(new Place(getString(R.string.duomo_name), getString(R.string.duomo_address), getString(R.string.duomo_desc), R.drawable.duomo, getString(R.string.duomo_url), R.raw.duomo, getString(R.string.duomo_loc)));
        places.add(new Place(getString(R.string.sforza_name), getString(R.string.sforza_address), getString(R.string.sforza_desc), R.drawable.sforza, getString(R.string.sforza_url), R.raw.sforza, getString(R.string.sforza_loc)));
        places.add(new Place(getString(R.string.galleria_name), getString(R.string.galleria_address), getString(R.string.galleria_desc), R.drawable.galleria, getString(R.string.galleria_url), R.raw.galleria, getString(R.string.galleria_loc)));
        places.add(new Place(getString(R.string.scala_name), getString(R.string.scala_address), getString(R.string.scala_desc), R.drawable.scala, getString(R.string.scala_url), R.raw.scala, getString(R.string.scala_loc)));
        places.add(new Place(getString(R.string.arco_name), getString(R.string.arco_address), getString(R.string.arco_desc), R.drawable.arco, getString(R.string.arco_url), R.raw.arco, getString(R.string.arco_loc)));
        places.add(new Place(getString(R.string.aulenti_name), getString(R.string.aulenti_address), getString(R.string.aulenti_desc), R.drawable.aulenti, getString(R.string.aulenti_url), R.raw.aulenti, getString(R.string.aulenti_loc)));
        places.add(new Place(getString(R.string.grazie_name), getString(R.string.grazie_address), getString(R.string.grazie_desc), R.drawable.grazie, getString(R.string.grazie_url), R.raw.grazie, getString(R.string.grazie_loc)));
        places.add(new Place(getString(R.string.cimitero_name), getString(R.string.cimitero_address), getString(R.string.cimitero_desc), R.drawable.cimitero, getString(R.string.cimitero_url), R.raw.cimitero, getString(R.string.cimitero_loc)));
        places.add(new Place(getString(R.string.sansiro_name), getString(R.string.sansiro_address), getString(R.string.sansiro_desc), R.drawable.sansiro, getString(R.string.sansiro_url), R.raw.sansiro, getString(R.string.sansiro_loc)));
        places.add(new Place(getString(R.string.bosco_name), getString(R.string.bosco_address), getString(R.string.bosco_desc), R.drawable.bosco, getString(R.string.bosco_url), R.raw.bosco, getString(R.string.bosco_loc)));


        //Set the adapter for the places
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        ListView listView = (ListView) rootView.findViewById(R.id.place_list);

        listView.setAdapter(adapter);

        //Return the fragment rootview
        return rootView;
    }

}
