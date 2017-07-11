package com.example.juan.tourguideapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {

   public LocationAdapter(Activity context, ArrayList<Location> locations) {
        super(context, 0 , locations);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Location location_item = getItem(position);
        TextView textViewLocationName = (TextView) listItemView.findViewById(R.id.textView_location_name);
        TextView textViewLocationWebPage = (TextView) listItemView.findViewById(R.id.textView_location_webPage);
        TextView textViewLocationAddress = (TextView) listItemView.findViewById(R.id.textView_location_address);
        TextView textViewLocationPhone = (TextView) listItemView.findViewById(R.id.textView_location_phone);
        TextView textViewLocationEmail = (TextView) listItemView.findViewById(R.id.textView_location_email);
        ImageView locationImageView = (ImageView) listItemView.findViewById(R.id.imageView);
        textViewLocationName.setText(location_item.getLocationName());
        textViewLocationWebPage.setText(location_item.getlocationWebPage());
        Linkify.addLinks(textViewLocationWebPage, Linkify.WEB_URLS);
        textViewLocationWebPage.setLinkTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        textViewLocationAddress.setText(location_item.getlocationAddress());
        final String currentAddress = (String) textViewLocationAddress.getText();
        textViewLocationAddress.setPaintFlags(textViewLocationAddress.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        textViewLocationAddress.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        textViewLocationAddress.setOnClickListener(new View.OnClickListener(){


            public void onClick(View v) {
                String maps_query = "geo:0,0?q="+currentAddress;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(maps_query));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                getContext().startActivity(intent);
                }
            });
        textViewLocationPhone.setText(location_item.getlocationPhone());
        Linkify.addLinks(textViewLocationPhone, Linkify.PHONE_NUMBERS);
        textViewLocationPhone.setLinkTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        textViewLocationEmail.setText(location_item.getlocationEmail());
        Linkify.addLinks(textViewLocationEmail, Linkify.EMAIL_ADDRESSES);
        textViewLocationEmail.setLinkTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        locationImageView.setImageResource(location_item.getImageResourceId());
        return listItemView;
    }
}
