package tech.reliab.course.chervanevkv.bank.service;

import tech.reliab.course.chervanevkv.bank.entity.BankOffice;
import tech.reliab.course.chervanevkv.bank.entity.Bank;
import tech.reliab.course.chervanevkv.bank.entity.Employee;

import java.time.LocalDate;

public interface EmployeeService {
    /**
     *
     * @param firstName - ���
     * @param lastName - �������
     * @param birthDate - ���� �������� ����������
     * @param job - ���������
     * @param bank - ����
     * @param bankOffice - ���� �����
     * @param salary - ��������
     * @return - ���������� ��������� ������ ����������
     */
    Employee create(String firstName, String lastName, LocalDate birthDate, String job,
                    Bank bank, BankOffice bankOffice, double salary
    );

    /**
     *
     * @param firstName - ���
     * @param lastName - �������
     * @param patronymic - ��������
     * @param birthDate - ���� �������� ����������
     * @param job - ���������
     * @param bank - ����
     * @param bankOffice - ���� �����
     * @param salary - ��������
     * @return - ���������� ��������� ������ ����������
     */
    Employee create(String firstName, String lastName, String patronymic, LocalDate birthDate,
                    String job, Bank bank, BankOffice bankOffice, double salary
    );

}