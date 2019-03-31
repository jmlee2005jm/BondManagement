package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    Button loginConfirmBtn, findIDPWBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginConfirmBtn = findViewById(R.id.loginConfirmBtn);
        findIDPWBtn = findViewById(R.id.findIdPwButton);
        findIDPWBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(LoginActivity.this, findIDPWActivity.class);
                startActivity(i);
            }
        });
    }
}
