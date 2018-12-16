package com.example.maheshprasad.shopcart.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.maheshprasad.shopcart.R;

public class Login extends AppCompatActivity {

    //Widget
    Button mlogin_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initialize widget
        Initalization();
        mlogin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,MainActivity.class));
            }
        });
    }

    private void Initalization() {
        mlogin_btn = findViewById(R.id.signin_login_btn);
    }

    public void SignUp(View view) {

    }

    public void GoToMain(View view) {

        goToMain();
    }

    private void goToMain() {
        startActivity(new Intent(Login.this,MainActivity.class));
    }
}
