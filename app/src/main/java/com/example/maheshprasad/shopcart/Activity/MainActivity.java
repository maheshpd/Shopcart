package com.example.maheshprasad.shopcart.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.maheshprasad.shopcart.R;
import com.example.maheshprasad.shopcart.Utils.PreferenceManager;
import com.example.maheshprasad.shopcart.fragment.Home;
import com.example.maheshprasad.shopcart.fragment.HotOffer;
import com.example.maheshprasad.shopcart.fragment.MainProfile;
import com.example.maheshprasad.shopcart.fragment.MyCart;
import com.example.maheshprasad.shopcart.fragment.Profile;
import com.example.maheshprasad.shopcart.fragment.Search;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar mToolbar;
    BottomNavigationView bottomNav;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    RelativeLayout mensRelative,womenRelative,trackRelative,accountRelative,SettingRelative,logoutRelative;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);

        bottomNav = findViewById(R.id.bottom_menu);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        drawer = findViewById(R.id.drawer_layout);
        toggle=new ActionBarDrawerToggle(this,
                drawer,mToolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.navigation_icon);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView=findViewById(R.id.navigationview);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Home()).commit();
        }

        //navigation item views

        mensRelative=navigationView.findViewById(R.id.menwear);
        womenRelative=navigationView.findViewById(R.id.womenwear);
        trackRelative=navigationView.findViewById(R.id.trackorder);
        accountRelative=navigationView.findViewById(R.id.accountdetail);
        SettingRelative=navigationView.findViewById(R.id.settings);
        logoutRelative=navigationView.findViewById(R.id.logout);

        womenRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,WomenWear.class));
            }
        });

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
                    selectedFragment = new MainProfile();
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();
        switch (id) {
            case R.id.menwear:
                break;
            case R.id.womenwear:

                break;

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
