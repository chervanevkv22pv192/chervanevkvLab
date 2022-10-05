package tech.reliab.course.chervanevkv.service.impl;

import tech.reliab.course.chervanevkv.bank.entity.UserService;

import java.util.Date;
import java.util.Random;

public class User implements UserService {
    private int id;
    private String name;
    private Date b_day;
    private String workPlace;
    private int salary;
    private int[] usedBanksId;
    private int[] creditAccountsId;
    private int[] paymentAccountsId;
    private int creditRating;

    public User(){
        Random rand = new Random();
        salary = rand.nextInt()%10000;
        creditRating = rand.nextInt()%(int)(salary/10);

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

    public Date getB_day() {
        return b_day;
    }

    public void setB_day(Date b_day) {
        this.b_day = b_day;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int[] getUsedBanksId() {
        return usedBanksId;
    }

    public void setUsedBanksId(int[] usedBanksId) {
        this.usedBanksId = usedBanksId;
    }

    public int[] getCreditAccountsId() {
        return creditAccountsId;
    }

    public void setCreditAccountsId(int[] creditAccountsId) {
        this.creditAccountsId = creditAccountsId;
    }

    public int[] getPaymentAccountsId() {
        return paymentAccountsId;
    }

    public void setPaymentAccountsId(int[] paymentAccountsId) {
        this.paymentAccountsId = paymentAccountsId;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }
}
