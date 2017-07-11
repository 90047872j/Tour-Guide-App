package com.example.juan.tourguideapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class CultureFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);
        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(getString(R.string.sagradaFamiliaName), getString(R.string.sagradaFamiliaWebPage), getString(R.string.sagradaFamiliaAddress), getString(R.string.sagradaFamiliaTelephone), getString(R.string.sagradaFamiliaEmail), R.drawable.sagrada_familia));
        locations.add(new Location(getString(R.string.pobleEspanyolName), getString(R.string.pobleEspanyolWebPage), getString(R.string.pobleEspanyolAddress), getString(R.string.pobleEspanyolTelephone), getString(R.string.pobleEspanyolEmail), R.drawable.poble_espanyol));
        locations.add(new Location(getString(R.string.laPedreraName), getString(R.string.laPedreraWebPage), getString(R.string.laPedreraAddress), getString(R.string.laPedreraTelephone), getString(R.string.laPedreraEmail), R.drawable.la_pedrera));
        locations.add(new Location(getString(R.string.palauName), getString(R.string.palauWebPage), getString(R.string.palauAddress), getString(R.string.palauTelephone), getString(R.string.palauEmail), R.drawable.palau_musica));
        LocationAdapter itemsAdapter = new LocationAdapter(getActivity(), locations);
        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        return rootView;
    }
}
