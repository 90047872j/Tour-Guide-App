package com.example.juan.tourguideapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class LeisureFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);
        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(getString(R.string.tibidaboName), getString(R.string.tibidaboWebPage), getString(R.string.tibidaboAddress), getString(R.string.tibidaboTelephone), getString(R.string.tibidaboEmail), R.drawable.tibidabo));
        locations.add(new Location(getString(R.string.zooName), getString(R.string.zooWebPage), getString(R.string.zooAddress), getString(R.string.zooTelephone), getString(R.string.zooEmail), R.drawable.zoo));
        locations.add(new Location(getString(R.string.aquariumName), getString(R.string.aquariumWebPage), getString(R.string.aquariumAddress), getString(R.string.aquariumTelephone), getString(R.string.aquariumEmail), R.drawable.aquarium));
        locations.add(new Location(getString(R.string.navalToursName), getString(R.string.navalToursWebPage), getString(R.string.navalToursAddress), getString(R.string.navalToursTelephone), getString(R.string.navalToursEmail), R.drawable.naval_tours));
        LocationAdapter itemsAdapter = new LocationAdapter(getActivity(), locations);
        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        return rootView;
    }
}
