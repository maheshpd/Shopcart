package com.example.maheshprasad.shopcart.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.maheshprasad.shopcart.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {


    private ViewPager mSliderViewPager;
    private LinearLayout mDotsLayout;
//    SliderAdapter sliderAdapter;
//
//    private ImageView[] dot;
//    private int dotscount;
//    ArrayList<BannerModel> bannerlist = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);


    }

}
