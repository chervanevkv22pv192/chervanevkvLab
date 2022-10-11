package tech.reliab.course.chervanevkv;
//import sun.util.calendar.BaseCalendar;
import tech.reliab.course.chervanevkv.service.impl.*;
import java.io.Console;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.*;
import java.sql.Date;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(0,"Sber");
        BankOffice office = bank.createOffice(0,"Родина", "Свято-Троицкий бульвар", true, true, true, true, true, 10000.0);
        Employee employee = bank.createEmployee(office,0,"Раз Два Готово", new Date(90,1,19), "Консультант", false, true, 30000.0);
        BankAtm atm = bank.createAtm(office,0,"Первый", 1, employee.getId(), true, true, 1000.0);
        User user = bank.createUser(0,"Петров Петр Петрович", new Date(92,2,12), "Palanga in Lithuania", null);
        PaymentAccount payAcc = bank.createPaymentAccount(0, user);
        CreditAccount creditAcc = bank.createCreditAccount(0,user, new Date(122,3,20), 10, 20500.0, employee, payAcc);
        System.out.println(bank.toString());
        System.out.println(office.toString());
        System.out.println(employee.toString());
        System.out.println(atm.toString());
        System.out.println(user.toString());
        System.out.println(payAcc.toString());
        System.out.println(creditAcc.toString());

    }
}
