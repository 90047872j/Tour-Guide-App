package com.example.juan.tourguideapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {

    public LocationAdapter(Activity context, ArrayList<Location> locations) {
        super(context, 0, locations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Location location_item = getItem(position);
        TextView tvLocationName = (TextView) listItemView.findViewById(R.id.textView_location_name);
        TextView tvLocationWebPage = (TextView) listItemView.findViewById(R.id.textView_location_webPage);
        TextView tvLocationAddress = (TextView) listItemView.findViewById(R.id.textView_location_address);
        TextView tvLocationPhone = (TextView) listItemView.findViewById(R.id.textView_location_phone);
        TextView tvLocationEmail = (TextView) listItemView.findViewById(R.id.textView_location_email);
        ImageView imlocation = (ImageView) listItemView.findViewById(R.id.imageView);

        tvLocationName.setText(location_item.getLocationName());
        tvLocationWebPage.setText(location_item.getlocationWebPage());
        Linkify.addLinks(tvLocationWebPage, Linkify.WEB_URLS);
        tvLocationWebPage.setLinkTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));

        tvLocationAddress.setText(location_item.getlocationAddress());
        final String currentAddress = (String) tvLocationAddress.getText();
        tvLocationAddress.setPaintFlags(tvLocationAddress.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvLocationAddress.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));

        tvLocationAddress.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String maps_query = "geo:0,0?q=" + currentAddress;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(maps_query));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                getContext().startActivity(intent);
            }
        });

        tvLocationPhone.setText(location_item.getlocationPhone());
        Linkify.addLinks(tvLocationPhone, Linkify.PHONE_NUMBERS);
        tvLocationPhone.setLinkTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));

        tvLocationEmail.setText(location_item.getlocationEmail());
        Linkify.addLinks(tvLocationEmail, Linkify.EMAIL_ADDRESSES);
        tvLocationEmail.setLinkTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));

        imlocation.setImageResource(location_item.getImageResourceId());

        return listItemView;
    }
}
