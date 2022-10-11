package tech.reliab.course.chervanevkv.bank.entity;

import java.util.Date;

public interface EmployeeService {
    public int getId();
    public void setId(int id);
    public String getName();
    public void setName(String name);
    public Date getB_day();
    public void setB_day(Date b_day);
    public String getJob();
    public void setJob(String job);
    public int getBankId();
    public void setBankId(int bankId);
    public boolean isWorkingOnline();
    public void setWorkingOnline(boolean workingOnline);
    public int getBankOfficeId();
    public void setBankOfficeId(int bankOfficeId);
    public boolean getAllowedToGiveCredits();
    public void setAllowedToGiveCredits(boolean allowedToGiveCredits);
    public double getSalary();
    public void setSalary(double salary);
    public String toString();
}
