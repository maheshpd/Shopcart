package com.example.maheshprasad.shopcart.Activity;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.maheshprasad.shopcart.Activity.MainActivity;
import com.example.maheshprasad.shopcart.Adapter.MPagerAdapter;
import com.example.maheshprasad.shopcart.R;
import com.example.maheshprasad.shopcart.Utils.PreferenceManager;

public class Walkthrough extends AppCompatActivity implements View.OnClickListener {

    //Widget
    private ViewPager mPager;
    private LinearLayout Dots_Layout;
    private ImageView[] dots;
    private Button btn_get_started;
   //layouts array
    private int[] layouts = {R.layout.first_slider,R.layout.second_slider,R.layout.third_slider};

    //Adapter
    private MPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set Full Screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_walkthrough);

        if (new PreferenceManager(this).checkPreference())
        {
            loadHome();
        }



        //init widget
        InitializeWidget();

        CreateDots(0);
    }

    private void InitializeWidget() {
        btn_get_started=findViewById(R.id.walkthrough_button);
        Dots_Layout = findViewById(R.id.dotsLayout);
        mPager = findViewById(R.id.walkthrough_viewPager);
        mPagerAdapter = new MPagerAdapter(layouts,this);
        mPager.setAdapter(mPagerAdapter);

        btn_get_started.setOnClickListener(this);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                CreateDots(i);

                if (i==layouts.length-1)
                {
                    btn_get_started.setText("Start");
                }else {
                    btn_get_started.setText("Get Started");
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    private void CreateDots(int current_position){
        if (Dots_Layout != null)
            Dots_Layout.removeAllViews();
        dots = new ImageView[layouts.length];

        for (int i =0; i<layouts.length; i++)
        {
            dots[i] = new ImageView(this);
            if (i == current_position)
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dots_selected));
            }else {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dots_default));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4,0,4,0);
            Dots_Layout.addView(dots[i],params);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.walkthrough_button:
                loadNextSlider();
                break;
        }
    }

    private void loadHome(){
        startActivity(new Intent(this,Splash.class));
    }

    private void loadNextSlider()
    {
        int next_slide = mPager.getCurrentItem()+1;
        if (next_slide<layouts.length)
        {
mPager.setCurrentItem(next_slide);
        }else {
            loadHome();
            new PreferenceManager(this).writePreference();
        }
    }
}
