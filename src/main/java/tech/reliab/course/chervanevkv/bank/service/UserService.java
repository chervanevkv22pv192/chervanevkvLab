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
     * @param firstName - им€
     * @param lastName - фамили€
     * @param birthDate - дата рождени€ клиента
     * @param job - место работы
     * @return - возвращает созданный объект клиент
     */
    User create(String firstName, String lastName, LocalDate birthDate, String job);
    /**
     *
     * @param firstName - им€
     * @param lastName - фамили€
     * @param patronymic - отчество
     * @param birthDate - дата рождени€ клиента
     * @param job - место работы
     * @return - возвращает созданный объект клиент
     */
    User create(String firstName, String lastName, String patronymic, LocalDate birthDate, String job);

    /**
     * выводит на экран информацию о пользователе
     * @param user - id пользовател€
     */
    void outputUserInfo(User user);

    /**
     * ƒобавл€ет банк в список банков, которыми пользуетс€ клиент
     * @param user - клиент
     * @param bank - банк
     */
    void addBank(User user, Bank bank);

    /**
     * ”дал€ет банк из списка банков, которыми пользуетс€ клиент
     * @param user - клиент
     * @param bank - банк
     */
    void deleteBank(User user, Bank bank);



}