package com.example.maheshprasad.shopcart.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.maheshprasad.shopcart.fragment.MyOrder;
import com.example.maheshprasad.shopcart.fragment.Profile;
import com.example.maheshprasad.shopcart.fragment.SavedAddress;
import com.example.maheshprasad.shopcart.fragment.Wishlist;

public class MainPagerAdapter extends FragmentPagerAdapter {
    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                Profile profile = new Profile();
                return profile;
            case 1:
                MyOrder order = new MyOrder();
                return order;
            case 2:
                Wishlist wishlist = new Wishlist();
                return wishlist;
            case 3:
                SavedAddress address = new SavedAddress();
                return address;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Profile";
            case 1:
                return "My Order";
            case 2:
                return "Wishlist";
            case 3:
                return "Saved Address";
            default:
                return null;
        }

    }
}
