package tech.reliab.course.chervanevkv.bank.service;

import tech.reliab.course.chervanevkv.bank.entity.Bank;
import tech.reliab.course.chervanevkv.bank.entity.User;
import tech.reliab.course.chervanevkv.bank.entity.PaymentAccount;


public interface PaymentAccountService {
    /**
     *
     * @param user - ������
     * @param bank -  �����
     * @return - ���������� ��������� ������ ��������� ����
     */
    PaymentAccount create(User user, Bank bank);

}
