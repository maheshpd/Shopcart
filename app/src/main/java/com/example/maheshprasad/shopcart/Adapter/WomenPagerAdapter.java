package com.example.maheshprasad.shopcart.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.maheshprasad.shopcart.fragment.Jewellery;
import com.example.maheshprasad.shopcart.fragment.WalletBags;
import com.example.maheshprasad.shopcart.fragment.Westernwear;
import com.example.maheshprasad.shopcart.fragment.WomenAccesories;

public class WomenPagerAdapter extends FragmentPagerAdapter {
    public WomenPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                WalletBags walletBags = new WalletBags();
                return walletBags;
            case 1:
                Westernwear westernwear = new Westernwear();
                return westernwear;
            case 2:
                Jewellery jewellery = new Jewellery();
                return jewellery;
            case 3:
                WomenAccesories womenAccesories = new WomenAccesories();
                return womenAccesories;

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
        switch (position){
            case 0:
                return "Wallet & Bags";
            case 1:
                return "Western wear";
            case 2:
                return "Jewellery";
            case 3:
                return "Accessories";
            default:
                return null;
        }

    }
}
