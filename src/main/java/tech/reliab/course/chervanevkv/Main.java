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
    public static void main(String[] args) {

        BankService bankService = BankServiceImpl.getInstance();
        BankOfficeServiceImpl officeService = BankOfficeServiceImpl.getInstance();
        EmployeeService employeeService = EmployeeServiceImpl.getInstance();
        BankAtmService atmService = BankAtmServiceImpl.getInstance();
        UserService userService = UserServiceImpl.getInstance();
        PaymentAccountService paymentAccountService = PaymentAccountServiceImpl.getInstance();
        CreditAccountService creditAccountService = CreditAccountServiceImpl.getInstance();

        List<Bank> bankList = new ArrayList<>();
        bankList.add(bankService.create("Sber"));
        bankList.add(bankService.create("VTB"));
        bankList.add(bankService.create("Otkrytie"));
        bankList.add(bankService.create("Alfabank"));
        bankList.add(bankService.create("Pochtabank"));

        for(int j = 0; j < bankList.size(); j++) {
            for(int i = 0; i < 3; i++) {
                BankOffice office = officeService.create("Office" + i, bankList.get(j), "ул. Главная, д.1" + i, 1000. + 100 * i);
                for (int k = 0; k < 5; k++) {
                    Employee employee = employeeService.create("Worker", "#" + k, LocalDate.now(), "job", bankList.get(j), office, 10000. + 1000 * k);
                    atmService.create("atm#" + i, bankList.get(j), office, employee, 1000.);
                }
            }
        }
        User user = userService.create("User", "User", LocalDate.now(), "job");
        try{
            bankList.sort(new BankComparator());
            Scanner reader = new Scanner(System.in);
            System.out.println("Input credit sum: ");
            double sum = reader.nextDouble();
            if(sum<=0){
                throw new IncorrectCreditSumException("Credit sum must be above 0.");
            }
            System.out.println("Choose a bank you'd like to get credit in:");
            for(int i=0; i<bankList.size(); i++){
                System.out.println("#"+i+". "+bankList.get(i).getName());
            }
            int indexOfBank = reader.nextInt();
            Bank bank = bankList.get(indexOfBank);
            if(bank.getMoneyAmount()<sum){
                throw new BankRefusedLoanRequestFromUserException("Sorry, there's no such sum of money at the chosen bank.");
            }
            if(bank.getOffices().isEmpty()){
                throw new NoSuitableOfficesException("No offices in this bank.");
            }
            System.out.println("Choose an office:");
            List<BankOffice> offices = bankService.getOfficesForLoans(bank,sum);
            for(int i=0; i<bank.getOffices().size(); i++){
                System.out.println("#" + i + ". " + offices.get(i));
            }
            int indexOfOffice = reader.nextInt();
            BankOffice office = offices.get(indexOfOffice);
            if(office.getMoneyAmount()<=sum){
                throw new BankRefusedLoanRequestFromUserException("Sorry, there's no such sum of money at the chosen office.");
            }
            List<Employee> employees = bankService.getEmployeesForLoans(bank, office);
            if(employees.isEmpty()){
                throw new NoAvailableEmployeeException("No available employee in this office.");
            }
            for(int i=0; i<employees.size(); i++){
                System.out.println("#" + i + ". " + employees.get(i));
            }
            System.out.println("Choose an employee who will serve you:");
            int indexOfEmployee = reader.nextInt();
            Employee employee = employees.get(indexOfEmployee);
            List<BankAtm> atms = officeService.getAtmsForLoans(office, sum);
            if(atms.isEmpty()){
                throw new NoSuitableOfficesException("No atms in this office.");
            }
            if((user.getCreditRating() < 5000) && (bank.getRating() > 50)){
                throw new BankRefusedLoanRequestFromUserException("Your credit rating is " + user.getCreditRating() + " and the bank's rating is " +bank.getRating() + ", according to this, the bank refused your request.");
            }
            if(!user.getBanks().contains(bank)){
                bankService.addUser(bank, user);
                paymentAccountService.create(user,bank);
            }
            int month = (LocalDate.now().getMonthValue()+6)%12;
            CreditAccount creditAccount = creditAccountService.create(
                    user,
                    bank,
                    LocalDate.now(),
                    LocalDate.now(),
                    month,
                    sum,
                    sum/6,
                    employee,
                    user.getPaymentAccounts().stream().filter(
                            pay -> pay.getBank().getId().compareTo(bank.getId())==0).findFirst().get()
            );
            atmService.withdrawMoney(atms.get(0), sum);
            System.out.println("Congratulations! You've got a loan of " + String.format("%.2f",sum) + " RUB for 6 months!");
        }
        catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }


    }
}