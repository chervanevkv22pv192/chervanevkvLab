package tech.reliab.course.chervanevkv.service.impl;

import tech.reliab.course.chervanevkv.bank.entity.EmployeeService;

import java.util.Date;

public class Employee implements EmployeeService {
    private int id;
    private String name;
    private Date b_day;
    private String job;
    private int bankId;
    private boolean isWorkingOnline;
    private int bankOfficeId;
    private boolean allowedToGiveCredits;
    private double salary;

    public Employee(){}

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public boolean isWorkingOnline() {
        return isWorkingOnline;
    }

    public void setWorkingOnline(boolean workingOnline) {
        isWorkingOnline = workingOnline;
    }

    public int getBankOfficeId() {
        return bankOfficeId;
    }

    public void setBankOfficeId(int bankOfficeId) {
        this.bankOfficeId = bankOfficeId;
    }

    public boolean getAllowedToGiveCredits() {
        return allowedToGiveCredits;
    }

    public void setAllowedToGiveCredits(boolean allowedToGiveCredits) {
        this.allowedToGiveCredits = allowedToGiveCredits;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
