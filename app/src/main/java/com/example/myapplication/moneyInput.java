package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class moneyInput extends AppCompatActivity{
    Button confirmBtn, interestBtn, checkBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moneyinput);
        confirmBtn = findViewById(R.id.confirm_button);
        interestBtn = findViewById(R.id.interest_button);
        checkBtn = findViewById(R.id.check_button);
        // Toast 만들기
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast;
                toast = Toast.makeText(getApplicationContext(),"먼저 상대방이 확인을 해야 합니다.",Toast.LENGTH_LONG);
                toast.setMargin(20, 20);
            }
        });
    }
}
