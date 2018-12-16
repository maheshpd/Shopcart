package com.example.maheshprasad.shopcart.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.maheshprasad.shopcart.R;
import com.example.maheshprasad.shopcart.Utils.PreferenceManager;
import com.example.maheshprasad.shopcart.fragment.Home;
import com.example.maheshprasad.shopcart.fragment.HotOffer;
import com.example.maheshprasad.shopcart.fragment.MyCart;
import com.example.maheshprasad.shopcart.fragment.Profile;
import com.example.maheshprasad.shopcart.fragment.Search;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);

        bottomNav = findViewById(R.id.bottom_menu);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Home()).commit();
        }



    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()){
                case R.id.home_fragment:
                    selectedFragment = new Home();
                    break;
                case R.id.offer_fragment:
                    selectedFragment = new HotOffer();
                    break;
                case R.id.mycart_fragment:
                    selectedFragment = new MyCart();
                    break;
                case R.id.search_fragment:
                    selectedFragment = new Search();
                    break;
                case R.id.profile_fragment:
                    selectedFragment = new Profile();
                    break;
            }
           getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                   selectedFragment).commit();
            return true;
        }
    };

    public void loadSlide(View view) {

        new PreferenceManager(this).clearPreferences();
        startActivity(new Intent(this,Walkthrough.class));
        finish();
    }
}
