package tech.reliab.course.chervanevkv.bank.service;
import tech.reliab.course.chervanevkv.bank.entity.Bank;

public interface BankService {
    Bank create(String name);
    Bank read();
    void update(Bank bank);
    void delete(Bank bank);
}
