package tech.reliab.course.chervanevkv.bank.entity;

public interface PaymentAccountService {
    public int getId();
    public void setId(int id);
    public int getClientId();
    public void setClientId(int clientId);
    public String getBankName();
    public void setBankName(String bankName);
    public int getCurrentBalance();
    public void setCurrentBalance(int currentBalance);
    public String toString();
}
