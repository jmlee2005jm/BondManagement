package com.example.myapplication.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class BondListViewAdapter extends BaseAdapter {

    private List<BondTO> bondListViewItemList = new ArrayList<BondTO>();

    public BondListViewAdapter(List<BondTO> bondListViewItemList) {
        this.bondListViewItemList = bondListViewItemList;
    }

    @Override
    public int getCount() {
        return bondListViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return bondListViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.bondlistview_item, parent, false);
        }

        TextView debtorNameTextView = (TextView) convertView.findViewById(R.id.debtorNameText);
        TextView calculatedBondTextView = (TextView) convertView.findViewById(R.id.calculatedBondText);

        BondTO bondListViewItem = bondListViewItemList.get(position);

        debtorNameTextView.setText(bondListViewItem.getDebtorName());
        calculatedBondTextView.setText(bondListViewItem.getCalculatedBond().toString());

        return convertView;
    }

    public void addItem(Long debtorId, String name, Integer calculatedBond) {
        BondTO bondListViewItem = new BondTO();

        bondListViewItem.setDebtorId(debtorId);
        bondListViewItem.setDebtorName(name);
        bondListViewItem.setCalculatedBond(calculatedBond);

        bondListViewItemList.add(bondListViewItem);
    }
}