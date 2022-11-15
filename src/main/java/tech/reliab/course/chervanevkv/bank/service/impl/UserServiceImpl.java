package tech.reliab.course.chervanevkv.bank.service.impl;

import tech.reliab.course.chervanevkv.bank.entity.User;
import tech.reliab.course.chervanevkv.bank.entity.Bank;
import tech.reliab.course.chervanevkv.bank.service.UserService;

import java.time.LocalDate;
import java.util.Random;

public class UserServiceImpl implements UserService {
    private Long id = 0L;
    private Random random = new Random();
    private User user;

    /**
     *
     * @param firstName - имя
     * @param lastName - фамилия
     * @param birthDate - дата рождения клиента
     * @param job - место работы
     * @param bank - банк
     * @return - возвращает созданный объект клиент
     */
    @Override
    public User create(String firstName, String lastName, LocalDate birthDate, String job, Bank bank){
        double salary = random.nextInt(10000);
        user = new User(
                ++id,
                firstName,
                lastName,
                birthDate,
                job,
                salary,
                bank,
                null,
                null,
                salary / 10
        );
        bank.setNumberOfClients(bank.getNumberOfClients()+1);
        return user;
    }

    /**
     *
     * @param firstName - имя
     * @param lastName - фамилия
     * @param patronymic - отчество
     * @param birthDate - дата рождения клиента
     * @param job - место работы
     * @param bank - банк
     * @return - возвращает созданный объект клиент
     */
    @Override
    public User create(String firstName, String lastName, String patronymic, LocalDate birthDate, String job, Bank bank){
        double salary = random.nextInt(10000);
        user = new User(
                ++id,
                firstName,
                lastName,
                patronymic,
                birthDate,
                job,
                salary,
                bank,
                null,
                null,
                salary / 10
        );
        bank.setNumberOfClients(bank.getNumberOfClients()+1);
        return user;
    }

    /**
     *
     * @return - возвращает объект клиент
     */
    @Override
    public User read(){
        return user;
    }

    /**
     *
     * @param user - новый клиент
     */
    @Override
    public void update(User user){
        this.user = user;
    }

    /**
     *
     * @param user - клиент для удаления
     */
    @Override
    public void delete(User user){
        if(this.user == user){
            this.user = null;
        }
    }
}
