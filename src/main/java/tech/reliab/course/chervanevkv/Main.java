package tech.reliab.course.chervanevkv;

import tech.reliab.course.chervanevkv.bank.service.impl.*;
import tech.reliab.course.chervanevkv.bank.entity.*;
import tech.reliab.course.chervanevkv.bank.service.*;
import tech.reliab.course.chervanevkv.bank.service.impl.*;
import tech.reliab.course.chervanevkv.bank.service.impl.*;
import tech.reliab.course.chervanevkv.bank.exceptions.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static long findBestInterestRateBankId(List<Bank> banks){
        double minInterestRate = banks.get(0).getInterestRate();
        long i = 0;
        long bankId = 0;
        for(Bank bank: banks){
            if(bank.getInterestRate() < minInterestRate){
                minInterestRate = bank.getInterestRate();
                bankId = i;
            }
            i++;
        }
        return bankId;
    }
    public static long findBankIdWithMostAtms(List<Bank> banks){
        double atmCount = banks.get(0).getNumberOfAtms();
        long bankId = 0;
        long i = 0;
        for(Bank bank: banks){
            if(bank.getNumberOfAtms() > atmCount){
                atmCount = bank.getNumberOfAtms();
                bankId = i;
            }
            i++;
        }
        return bankId;
    }
    public static long findBankIdWithMostOffices(List<Bank> banks){
        double officesCount = banks.get(0).getNumberOfOffices();
        long bankId = 0;
        long i = 0;
        for(Bank bank: banks){
            if(bank.getNumberOfOffices() > officesCount){
                officesCount = bank.getNumberOfOffices();
                bankId = i;
            }
            i++;
        }
        return bankId;
    }
    public static BankOffice findOptimalOffice(List<BankOffice> offices, double wantedSum){
        if(wantedSum<=0)
            throw new IncorrectCreditSumException("Credit sum can't be equal to 0 or be less than 0.");
        BankOffice optimalOffice = null;
        for(BankOffice office: offices){
            if(office.isWorking() && (office.getMoneyAmount()>wantedSum) && office.isCanApplyLoan()){
                optimalOffice = office;
                break;
            }
        }
        if(optimalOffice == null)
            throw new NoSuitableOfficesException("There's no working office or no office to issue a loan.");
        return optimalOffice;
    }
    public static Employee chooseEmployeeForCredit(List<Employee> employees, BankOffice office){
        Employee chosenEmployee = null;
        for(var employee: employees){
            if(employee.getBankOffice().equals(office) && employee.isCanApplyLoan())
                chosenEmployee = employee;
            break;
        }
        if(chosenEmployee == null)
            throw new NoAvailableEmployeeException("There's no employee that can serve you.");
        return chosenEmployee;
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
        List<List<PaymentAccount>> paymentAccountList = new ArrayList<>();
        List<List<CreditAccount>> creditAccountList = new ArrayList<>();

        User user = null;
        PaymentAccount payAcc = null;
        CreditAccount creditAcc = null;

        for(int j = 0; j < bankList.size(); j++) {
            bankOfficeList.add(new ArrayList<>());
            employeesList.add(new ArrayList<>());
            atmList.add(new ArrayList<>());
            paymentAccountList.add(new ArrayList<>());
            creditAccountList.add(new ArrayList<>());
            for(int i = 0; i < 3; i++) {
                bankOfficeList.get(j).add(officeService.create("Office" + i, bankList.get(j), "ул. Главная, д.1" + i, 1000. + 100 * i));
                for (int k = 0; k < 5; k++) {
                    employeesList.get(j).add(employeeService.create("Worker", "#" + k, LocalDate.now(), "job", bankList.get(j), bankOfficeList.get(j).get(i), 10000. + 1000 * k));
                }
                atmList.get(j).add(atmService.create("atm#" + i, bankList.get(j), bankOfficeList.get(j).get(0), employeesList.get(j).get(0), 1000.));
            }
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Write down the number of a parameter which is the most important for you:\n1. Interest rate\n2. Count of ATMs\n3. Count of offices");
        long userChoice = -1;
        switch (in.nextInt()) {
            case (1): {userChoice = findBestInterestRateBankId(bankList); break;}
            case (2): {userChoice = findBankIdWithMostAtms(bankList); break;}
            case (3): {userChoice = findBankIdWithMostOffices(bankList); break;}
            default: {userChoice = -1; System.out.println("Incorrect input!");}
        }
        if(userChoice!=-1) {
            Bank bank = bankList.get((int)userChoice);
            double creditSum;
            System.out.println("Insert credit sum: ");
            creditSum = in.nextFloat();
            BankOffice chosenOffice;
            Employee chosenEmployee;
            try {
                chosenOffice = findOptimalOffice(bankOfficeList.get((int)userChoice), creditSum);
                chosenEmployee = chooseEmployeeForCredit(employeesList.get((int)userChoice), chosenOffice);
                user = userService.create("Name", "Surname", LocalDate.now(), "job", bank);
                if((user.getCreditRating()<5000) && (bank.getRating()>50))
                    throw new BankRefusedLoanRequestFromUserException("Your credit rating doesn't suit the bank's rating, choose another bank.");
                payAcc = paymentAccountService.create(user, bank.getName());
                creditAcc = creditAccountService.create(user,bank,LocalDate.now(),LocalDate.now(),12,12,0,chosenEmployee,payAcc);
                System.out.println("Congratulations! You've got a loan of " + String.format("%.2f",creditSum) + " RUB for 12 months!");
            }
            catch (RuntimeException ex){
                System.out.println(ex.getMessage());
            }
        }
        if(user!=null)
            userService.delete((user));
        if(creditAcc!=null)
            creditAccountService.delete((creditAcc));
        if(payAcc!=null)
            paymentAccountService.delete(payAcc);
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
        for (var bank:bankList) {
            bankService.delete(bank);
        }
    }
}