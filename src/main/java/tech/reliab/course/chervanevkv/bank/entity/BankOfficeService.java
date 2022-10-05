package tech.reliab.course.chervanevkv.bank.entity;

public interface BankOfficeService {
    public int getId();
    public void setId(int id);
    public int getBankId();
    public void setBankId(int bankId);
    public String getName();
    public void setName(String name);
    public String getAddress();
    public void setAddress(String address);
    public boolean isStatus();
    public void setStatus(boolean status);
    public boolean isCanAddATM();
    public void setCanAddATM(boolean canAddATM);
    public int getCurrentATMsCount();
    public void setCurrentATMsCount(int currentATMsCount);
    public boolean isCreditsAvailable();
    public void setCreditsAvailable(boolean creditsAvailable);
    public boolean isGivesMoney();
    public void setGivesMoney(boolean givesMoney);
    public boolean isAcceptsMoney();
    public void setAcceptsMoney(boolean acceptsMoney);
    public double getMoneyCount();
    public void setMoneyCount(double moneyCount);
    public double getRentPrice();
    public void setRentPrice(double rentPrice);
}
