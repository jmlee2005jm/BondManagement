package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

public class moneyInput extends AppCompatActivity{
    ImageButton loginButton, findIdPw, newAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moneyinput);
        loginButton = findViewById(R.id.loginImageButton);
        findIdPw = findViewById(R.id.findIdPwButton);
        newAccount = findViewById(R.id.newAccountButton);
        // Toast 만들기

    }
}
