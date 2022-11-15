package tech.reliab.course.chervanevkv.bank.service.impl;

import tech.reliab.course.chervanevkv.bank.entity.Bank;
import tech.reliab.course.chervanevkv.bank.service.BankService;

import java.util.Random;

public class BankServiceImpl implements BankService {

    private Long id = 0L;
    private static Random random = new Random();
    private Bank bank;

    /**
     *
     * @param name - имя банка
     * @return - возвращает созданный объект банк
     */
    @Override
    public Bank create(String name){
        int rating = random.nextInt(100);
        int money = random.nextInt(1000000);
        double rate = (20 - (20 * rating)/100.0);
        bank = new Bank(
                ++id,
                name,
                0,
                0,
                0,
                0,
                rating,
                money,
                rate
        );

        return bank;
    }

    /**
     *
     * @return - возвращает объект банк
     */
    @Override
    public Bank read(){
        return bank;
    }

    /**
     *
     * @param bank - новый объект банка
     */
    @Override
    public void update(Bank bank){
        this.bank = bank;
    }

    /**
     *
     * @param bank - банк, который нужно удалить
     */
    @Override
    public void delete(Bank bank){
        if(this.bank == bank){
            this.bank = null;
        }
    }

}
