package tech.reliab.course.chervanevkv.bank.service;

import tech.reliab.course.chervanevkv.bank.entity.CreditAccount;
import tech.reliab.course.chervanevkv.bank.entity.PaymentAccount;
import tech.reliab.course.chervanevkv.bank.entity.User;
import tech.reliab.course.chervanevkv.bank.entity.Bank;

import java.time.LocalDate;
import java.util.List;


public interface UserService {
    User create(String firstName, String lastName, LocalDate birthDate, String job, Bank bank);
    User create(String firstName, String lastName, String patronymic, LocalDate birthDate, String job, Bank bank);
    User read();
    void update(User user);
    void delete(User user);
}
