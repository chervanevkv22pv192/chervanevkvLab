package tech.reliab.course.chervanevkv.service.impl;

import tech.reliab.course.chervanevkv.bank.entity.PaymentAccountService;

public class PaymentAccount implements PaymentAccountService {
    private int id;
    private int clientId;
    private String bankName;
    private int currentBalance;

    public PaymentAccount(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }
    public String toString(){
        return "Платежный счет в банке " + bankName + ", баланс - " + currentBalance + " руб.";
    }
}
