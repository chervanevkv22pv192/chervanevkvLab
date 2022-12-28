package tech.reliab.course.chervanevkv;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tech.reliab.course.chervanevkv.bank.service.impl.*;
import tech.reliab.course.chervanevkv.bank.entity.*;
import tech.reliab.course.chervanevkv.bank.service.*;
import tech.reliab.course.chervanevkv.bank.service.impl.*;
import tech.reliab.course.chervanevkv.bank.service.impl.*;
import tech.reliab.course.chervanevkv.bank.exceptions.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

        creditAccountService.create(
                user,
                bankList.get(0),
                LocalDate.now(),
                LocalDate.now(),
                12,
                12000,
                1000,
                bankService.getEmployeeById(bankList.get(0), 1),
                paymentAccountService.create(user,bankList.get(0))
        );
        creditAccountService.create(
                user,
                bankList.get(1),
                LocalDate.now(),
                LocalDate.now(),
                12,
                12000,
                1000,
                bankService.getEmployeeById(bankList.get(1), 20),
                paymentAccountService.create(user,bankList.get(1))
        );
        creditAccountService.create(
                user,
                bankList.get(1),
                LocalDate.now(),
                LocalDate.now(),
                12,
                12000,
                1000,
                bankService.getEmployeeById(bankList.get(1), 20),
                paymentAccountService.create(user,bankList.get(1))
        );
        for (var x:
             user.getPaymentAccounts()) {
            System.out.println(x);
        }
        for (var x:
                user.getCreditAccounts()) {
            System.out.println(x);
        }
        Scanner in = new Scanner(System.in);
        int fromBankId = 1, toBankId = 1;
        System.out.println("\nChoose a bank you'd like to move accounts from:");
        for (var b:
             user.getBanks()) {
            System.out.println("#"+b.getId()+". "+b.getName());
        }
        fromBankId = in.nextInt();
        System.out.println("\nChoose a bank you'd like to move accounts to:");
        for (var b:
                bankList) {
            System.out.println("#"+b.getId()+". "+b.getName());
        }
        toBankId = in.nextInt();
        if(toBankId==fromBankId){
            System.out.println("The source bank and the destination bank should be different.");
        }
        else try{
            fromBankId--;
            toBankId--;
            FileWriter payAccsFile = new FileWriter("userPayAccs.json", false);
            FileWriter creditAccsFile = new FileWriter("userCreditAccs.json", false);
            payAccsFile.write(user.getPayAccsAsJSONArray(bankList.get(fromBankId).getName()).toJSONString());
            payAccsFile.close();
            creditAccsFile.write(user.getCreditAccsAsJSONArray(bankList.get(fromBankId).getName()).toJSONString());
            creditAccsFile.close();
            System.out.println("Choose an employee in the destination bank who will manage your accounts:");
            for (Employee employee:
                 bankList.get(toBankId).getEmployees()) {
                    System.out.println("#"+employee.getId()+". "+employee);
            }
            int employeeId = in.nextInt();
            JSONParser jsonParser = new JSONParser();
            JSONArray payAccsJSONArray = new JSONArray();
            JSONArray creditAccsJSONArray = new JSONArray();
            try(FileReader readerPayAccs = new FileReader("userPayAccs.json"); FileReader readerCreditAccs = new FileReader("userCreditAccs.json")){
                Object obj = jsonParser.parse(readerPayAccs);
                payAccsJSONArray = (JSONArray) obj;
                jsonParser = new JSONParser();
                obj = jsonParser.parse(readerCreditAccs);
                creditAccsJSONArray = (JSONArray) obj;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            for(int i = 0; i < payAccsJSONArray.size(); i++){
                JSONObject payAcc = (JSONObject)((JSONObject)payAccsJSONArray.get(i)).get("payAcc");
                JSONObject creditAcc = (JSONObject)((JSONObject)creditAccsJSONArray.get(i)).get("creditAcc");
                var newPayAcc = paymentAccountService.create(user,bankList.get(toBankId));
                newPayAcc.setSum((double)payAcc.get("sum"));
                creditAccountService.create(
                        user,
                        bankList.get(toBankId),
                        LocalDate.parse((String)creditAcc.get("start")),
                        LocalDate.parse((String)creditAcc.get("end")),
                        Integer.parseInt(creditAcc.get("monthNumber").toString()),
                        (double)creditAcc.get("sum"),
                        (double)creditAcc.get("monthPayment"),
                        bankService.getEmployeeById(bankList.get(toBankId), employeeId),
                        newPayAcc
                );
                paymentAccountService.delete(user, Integer.parseInt(payAcc.get("id").toString()));
                creditAccountService.delete(user, Integer.parseInt(creditAcc.get("id").toString()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Current state of accounts:");
        for (var x:
                user.getPaymentAccounts()) {
            System.out.println(x);
        }
        for (var x:
                user.getCreditAccounts()) {
            System.out.println(x);
        }
    }
}