package com.example.myapplication.model;

public class BondTO {

    private Long creditorId;
    private Long debtorId;
    private String debtorName;
    private Integer calculatedBond;

    public Long getCreditorId() {
        return creditorId;
    }

    public void setCreditorId(Long creditorId) {
        this.creditorId = creditorId;
    }

    public Long getDebtorId() {
        return debtorId;
    }

    public void setDebtorId(Long debtorId) {
        this.debtorId = debtorId;
    }

    public String getDebtorName() {
        return debtorName;
    }

    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName;
    }

    public Integer getCalculatedBond() {
        return calculatedBond;
    }

    public void setCalculatedBond(Integer calculatedBond) {
        this.calculatedBond = calculatedBond;
    }
}
