package tech.reliab.course.chervanevkv.bank.service.impl;

import tech.reliab.course.chervanevkv.bank.entity.*;
import tech.reliab.course.chervanevkv.bank.service.CreditAccountService;

import java.time.LocalDate;

public class CreditAccountServiceImpl implements CreditAccountService {
    private Long id = 0L;
    private CreditAccount creditAccount;

    /**
     *
     * @param user - клиент
     * @param bank - банк
     * @param start - дата начала кредита
     * @param end - дата окончания кредита
     * @param month - кол-во месяцев
     * @param sum - сумма кредита
     * @param monthPayment - ежемесячный платеж
     * @param employee - сотрудник выдавший кредит
     * @param paymentAccount - платежный счет
     * @return - возвращает созданный кредитный счет
     */
    @Override
    public CreditAccount create(User user, Bank bank, LocalDate start, LocalDate end, int month,
                                double sum, double monthPayment, Employee employee, PaymentAccount paymentAccount){
        creditAccount = new CreditAccount(
                ++id,
                user,
                bank.getName(),
                start,
                end,
                month,
                sum,
                monthPayment,
                bank.getInterestRate(),
                employee,
                paymentAccount
        );
        user.setCreditAccount(creditAccount);
        return creditAccount;
    }

    /**
     *
     * @return - возвращает объект кредитный счет
     */
    @Override
    public CreditAccount read(){
        return creditAccount;
    }

    /**
     *
     * @param creditAccount - новый кредитный счет
     */
    @Override
    public void update(CreditAccount creditAccount){
        this.creditAccount = creditAccount;
    }

    /**
     *
     * @param creditAccount - кредитный счет для удаления
     */
    @Override
    public void delete(CreditAccount creditAccount){
        if(this.creditAccount == creditAccount){
            this.creditAccount = null;
        }
    }
}
