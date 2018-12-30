package com.example.maheshprasad.shopcart.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.maheshprasad.shopcart.Adapter.WomenPagerAdapter;
import com.example.maheshprasad.shopcart.R;

public class WomenWear extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    WomenPagerAdapter womenPagerAdapter;

    ImageView backImage,fillerimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_wear);

        tabLayout=findViewById(R.id.womentabs);
        viewPager=findViewById(R.id.womenviewpager);
        womenPagerAdapter = new WomenPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(womenPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        backImage=findViewById(R.id.back);
        fillerimage=findViewById(R.id.filters);

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
