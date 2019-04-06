package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.listener.SuccessRegistrationListener;
import com.example.myapplication.model.User;
import com.example.myapplication.network.RetrofitManager;

public class NewAccountActivity extends AppCompatActivity implements SuccessRegistrationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        Button registerLawmakerButton = findViewById(R.id.NewAccountConfirmBtn);

        RetrofitManager.getInstance().setOnSuccessRegistrationListener(this);
        registerLawmakerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = findViewById(R.id.NewIdInput);
                EditText password = findViewById(R.id.NewPWInput);
                EditText name = findViewById(R.id.NewNameInput);
                User user = User.createUserModel(email.getText().toString(), password.getText().toString(), name.getText().toString());
                RetrofitManager.getInstance().register(user);
            }
        });
    }

    @Override
    public void onSuccessRegister() {
        Toast.makeText(GlobalApplication.getGlobalContext(), R.string.register_success_message, Toast.LENGTH_LONG).show();
        Intent intentHome = new Intent(NewAccountActivity.this, MainActivity.class);
        intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intentHome.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intentHome);
    }

    @Override
    protected void onDestroy() {
        RetrofitManager.getInstance().removeSuccessRegistrationListener();
        super.onDestroy();
    }
}
