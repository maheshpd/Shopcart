package com.example.maheshprasad.shopcart.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maheshprasad.shopcart.Adapter.MainPagerAdapter;
import com.example.maheshprasad.shopcart.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainProfile extends Fragment {
    //Widget
    private ViewPager profileViewPager;
    private MainPagerAdapter profileAdapter;
    private TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_main_profile, container, false);

        profileViewPager = view.findViewById(R.id.profile_viewPager);
        profileAdapter = new MainPagerAdapter(getFragmentManager());
        profileViewPager.setAdapter(profileAdapter);


        tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(profileViewPager);
        return view;
    }

}
