package com.example.juan.tourguideapp;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class CategoryAdapter extends FragmentPagerAdapter {
    private final Context mContext;

    CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CultureFragment();
            case 1:
                return new MuseumFragment();
            case 2:
                return new LeisureFragment();
            case 3:
                return new EntertaintmentFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.culture_tab_name);
            case 1:
                return mContext.getString(R.string.museums_tab_name);
            case 2:
                return mContext.getString(R.string.leisure_tab_name);
            case 3:
                return mContext.getString(R.string.entertaintment_tab_name);
        }
        return null;
    }
}
