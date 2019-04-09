package com.example.myapplication.model;

public class BondListViewItem {
    private Long debtor_id;
    private String name;
    private Integer calculatedBond;

    public Long getDebtor_id() {
        return debtor_id;
    }

    public void setDebtor_id(Long debtor_id) {
        this.debtor_id = debtor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalculatedBond() {
        return calculatedBond;
    }

    public void setCalculatedBond(Integer calculatedBond) {
        this.calculatedBond = calculatedBond;
    }
}