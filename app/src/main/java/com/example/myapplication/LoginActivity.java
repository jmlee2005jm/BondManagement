package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
        //만약 로그인에 성공했다면
        // loginConfirmButton.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                Intent i;
        //                i = new Intent(LoginActivity.this, moneyChart.class);
        //                startActivity(i);
        //            }
        //        });
        //실패했다면
        //loginConfirmButton.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                Toast toast;
        //                toast = Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show();
        //                toast.setMargin(20, 20);
        //            }
        //        });
    }
}
