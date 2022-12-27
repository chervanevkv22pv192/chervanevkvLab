package tech.reliab.course.chervanevkv.bank.service.impl;

import tech.reliab.course.chervanevkv.bank.entity.*;
import tech.reliab.course.chervanevkv.bank.exceptions.*;
import tech.reliab.course.chervanevkv.bank.service.BankService;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class BankServiceImpl implements BankService {

    private static  BankServiceImpl INSTANCE;

    private BankServiceImpl(){}

    public static BankServiceImpl getInstance(){
        if (INSTANCE==null){
            INSTANCE = new BankServiceImpl();
        }
        return INSTANCE;
    }

    private Long id = 0L;
    private static Random random = new Random();

    @Override
    public Bank create(String name){
        int rating = random.nextInt(100);
        int money = random.nextInt(200000);
        double rate = (20 - (20 * rating)/100.0);
        var bank = new Bank(
                ++id,
                name,
                rating,
                money,
                rate
        );

        return bank;
    }

    @Override
    public void outputBankInfo(Bank bank){
        System.out.println("Bank:");
        System.out.println("\t"+bank);
        System.out.println("\tOffices:");
        for(var office: bank.getOffices()){
            System.out.println("\t\t"+office);
        }
        System.out.println("\tEmployees:");
        for(var employee: bank.getEmployees()){
            System.out.println("\t\t"+employee);
        }
        System.out.println("\tAtms:");
        for(var atm: bank.getAtms()){
            System.out.println("\t\t"+atm);
        }
        System.out.println("\tUsers:");
        for(var user: bank.getUsers()){
            UserServiceImpl.getInstance().outputUserInfo(user);
        }
    }

    @Override
    public void addOffice(Bank bank, BankOffice office) {
        bank.getOffices().add(office);
    }

    @Override
    public void deleteOffice(Bank bank, BankOffice office){
        if(!bank.getOffices().contains(office)){
            throw new DeletingNULLObjectException("Deleting an object which is deleted already.");
        }
        bank.getOffices().remove(office);
    }

    @Override
    public void addAtm(Bank bank, BankAtm atm) {
        bank.getAtms().add(atm);
    }

    @Override
    public void deleteAtm(Bank bank, BankAtm atm) {
        if(!bank.getAtms().contains(atm)){
            throw new DeletingNULLObjectException("Deleting an object which is deleted already.");
        }
        bank.getAtms().remove(atm);
    }

    @Override
    public void addEmployee(Bank bank, Employee employee) {
        bank.getEmployees().add(employee);
    }

    @Override
    public void deleteEmployee(Bank bank, Employee employee) {
        if(!bank.getEmployees().contains(employee)){
            throw new DeletingNULLObjectException("Deleting an object which is deleted already.");
        }
        bank.getEmployees().remove(employee);
    }

    @Override
    public void addUser(Bank bank, User user) {
        bank.getUsers().add(user);
    }

    @Override
    public void deleteUser(Bank bank, User user) {
        if(!bank.getUsers().contains(user)){
            throw new DeletingNULLObjectException("Deleting an object which is deleted already.");
        }
        bank.getUsers().remove(user);
    }

    @Override
    public List<BankOffice> getOfficesForLoans(Bank bank, double sum) {
        if(sum < 0){
            throw new IncorrectCreditSumException("Credit sum must be above zero.");
        }
        return bank.getOffices().stream().filter(
                office -> office.isCanApplyLoan() && office.getMoneyAmount() > sum && office.isWorking()).toList();
    }

    @Override
    public List<Employee> getEmployeesForLoans(Bank bank, BankOffice office) {
        if(!bank.getOffices().contains(office)){
            throw new NoAvailableEmployeeException("There's no available employee to serve you yet.");
        }
        return bank.getEmployees().stream().filter(
                emp -> emp.getBankOffice().getId().compareTo(office.getId())==0 && emp.isCanApplyLoan()).toList();
    }

}
