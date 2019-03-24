package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    Button newInfoButton, sumLookButton;
    ImageButton loginButton, newAccountButton, findIdPwButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //인텐트 만들기
        newInfoButton = findViewById(R.id.newInfo_button);
        sumLookButton = findViewById(R.id.sumLook_button);
        findIdPwButton = findViewById(R.id.findIdPwButton);
        loginButton = findViewById(R.id.loginImageButton);
        newAccountButton = findViewById(R.id.newAccountButton);
        newInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(MainActivity.this, moneyInput.class);
                startActivity(i);
            }
        });
        sumLookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(MainActivity.this, moneyChart.class);
                startActivity(i);
            }
        });
    }
}
