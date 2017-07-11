package com.example.juan.tourguideapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class EntertaintmentFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);
        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(getString(R.string.casinoName),getString(R.string.casinoWebPage),getString(R.string.casinoAddress),getString(R.string.casinoTelephone),getString(R.string.casinoEmail),R.drawable.casino_barcelona));
        locations.add(new Location(getString(R.string.bodegaName),getString(R.string.bodegaWebPage),getString(R.string.bodegaAddress),getString(R.string.bodegaTelephone),getString(R.string.bodegaEmail),R.drawable.bodega_flamenca));
        locations.add(new Location(getString(R.string.tarantosName),getString(R.string.tarantoseWebPage),getString(R.string.tarantosAddress),getString(R.string.tarantosTelephone),getString(R.string.tarantosEmail),R.drawable.tarantos));
        locations.add(new Location(getString(R.string.jamboreeName),getString(R.string.jamboreeWebPage),getString(R.string.jamboreeAddress),getString(R.string.jamboreeTelephone),getString(R.string.jamboreeEmail),R.drawable.jamboree));
        LocationAdapter itemsAdapter = new LocationAdapter(getActivity(), locations);
        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        return rootView;
    }
}
