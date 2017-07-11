package com.example.juan.tourguideapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class MuseumFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);
        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(getString(R.string.mCampNouName), getString(R.string.mCampNouWebPage), getString(R.string.mCampNouAddress), getString(R.string.mCampNouTelephone), getString(R.string.mCampNouEmail), R.drawable.camp_nou));
        locations.add(new Location(getString(R.string.mOlimpicName), getString(R.string.mOlimpicWebPage), getString(R.string.mOlimpicAddress), getString(R.string.mOlimpicTelephone), getString(R.string.mOlimpicEmail), R.drawable.museu_olimpic));
        locations.add(new Location(getString(R.string.mHistoriaName), getString(R.string.mHistoriaWebPage), getString(R.string.mHistoriaAddress), getString(R.string.mHistoriaTelephone), getString(R.string.mHistoriaEmail), R.drawable.museu_historia));
        locations.add(new Location(getString(R.string.mNacionalName), getString(R.string.mNacionalWebPage), getString(R.string.mNacionalAddress), getString(R.string.mNacionalTelephone), getString(R.string.mNacionalEmail), R.drawable.museu_art));
        LocationAdapter itemsAdapter = new LocationAdapter(getActivity(), locations);
        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        return rootView;
    }
}
