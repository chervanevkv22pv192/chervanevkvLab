package tech.reliab.course.chervanevkv.bank.entity;

import java.util.Date;

public interface UserService {
    public int getId();
    public void setId(int id);
    public String getName();
    public void setName(String name);
    public Date getB_day();
    public void setB_day(Date b_day);
    public String getWorkPlace();
    public void setWorkPlace(String workPlace);
    public int getSalary();
    public void setSalary(int salary);
    public int[] getUsedBanksId();
    public void setUsedBanksId(int[] usedBanksId);
    public int[] getCreditAccountsId();
    public void setCreditAccountsId(int[] creditAccountsId);
    public int[] getPaymentAccountsId();
    public void setPaymentAccountsId(int[] paymentAccountsId);
    public int getCreditRating();
    public void setCreditRating(int creditRating);
    public String toString();
}
