package tech.reliab.course.chervanevkv.bank.service.impl;

import tech.reliab.course.chervanevkv.bank.entity.User;
import tech.reliab.course.chervanevkv.bank.entity.PaymentAccount;
import tech.reliab.course.chervanevkv.bank.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    private Long id = 0L;
    private PaymentAccount paymentAccount;

    /**
     *
     * @param user - клиент
     * @param bankName - имя банка
     * @return - возвращает созданный объект платежный счет
     */
    @Override
    public PaymentAccount create(User user, String bankName){
        paymentAccount = new PaymentAccount(
                ++id,
                user,
                bankName,
                0
        );
        user.setPaymentAccount(paymentAccount);
        return paymentAccount;
    }

    /**
     *
     * @return - возвращает платежный счет
     */
    @Override
    public PaymentAccount read(){
        return paymentAccount;
    }

    /**
     *
     * @param paymentAccount - новый платежный счет
     */
    @Override
    public void update(PaymentAccount paymentAccount){
        this.paymentAccount = paymentAccount;
    }

    /**
     *
     * @param paymentAccount - платежный счет для удаления
     */
    @Override
    public void delete(PaymentAccount paymentAccount){
        if(this.paymentAccount == paymentAccount){
            this.paymentAccount = null;
        }
    }
}
