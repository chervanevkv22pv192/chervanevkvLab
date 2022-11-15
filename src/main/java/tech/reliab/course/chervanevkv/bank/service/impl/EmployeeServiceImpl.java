package tech.reliab.course.chervanevkv.bank.service.impl;

import tech.reliab.course.chervanevkv.bank.entity.BankOffice;
import tech.reliab.course.chervanevkv.bank.entity.Bank;
import tech.reliab.course.chervanevkv.bank.entity.Employee;
import tech.reliab.course.chervanevkv.bank.service.EmployeeService;

import java.time.LocalDate;

public class EmployeeServiceImpl implements EmployeeService {

    private Long id = 0L;
    private Employee employee;

    /**
     *
     * @param firstName - имя
     * @param lastName - фамилия
     * @param birthDate - дата рождения сотрудника
     * @param job - должность
     * @param bank - банк
     * @param bankOffice - офис банка
     * @param salary - зарплата
     * @return - возвращает созданный объект сотрудника
     */
    @Override
    public Employee create(String firstName, String lastName, LocalDate birthDate,
                           String job, Bank bank, BankOffice bankOffice, double salary){
        employee = new Employee(
                ++id,
                firstName,
                lastName,
                birthDate,
                job,
                bank,
                true,
                bankOffice,
                true,
                salary
        );
        bank.setNumberOfEmployees(bank.getNumberOfEmployees()+1);
        return employee;
    }

    /**
     *
     * @param firstName - имя
     * @param lastName - фамилия
     * @param patronymic - отчество
     * @param birthDate - дата рождения сотрудника
     * @param job - должность
     * @param bank - банк
     * @param bankOffice - офис банка
     * @param salary - зарплата
     * @return - возвращает созданный объект сотрудника
     */
    @Override
    public Employee create(String firstName, String lastName, String patronymic, LocalDate birthDate,
            String job, Bank bank, BankOffice bankOffice, double salary){
        employee = new Employee(
                ++id,
                firstName,
                lastName,
                patronymic,
                birthDate,
                job,
                bank,
                true,
                bankOffice,
                true,
                salary
        );
        bank.setNumberOfEmployees(bank.getNumberOfEmployees()+1);
        return employee;
    }

    /**
     *
     * @return - возвращает объект сотрудник
     */
    @Override
    public Employee read(){
        return employee;
    }

    /**
     *
     * @param employee - новый сотрудник
     */
    @Override
    public void update(Employee employee){
        this.employee = employee;
    }

    /**
     *
     * @param employee - сотрудник для удаления
     */
    @Override
    public void delete(Employee employee){
        if(this.employee == employee){
            this.employee = null;
        }
    }

}
