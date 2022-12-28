package tech.reliab.course.chervanevkv.bank.service;
import tech.reliab.course.chervanevkv.bank.entity.*;

import java.util.List;

public interface BankService {
    /**
     *
     * @param name - ��� �����
     * @return - ���������� ��������� ������ ����
     */
    Bank create(String name);

    /**
     * ������� �� ����� ���������� � ����� � ������ id
     * @param bank - ����
     */
    void outputBankInfo(Bank bank);

    /**
     * ��������� ���� � ����
     * @param bank - ����
     * @param office - ����
     */
    void addOffice(Bank bank, BankOffice office);

    /**
     * ������� ���� �� �����
     * @param bank - ����
     * @param office - ����
     */
    void deleteOffice(Bank bank, BankOffice office);

    /**
     * ��������� �������� � ����
     * @param bank - ����
     * @param atm - ��������
     */
    void addAtm(Bank bank, BankAtm atm);

    /**
     * ������� ���� �� �����
     * @param bank - ����
     * @param atm - ��������
     */
    void deleteAtm(Bank bank, BankAtm atm);

    /**
     * ��������� ���������� � ����
     * @param bank - ����
     * @param employee - ���������
     */
    void addEmployee(Bank bank, Employee employee);

    /**
     * ������� ���������� �� �����
     * @param bank - ����
     * @param employee - ���������
     */
    void deleteEmployee(Bank bank, Employee employee);

    /**
     * ��������� ������������ � ����
     * @param bank - ����
     * @param user - ������������
     */
    void addUser(Bank bank, User user);

    /**
     * ������� ������������ �� �����
     * @param bank - ����
     * @param user - ������������
     */
    void deleteUser(Bank bank, User user);

    /**
     * ���������� �����, ������� ����� ������ ������ �� ������ �����
     * @param bank - ����
     * @param sum - ����� �������
     */
    List<BankOffice> getOfficesForLoans(Bank bank, double sum);

    /**
     *
     * @param bank - ����
     * @param office - ����
     * @return ���������� ����������� ����� �� ������� �����, ������� ����� ������ ������
     */
    List<Employee> getEmployeesForLoans(Bank bank, BankOffice office);
    public Employee getEmployeeById(Bank bank, int id);
}