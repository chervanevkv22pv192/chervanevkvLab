package tech.reliab.course.chervanevkv.bank.entity;

import java.util.Date;

public interface CreditAccountService {
    public int getId();
    public void setId(int id);
    public int getUserId();
    public void setUserId(int userId);
    public String getBankName();
    public void setBankName(String bankName);
    public Date getBeginningDate();
    public void setBeginningDate(Date beginningDate);
    public Date getEndingDate();
    public void setEndingDate(Date endingDate);
    public int getCountOfCreditPeriodMonths();
    public void setCountOfCreditPeriodMonths(int countOfCreditPeriodMonths);
    public double getCreditSumm();
    public void setCreditSumm(double creditSumm);
    public double getMonthlyPayment();
    public void setMonthlyPayment(double monthlyPayment);
    public double getPercentage();
    public void setPercentage(double percentage);
    public int getCarryingEmployeeID();
    public void setCarryingEmployeeID(int carryingEmployeeID);
    public int getUserPayAccountNumber();
    public void setUserPayAccountNumber(int userPayAccountNumber);
}
