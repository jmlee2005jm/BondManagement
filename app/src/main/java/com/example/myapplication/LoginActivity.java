package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.listener.SuccessLoginListener;
import com.example.myapplication.model.LoginDTO;
import com.example.myapplication.network.RetrofitManager;

public class LoginActivity extends AppCompatActivity implements SuccessLoginListener {
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

        RetrofitManager.getInstance().setOnSuccessLoginListener(this);
        Button loginButton = findViewById(R.id.loginConfirmBtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = findViewById(R.id.idInput);
                EditText password = findViewById(R.id.PWInput);
                RetrofitManager.getInstance().login(new LoginDTO(email.getText().toString(), password.getText().toString()));
            }
        });
    }

    @Override
    public void onSuccessLogin() {
        Intent intent = new Intent(LoginActivity.this, moneyChart.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        RetrofitManager.getInstance().removeSuccessLoginListener();
        super.onDestroy();
    }
}
