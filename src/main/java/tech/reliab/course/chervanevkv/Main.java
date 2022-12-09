package tech.reliab.course.chervanevkv;

import tech.reliab.course.chervanevkv.bank.service.impl.*;
import tech.reliab.course.chervanevkv.bank.entity.*;
import tech.reliab.course.chervanevkv.bank.service.*;
import tech.reliab.course.chervanevkv.bank.service.impl.*;
import tech.reliab.course.chervanevkv.bank.service.impl.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void printAll(List<Bank> bankList, List<List<BankOffice>> bankOfficeList, List<List<Employee>> employeesList,
                         List<List<BankAtm>> atmList, List<List<User>> userList, List<List<PaymentAccount>> paymentAccountList,
                         List<List<CreditAccount>> creditAccountList){
        for (var bankEmployees:employeesList) {
            for(var employee:bankEmployees) {
                System.out.println(employee);
            }
        }
        for (var bankOffices:bankOfficeList) {
            for(var office:bankOffices) {
                System.out.println(office);
            }
        }
        for (var atms:atmList) {
            for(var atm:atms) {
                System.out.println(atm);
            }
        }

        for (var payments:paymentAccountList) {
            for(var paymentAccount:payments) {
                System.out.println(paymentAccount);
            }
        }
        for (var credits:creditAccountList) {
            for(var creditAccount:credits) {
                System.out.println(creditAccount);
            }
        }
        for (var users:userList) {
            for(var user:users){
                System.out.println(user);
            }
        }
        for (var bank:bankList) {
            System.out.println(bank);
        }
    }
    public static void main(String[] args) {

        BankService bankService = new BankServiceImpl();
        BankOfficeServiceImpl officeService = new BankOfficeServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        BankAtmService atmService = new BankAtmServiceImpl();
        UserService userService = new UserServiceImpl();
        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        CreditAccountService creditAccountService = new CreditAccountServiceImpl();

        List<Bank> bankList = new ArrayList<>();
        bankList.add(bankService.create("Sber"));
        bankList.add(bankService.create("VTB"));
        bankList.add(bankService.create("Otkrytie"));
        bankList.add(bankService.create("Alfabank"));
        bankList.add(bankService.create("Pochtabank"));

        List<List<BankOffice>> bankOfficeList = new ArrayList<>();
        List<List<Employee>> employeesList = new ArrayList<>();
        List<List<BankAtm>> atmList = new ArrayList<>();
        List<List<User>> userList = new ArrayList<>();
        List<List<PaymentAccount>> paymentAccountList = new ArrayList<>();
        List<List<CreditAccount>> creditAccountList = new ArrayList<>();

        for(int j = 0; j < bankList.size(); j++) {
            bankOfficeList.add(new ArrayList<>());
            employeesList.add(new ArrayList<>());
            atmList.add(new ArrayList<>());
            userList.add(new ArrayList<>());
            paymentAccountList.add(new ArrayList<>());
            creditAccountList.add(new ArrayList<>());
            for(int i = 0; i < 3; i++) {
                bankOfficeList.get(j).add(officeService.create("Office" + i, bankList.get(j), "ул. Главная, д.1" + i, 1000. + 100 * i));
                for (int k = 0; k < 5; k++) {
                    employeesList.get(j).add(employeeService.create("Worker", "#" + k, LocalDate.now(), "job", bankList.get(j), bankOfficeList.get(j).get(i), 10000. + 1000 * k));
                    userList.get(j).add(userService.create("Name", "Surname" + i, LocalDate.now(), "job", bankList.get(j)));
                    for (int t = 0; t < 2; t++) {
                        paymentAccountList.get(j).add(paymentAccountService.create(userList.get(j).get(k), bankList.get(j).getName()));
                        creditAccountList.get(j).add(creditAccountService.create(userList.get(j).get(k),bankList.get(j),LocalDate.now(),LocalDate.now(),12,12,1,employeesList.get(j).get(0),paymentAccountList.get(j).get(t)));
                    }
                }
                atmList.get(j).add(atmService.create("atm#" + i, bankList.get(j), bankOfficeList.get(j).get(0), employeesList.get(j).get(0), 1000.));
            }
        }

        printAll(bankList,bankOfficeList,employeesList,atmList,userList,paymentAccountList,creditAccountList);

        for (var bankEmployees:employeesList) {
            for(var employee:bankEmployees) {
                employeeService.delete(employee);
            }
        }
        for (var bankOffices:bankOfficeList) {
            for(var office:bankOffices) {
                officeService.delete(office);
            }
        }
        for (var atms:atmList) {
            for(var atm:atms) {
                atmService.delete(atm);
            }
        }
        for (var payments:paymentAccountList) {
            for(var paymentAccount:payments) {
                paymentAccountService.delete(paymentAccount);
            }
        }
        for (var credits:creditAccountList) {
            for(var creditAccount:credits) {
                creditAccountService.delete(creditAccount);
            }
        }
        for (var users:userList) {
            for(var user:users){
                userService.delete(user);
            }
        }
        for (var bank:bankList) {
            bankService.delete(bank);
        }
    }
}