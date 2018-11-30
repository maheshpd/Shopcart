package com.example.maheshprasad.shopcart.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.maheshprasad.shopcart.R;
import com.example.maheshprasad.shopcart.Utils.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void loadSlide(View view) {

        new PreferenceManager(this).clearPreferences();
        startActivity(new Intent(this,Walkthrough.class));
        finish();
    }
}
