package tech.reliab.course.chervanevkv.bank.service;

import tech.reliab.course.chervanevkv.bank.entity.BankAtm;
import tech.reliab.course.chervanevkv.bank.entity.BankOffice;
import tech.reliab.course.chervanevkv.bank.entity.Bank;
import tech.reliab.course.chervanevkv.bank.entity.Employee;

public interface BankAtmService {
    /**
     *
     * @param name - ������� ���������
     * @param bank - ����
     * @param bankOffice - ���� �����
     * @param employee - ������������� ���������
     * @param maintenance - ��������� ������������
     * @return - ���������� ��������� ������ ��������
     */
    BankAtm create(String name, Bank bank, BankOffice bankOffice, Employee employee, double maintenance);

    /**
     * ������ ����� � ���������
     * @param atm - ��������
     * @param sum - ����� ������
     */
    void withdrawMoney(BankAtm atm, double sum);
}