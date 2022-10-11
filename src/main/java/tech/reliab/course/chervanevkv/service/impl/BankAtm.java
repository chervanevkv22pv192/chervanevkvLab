package tech.reliab.course.chervanevkv.service.impl;

import tech.reliab.course.chervanevkv.bank.entity.AtmService;

public class BankAtm implements AtmService {
    private int id;
    private String name;
    private String address;
    private int status; //-1 нет денег, 0 не работает, 1 работет
    private int bankId;
    private int officeId;
    private int carryingEmployeeId;
    private boolean isAbleToGiveMoney;
    private boolean isAbleToAcceptMoney;
    private double moneyCount;
    private double servicePrice;


    public BankAtm(double money, int bankID, String atmAddress){
        address = atmAddress;
        bankId = bankID;
        moneyCount = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getStatus() {return status;}

    public void setStatus(int status) {this.status = status;}

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getOfficeId() {return officeId;}

    public void setOfficeId(int officeId) {this.officeId = officeId;}

    public int getCarryingEmployeeId() {
        return carryingEmployeeId;
    }

    public void setCarryingEmployeeId(int carryingEmployeeId) {
        this.carryingEmployeeId = carryingEmployeeId;
    }

    public boolean isAbleToGiveMoney() {
        return isAbleToGiveMoney;
    }

    public void setAbleToGiveMoney(boolean ableToGiveMoney) {
        isAbleToGiveMoney = ableToGiveMoney;
    }

    public boolean isAbleToAcceptMoney() {
        return isAbleToAcceptMoney;
    }

    public void setAbleToAcceptMoney(boolean ableToAcceptMoney) {
        isAbleToAcceptMoney = ableToAcceptMoney;
    }

    public double getMoneyCount() {
        return moneyCount;
    }

    public void setMoneyCount(double moneyCount) {
        this.moneyCount = moneyCount;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String toString(){
        String statusMeaning = "";
        if(status == -1) statusMeaning = "нет наличных для выдачи";
        else if(status == 0) statusMeaning = "не работает";
        else statusMeaning = "работает в штатном режиме";
        return "Банкомат " + name + " по адресу " + address + ", "
                + statusMeaning + (isAbleToAcceptMoney? ", " : ", не ") + "принимет наличные"
                + (isAbleToGiveMoney? ", " : ", не ") + "выдает наличные"
                + ", банкомат может выдать до " + moneyCount + " руб."
                + ", цена обслуживания банкомата - " + servicePrice + " руб.";
    }
}
