package tech.reliab.course.chervanevkv.bank.entity;

public interface AtmService {
    public int getId();
    public void setId(int id);
    public String getName();
    public void setName(String name);
    public String getAddress();
    public void setAddress(String address);
    public int getStatus();
    public void setStatus(int status);
    public int getBankId();
    public void setBankId(int bankId);
    public int getOfficeId();
    public void setOfficeId(int officeId);
    public int getCarryingEmployeeId();
    public void setCarryingEmployeeId(int carryingEmployeeId);
    public boolean isAbleToGiveMoney();
    public void setAbleToGiveMoney(boolean ableToGiveMoney);
    public boolean isAbleToAcceptMoney();
    public void setAbleToAcceptMoney(boolean ableToAcceptMoney);
    public double getMoneyCount();
    public void setMoneyCount(double moneyCount);
    public double getServicePrice();
    public void setServicePrice(double servicePrice);
}
