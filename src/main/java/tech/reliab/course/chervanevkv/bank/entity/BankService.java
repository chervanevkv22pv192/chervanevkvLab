package tech.reliab.course.chervanevkv.bank.entity;

import tech.reliab.course.chervanevkv.service.impl.*;

import java.util.Date;

public interface BankService {
    public BankOffice createOffice(
            int officeId, String officeName, String address,
            boolean status, boolean canAddAtm, boolean creditsAvailable,
            boolean givesMoney, boolean acceptsMoney, double rent);
    public BankAtm createAtm(
            BankOffice office, int atmId,
            String atmName, int atmStatus,
            int employeeId, boolean canGiveMoney,
            boolean canAcceptMoney, double servicePrice);
    public Employee createEmployee(
            BankOffice office, int emplId, String emplName,
            Date bday, String job, boolean worksOnline,
            boolean givesCredits, double salary);
    public User createUser(
            int userId, String name, Date bday, String workPlace,
            int[] banksUsed);
    public PaymentAccount createPaymentAccount(int accId, User user);
    public CreditAccount createCreditAccount(
            int accId, User user, Date start, int monthsCount,
            double creditSumm, Employee empl, PaymentAccount payAcc);
    public int getId();
    public void setId(int id);
    public String getName();
    public void setName(String name);
    public int getOfficesCount();
    public void setOfficesCount(int officesCount);
    public int getEmployeeCount();
    public void setEmployeeCount(int employeeCount);
    public int getClientsCount();
    public void setClientsCount(int clientsCount);
    public int getBankRating();
    public void setBankRating(int bankRating);
    public double getMoneyCount();
    public void setMoneyCount(double moneyCount);
    public double getPercentage();
    public void setPercentage(double percentage);
    public int getCurrentATMsCount();
    public void setCurrentATMsCount(int currentATMsCount);
}
