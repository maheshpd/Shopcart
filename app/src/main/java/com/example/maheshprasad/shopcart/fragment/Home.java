package com.example.maheshprasad.shopcart.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.maheshprasad.shopcart.Activity.WomenWear;
import com.example.maheshprasad.shopcart.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {


    private ViewPager mSliderViewPager;
    private LinearLayout mDotsLayout;

    RelativeLayout womenImage,menImage,kidImage;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_home, container, false);
        context = view.getContext();

        womenImage=view.findViewById(R.id.women);
        menImage=view.findViewById(R.id.men);
        kidImage=view.findViewById(R.id.kid);


        womenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,WomenWear.class));
            }
        });

        return view;


    }

}
