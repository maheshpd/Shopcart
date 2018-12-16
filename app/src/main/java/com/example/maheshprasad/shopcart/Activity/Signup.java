package com.example.maheshprasad.shopcart.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.maheshprasad.shopcart.R;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void Signin(View view) {
        startActivity(new Intent(Signup.this,Login.class));
    }

    public void GoToMain(View view) {

        goToMain();
    }

    private void goToMain() {
        startActivity(new Intent(Signup.this,MainActivity.class));
    }
}
