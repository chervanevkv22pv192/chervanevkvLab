package tech.reliab.course.chervanevkv.bank.service;

import tech.reliab.course.chervanevkv.bank.entity.CreditAccount;
import tech.reliab.course.chervanevkv.bank.entity.PaymentAccount;
import tech.reliab.course.chervanevkv.bank.entity.User;
import tech.reliab.course.chervanevkv.bank.entity.Bank;

import java.time.LocalDate;
import java.util.List;


public interface UserService {
    /**
     *
     * @param firstName - ���
     * @param lastName - �������
     * @param birthDate - ���� �������� �������
     * @param job - ����� ������
     * @return - ���������� ��������� ������ ������
     */
    User create(String firstName, String lastName, LocalDate birthDate, String job);
    /**
     *
     * @param firstName - ���
     * @param lastName - �������
     * @param patronymic - ��������
     * @param birthDate - ���� �������� �������
     * @param job - ����� ������
     * @return - ���������� ��������� ������ ������
     */
    User create(String firstName, String lastName, String patronymic, LocalDate birthDate, String job);

    /**
     * ������� �� ����� ���������� � ������������
     * @param user - id ������������
     */
    void outputUserInfo(User user);

    /**
     * ��������� ���� � ������ ������, �������� ���������� ������
     * @param user - ������
     * @param bank - ����
     */
    void addBank(User user, Bank bank);

    /**
     * ������� ���� �� ������ ������, �������� ���������� ������
     * @param user - ������
     * @param bank - ����
     */
    void deleteBank(User user, Bank bank);



}