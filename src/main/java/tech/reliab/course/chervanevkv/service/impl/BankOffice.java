package tech.reliab.course.chervanevkv.service.impl;

import tech.reliab.course.chervanevkv.bank.entity.BankOfficeService;

public class BankOffice implements BankOfficeService {
    private int id;
    private int bankId;
    private String name;
    private String address;
    private boolean status;
    private boolean canAddATM;
    private int currentATMsCount;
    private boolean creditsAvailable;
    private boolean givesMoney;
    private boolean acceptsMoney;
    private double moneyCount;
    private double rentPrice;

    public BankOffice(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isCanAddATM() {
        return canAddATM;
    }

    public void setCanAddATM(boolean canAddATM) {
        this.canAddATM = canAddATM;
    }

    public int getCurrentATMsCount() {
        return currentATMsCount;
    }

    public void setCurrentATMsCount(int currentATMsCount) {
        this.currentATMsCount = currentATMsCount;
    }

    public boolean isCreditsAvailable() {
        return creditsAvailable;
    }

    public void setCreditsAvailable(boolean creditsAvailable) {
        this.creditsAvailable = creditsAvailable;
    }

    public boolean isGivesMoney() {
        return givesMoney;
    }

    public void setGivesMoney(boolean givesMoney) {
        this.givesMoney = givesMoney;
    }

    public boolean isAcceptsMoney() {
        return acceptsMoney;
    }

    public void setAcceptsMoney(boolean acceptsMoney) {
        this.acceptsMoney = acceptsMoney;
    }

    public double getMoneyCount() {
        return moneyCount;
    }

    public void setMoneyCount(double moneyCount) {
        this.moneyCount = moneyCount;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }
    public String toString(){
        return "Офис " + name + " по адресу " + address
                + (status? ", работает" : ", не работает")
                + (canAddATM? ", может разместить банкомат" : ", нет места для банкомата")
                + (creditsAvailable? ", выдает кредиты" : ", кредиты недоступны")
                + (givesMoney? ", выдает наличные" : "не выдает наличные")
                + (acceptsMoney? ", принимает наличные" : "не принимает наличные")
                + ", количество денег в офисе - " + moneyCount + " руб."
                + ", стоимость аренды - " + rentPrice + " руб.";
    }
}
