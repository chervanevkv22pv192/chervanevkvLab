package tech.reliab.course.chervanevkv.bank.service;

import tech.reliab.course.chervanevkv.bank.entity.BankOffice;
import tech.reliab.course.chervanevkv.bank.entity.Bank;
import tech.reliab.course.chervanevkv.bank.entity.Employee;

import java.time.LocalDate;

public interface EmployeeService {
    Employee create(
            String firstName,
            String lastName,
            LocalDate birthDate,
            String job, Bank bank,
            BankOffice bankOffice,
            double salary
    );
    Employee create(
            String firstName,
            String lastName,
            String patronymic,
            LocalDate birthDate,
            String job, Bank bank,
            BankOffice bankOffice,
            double salary
    );
    Employee read();
    void update(Employee employee);
    void delete(Employee employee);
}
