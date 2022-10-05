package tech.reliab.course.chervanevkv.service.impl;

import tech.reliab.course.chervanevkv.bank.entity.CreditAccountService;

import java.util.Date;

public class CreditAccount implements CreditAccountService {
    private int id;
    private int userId;
    private String bankName;
    private Date beginningDate;
    private Date endingDate;
    private int countOfCreditPeriodMonths;
    private double creditSumm;
    private double monthlyPayment;
    private double percentage;
    private int carryingEmployeeID;
    private int userPayAccountNumber;

    public CreditAccount(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Date getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public int getCountOfCreditPeriodMonths() {
        return countOfCreditPeriodMonths;
    }

    public void setCountOfCreditPeriodMonths(int countOfCreditPeriodMonths) {
        this.countOfCreditPeriodMonths = countOfCreditPeriodMonths;
    }

    public double getCreditSumm() {
        return creditSumm;
    }

    public void setCreditSumm(double creditSumm) {
        this.creditSumm = creditSumm;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getCarryingEmployeeID() {
        return carryingEmployeeID;
    }

    public void setCarryingEmployeeID(int carryingEmployeeID) {
        this.carryingEmployeeID = carryingEmployeeID;
    }

    public int getUserPayAccountNumber() {
        return userPayAccountNumber;
    }

    public void setUserPayAccountNumber(int userPayAccountNumber) {
        this.userPayAccountNumber = userPayAccountNumber;
    }
}
