package tech.reliab.course.chervanevkv.service.impl;

import tech.reliab.course.chervanevkv.bank.entity.BankService;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Bank implements BankService{
    private int id;
    private String name;
    private int officesCount;
    private int employeeCount;
    private int clientsCount;
    private int bankRating;
    private double moneyCount;
    private double percentage;
    private int currentATMsCount;

    public Bank(int id, String name){
        Random rand = new Random();
        this.id = id;
        this.name = name;
        officesCount = 0;
        currentATMsCount = 0;
        employeeCount = 0;
        clientsCount = 0;
        bankRating = rand.nextInt() % 100;
        moneyCount = rand.nextInt() % 1000000;
        percentage = (101-bankRating)/10.0 + 10.0/rand.nextDouble();
    }

    public BankOffice createOffice(
            int officeId, String officeName, String address,
            boolean status, boolean canAddAtm, boolean creditsAvailable,
            boolean givesMoney, boolean acceptsMoney, double rent){
        BankOffice office = new BankOffice();
        office.setId(officeId);
        office.setBankId(id);
        office.setName(officeName);
        office.setAddress(address);
        office.setStatus(status);
        office.setCanAddATM(canAddAtm);
        office.setCurrentATMsCount(0);
        office.setCreditsAvailable(creditsAvailable);
        office.setGivesMoney(givesMoney);
        office.setAcceptsMoney(acceptsMoney);
        office.setMoneyCount(moneyCount);
        office.setRentPrice(rent);
        officesCount++;
        return office;
    }

    public Employee createEmployee(
            BankOffice office, int emplId, String emplName,
            Date bday, String job, boolean worksOnline,
            boolean givesCredits, double salary){
        Employee employee = new Employee();
        employee.setId(emplId);
        employee.setName(emplName);
        employee.setB_day(bday);
        employee.setJob(job);
        employee.setBankId(id);
        employee.setWorkingOnline(worksOnline);
        employee.setBankOfficeId(office.getId());
        employee.setAllowedToGiveCredits(givesCredits);
        employee.setSalary(salary);
        employeeCount++;
        return employee;
    }

    public User createUser(
            int userId, String name, Date bday, String workPlace,
            int[] banksUsed){
        User user = new User();
        user.setId(userId);
        user.setName(name);
        user.setB_day(bday);
        user.setWorkPlace(workPlace);
        user.setUsedBanksId(banksUsed);
        clientsCount++;
        return user;
    }

    public BankAtm createAtm(
            BankOffice office, int atmId,
            String atmName, int atmStatus,
            int employeeId, boolean canGiveMoney,
            boolean canAcceptMoney, double servicePrice){
        BankAtm atm = new BankAtm(moneyCount, id, office.getAddress());
        atm.setId(atmId);
        atm.setName(atmName);
        atm.setStatus(atmStatus);
        atm.setOfficeId(office.getId());
        atm.setCarryingEmployeeId(employeeId);
        atm.setAbleToGiveMoney(canGiveMoney);
        atm.setAbleToGiveMoney(canAcceptMoney);
        atm.setMoneyCount(moneyCount);
        atm.setServicePrice(servicePrice);
        currentATMsCount++;
        office.setCurrentATMsCount(office.getCurrentATMsCount()+1);
        return atm;
    }

    public PaymentAccount createPaymentAccount(int accId, User user){
        PaymentAccount acc = new PaymentAccount();
        acc.setId(accId);
        acc.setClientId(user.getId());
        acc.setBankName(name);
        acc.setCurrentBalance(0);
        return acc;
    }

    public CreditAccount createCreditAccount(
            int accId, User user, Date start, int monthsCount,
            double creditSumm, Employee empl, PaymentAccount payAcc){
        CreditAccount acc = new CreditAccount();
        acc.setId(accId);
        acc.setUserId(user.getId());
        acc.setBankName(name);
        acc.setBeginningDate(start);
        Calendar ending = Calendar.getInstance();
        ending.setTime(start);
        ending.add(Calendar.MONTH, monthsCount);
        acc.setEndingDate(ending.getTime());
        acc.setCountOfCreditPeriodMonths(monthsCount);
        acc.setCreditSumm(creditSumm);
        acc.setMonthlyPayment(creditSumm/monthsCount);
        acc.setPercentage(percentage);
        acc.setCarryingEmployeeID(empl.getId());
        acc.setUserPayAccountNumber(payAcc.getId());
        return acc;
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

    public int getOfficesCount() {return officesCount;}

    public void setOfficesCount(int officesCount) {
        this.officesCount = officesCount;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public int getClientsCount() {return clientsCount;}

    public void setClientsCount(int clientsCount) {
        this.clientsCount = clientsCount;
    }

    public int getBankRating() {
        return bankRating;
    }

    public void setBankRating(int bankRating) {
        this.bankRating = bankRating;
    }

    public double getMoneyCount() {
        return moneyCount;
    }

    public void setMoneyCount(double moneyCount) {
        this.moneyCount = moneyCount;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getCurrentATMsCount() {
        return currentATMsCount;
    }

    public void setCurrentATMsCount(int currentATMsCount) {
        this.currentATMsCount = currentATMsCount;
    }
}
