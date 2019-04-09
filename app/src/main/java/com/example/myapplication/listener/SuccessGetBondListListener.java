package com.example.myapplication.listener;

import com.example.myapplication.model.BondTO;

import java.util.List;

public interface SuccessGetBondListListener {
    void onSuccessGetBondList(List<BondTO> bondList);
}
