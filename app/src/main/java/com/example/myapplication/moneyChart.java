package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.myapplication.listener.SuccessGetBondListListener;
import com.example.myapplication.model.BondListViewAdapter;
import com.example.myapplication.model.BondTO;
import com.example.myapplication.network.RetrofitManager;

import java.util.List;
import java.util.logging.Logger;

public class moneyChart extends AppCompatActivity implements SuccessGetBondListListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.money_chart);

        String creditorName = getIntent().getStringExtra("creditorName");
        Long creditorId = getIntent().getLongExtra("creditorId", -999L);

        RetrofitManager.getInstance().setOnSuccessGetBondListListener(this);
        Logger.getLogger("moneyChart").info("creditor name: " + creditorName);
        Logger.getLogger("moneyChart").info("creditor id: " + creditorId);

        if (creditorId > 0L) {
            RetrofitManager.getInstance().getBondList(creditorId);
        }

        findViewById(R.id.newBondBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(moneyChart.this, moneyInput.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSuccessGetBondList(List<BondTO> bondList) {
        ListView bondListView = findViewById(R.id.bondListView);
        BondListViewAdapter bondListViewAdapter = new BondListViewAdapter(bondList);
        bondListView.setAdapter(bondListViewAdapter);
    }
}
