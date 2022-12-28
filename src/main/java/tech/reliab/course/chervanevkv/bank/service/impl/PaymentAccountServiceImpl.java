package tech.reliab.course.chervanevkv.bank.service.impl;

import tech.reliab.course.chervanevkv.bank.entity.Bank;
import tech.reliab.course.chervanevkv.bank.entity.User;
import tech.reliab.course.chervanevkv.bank.entity.PaymentAccount;
import tech.reliab.course.chervanevkv.bank.service.PaymentAccountService;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    private static  PaymentAccountServiceImpl INSTANCE;

    private PaymentAccountServiceImpl(){}

    public static PaymentAccountServiceImpl getInstance(){
        if (INSTANCE==null){
            INSTANCE = new PaymentAccountServiceImpl();
        }
        return INSTANCE;
    }

    private Long id = 0L;


    @Override
    public PaymentAccount create(User user, Bank bank){
        var paymentAccount = new PaymentAccount(
                ++id,
                user,
                bank,
                0
        );
        if(!user.getBanks().contains(bank)){
            user.addBank(bank);
        }
        user.getPaymentAccounts().add(paymentAccount);
        return paymentAccount;
    }
    @Override
    public void delete(User user, int accId){
        Iterator<PaymentAccount> it = user.getPaymentAccounts().iterator();
        while(it.hasNext()){
            PaymentAccount acc = it.next();
            if(acc.getId()==accId)
                it.remove();
        }
    }


}
