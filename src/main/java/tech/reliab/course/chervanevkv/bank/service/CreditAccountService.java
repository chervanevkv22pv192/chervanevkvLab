package tech.reliab.course.chervanevkv.bank.service;

import tech.reliab.course.chervanevkv.bank.entity.*;

import java.time.LocalDate;

public interface CreditAccountService {
    /**
     *
     * @param user - ������
     * @param bank - ����
     * @param start - ���� ������ �������
     * @param end - ���� ��������� �������
     * @param month - ���-�� �������
     * @param sum - ����� �������
     * @param monthPayment - ����������� ������
     * @param employee - ��������� �������� ������
     * @param paymentAccount - ��������� ����
     * @return - ���������� ��������� ��������� ����
     */
    CreditAccount create(User user,
                         Bank bank,
                         LocalDate start,
                         LocalDate end,
                         int month,
                         double sum,
                         double monthPayment,
                         Employee employee,
                         PaymentAccount paymentAccount
    );
}