package tech.reliab.course.chervanevkv.bank.service.impl;

import tech.reliab.course.chervanevkv.bank.entity.*;
import tech.reliab.course.chervanevkv.bank.service.CreditAccountService;

import java.time.LocalDate;

public class CreditAccountServiceImpl implements CreditAccountService {
    private static  CreditAccountServiceImpl INSTANCE;

    private CreditAccountServiceImpl(){}

    public static CreditAccountServiceImpl getInstance(){
        if (INSTANCE==null){
            INSTANCE = new CreditAccountServiceImpl();
        }
        return INSTANCE;
    }
    private Long id = 0L;


    @Override
    public CreditAccount create(User user, Bank bank, LocalDate start, LocalDate end, int month,
                                double sum, double monthPayment, Employee employee, PaymentAccount paymentAccount){
        var creditAccount = new CreditAccount(
                ++id,
                user,
                bank,
                start,
                end,
                month,
                sum,
                monthPayment,
                bank.getInterestRate(),
                employee,
                paymentAccount
        );
        user.getCreditAccounts().add(creditAccount);
        return creditAccount;
    }

}