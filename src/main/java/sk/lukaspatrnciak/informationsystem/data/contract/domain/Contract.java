package sk.lukaspatrnciak.informationsystem.data.contract.domain;

import sk.lukaspatrnciak.informationsystem.data.user.domain.User;

import java.util.Date;

public abstract class Contract {
    public String contractId;
    Date createDate;
    User insurer;
    long insurerId;
    Date startInsur = new Date();
    Date stopInsur = new Date();
    public double insurenceAmmount;
    public double monthlyPayment;

    public Contract(String contractId, User insurer, Date startInsur, Date stopInsur, double insurenceAmmount, double monthlyPayment) {
        setContractId(contractId);
        setInsurer(insurer);
        setInsurerId(insurer);
        setCreateDate();
        setStartInsur(startInsur);
        setStopInsur(stopInsur);
        setInsurenceAmmount(insurenceAmmount);
        setMonthlyPayment(monthlyPayment);
    }

    // Setters
    public void setContractId(String contractId) {
        if (contractId == null || contractId.isEmpty()) {
            throw new IllegalArgumentException("[ ! ] Neplatne ID zmluvy");
        }

        this.contractId = contractId;
    }

    public void setCreateDate() {
        this.createDate = new Date();
    }

    public void setInsurer(User insurer) {
        if (insurer == null) {
            throw new IllegalArgumentException("[ ! ] Neplatny nazov poistovatela");
        }

        this.insurer = insurer;
    }

    public void setInsurerId(User insurer) {
        this.insurerId = insurer.getUserId();
    }

    public void setStartInsur(Date startInsur) {
        this.startInsur = startInsur;
    }

    public void setStopInsur(Date stopInsur) {
        this.stopInsur = stopInsur;
    }

    public void setInsurenceAmmount(double insurenceAmmount) {
        if(monthlyPayment < 0) {
            throw new IllegalArgumentException("[ ! ] Neplatne zadana vyska poistneho");
        }

        this.insurenceAmmount = insurenceAmmount;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        if(monthlyPayment < 0) {
            throw new IllegalArgumentException("[ ! ] Neplatne zadana mesacna splatka");
        }

        this.monthlyPayment = monthlyPayment;
    }

    // Getters
    public String getContractId() {
        return contractId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public User getInsurer() {
        return insurer;
    }

    public long getInsurerId() {
        return insurerId;
    }

    public Date getStartInsur() {
        return startInsur;
    }

    public Date getStopInsur() {
        return stopInsur;
    }

    public double getInsurenceAmmount() { return insurenceAmmount; }

    public double getMonthlyPayment() { return monthlyPayment; }
}