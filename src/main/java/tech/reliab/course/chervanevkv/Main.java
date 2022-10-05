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
        Employee employee = bank.createEmployee(office,0,"Раз Два Готово", new Date(1,1,1990), "Консультант", false, true, 30000.0);
        BankAtm atm = bank.createAtm(office,0,"Первый", 1, employee.getId(), true, true, 1000.0);
        User user = bank.createUser(0,"Петров Петр Петрович", new Date(2,2,1992), "Palanga in Lithuania", null);
        PaymentAccount payAcc = bank.createPaymentAccount(0, user);
        CreditAccount creditAcc = bank.createCreditAccount(0,user, new Date(3,3,2022), 10, 20500.0, employee, payAcc);
        System.out.println("В банке " + bank.getName() + " есть офис " + office.getName() + " по адресу " + office.getAddress());
        System.out.println("В этом офисе стоит банкомат " + atm.getName() + ", с него можно снять до " + atm.getMoneyCount() + " руб.");
        System.out.println("В офисе работает " + employee.getName() + ", у которого " + user.getName() + " оформил кредит");
        System.out.println("Кредит был на сумму " + creditAcc.getCreditSumm() + " на " + creditAcc.getCountOfCreditPeriodMonths() + " мес.");

    }
}
