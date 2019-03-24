package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;

public class moneyInput extends AppCompatActivity{
    Button gotoChartBtn, confirmBtn, interestBtn, checkBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moneyinput);
        gotoChartBtn = findViewById(R.id.goToChartBtn);
        confirmBtn = findViewById(R.id.confirm_button);
        interestBtn = findViewById(R.id.interest_button);
        checkBtn = findViewById(R.id.check_button);
        // Toast 만들기

    }
}
