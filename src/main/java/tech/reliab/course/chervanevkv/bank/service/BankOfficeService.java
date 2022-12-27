package tech.reliab.course.chervanevkv.bank.service;

import tech.reliab.course.chervanevkv.bank.entity.BankAtm;
import tech.reliab.course.chervanevkv.bank.entity.BankOffice;
import tech.reliab.course.chervanevkv.bank.entity.Bank;

import java.util.List;

public interface BankOfficeService {
    /**
     *
     * @param name - ��� �����
     * @param bank - ���� �����
     * @param address - ����� �����
     * @param rent - ��������� ������ �����
     * @return - ���������� ��������� ������ ����
     */
    BankOffice create(String name, Bank bank, String address, double rent);

    /**
     * ��������� �������� � ����
     * @param office - ����
     * @param atm - ��������
     */
    void addAtm(BankOffice office, BankAtm atm);

    /**
     * ������� �������� � �����
     * @param office - ����
     * @param atm - ��������
     */
    void deleteAtm(BankOffice office, BankAtm atm);

    /**
     *
     * @param office - ����
     * @param sum - ����� �������
     * @return - ���������� ������ ����������, ������� ����� ������ ������ �����
     */
    List<BankAtm> getAtmsForLoans(BankOffice office, double sum);
}