package com.example.maheshprasad.shopcart.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.maheshprasad.shopcart.R;
import com.example.maheshprasad.shopcart.Utils.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.main_toolbar);
       ImageView menuIcon=mToolbar.findViewById(R.id.menu_icon);
       menuIcon.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(MainActivity.this, "Menu Click", Toast.LENGTH_SHORT).show();
           }
       });

    }

    public void loadSlide(View view) {

        new PreferenceManager(this).clearPreferences();
        startActivity(new Intent(this,Walkthrough.class));
        finish();
    }
}
