package tech.reliab.course.chervanevkv.bank.service.impl;

import tech.reliab.course.chervanevkv.bank.entity.CreditAccount;
import tech.reliab.course.chervanevkv.bank.entity.PaymentAccount;
import tech.reliab.course.chervanevkv.bank.entity.User;
import tech.reliab.course.chervanevkv.bank.entity.Bank;
import tech.reliab.course.chervanevkv.bank.exceptions.DeletingNULLObjectException;
import tech.reliab.course.chervanevkv.bank.service.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserServiceImpl implements UserService {

    private static  UserServiceImpl INSTANCE;

    private UserServiceImpl(){}

    public static UserServiceImpl getInstance(){
        if (INSTANCE==null){
            INSTANCE = new UserServiceImpl();
        }
        return INSTANCE;
    }
    private Long id = 0L;
    private Random random = new Random();

    @Override
    public User create(String firstName, String lastName, LocalDate birthDate, String job){
        double salary = random.nextInt(100000);
        var user = new User(
                ++id,
                firstName,
                lastName,
                birthDate,
                job,
                salary,
                salary / 10
        );
        return user;
    }

    @Override
    public User create(String firstName, String lastName, String patronymic, LocalDate birthDate, String job){
        double salary = random.nextInt(10000);
        var user = new User(
                ++id,
                firstName,
                lastName,
                patronymic,
                birthDate,
                job,
                salary,
                salary / 10
        );
        return user;
    }

    @Override
    public void outputUserInfo(User user) {
        System.out.println("User:");
        System.out.println("\t"+user);
        System.out.println("\tPayment Accounts:");
        for(var payment: user.getPaymentAccounts()){
            System.out.println("\t\t"+payment);
        }
        System.out.println("\tCredit Accounts:");
        for(var credit: user.getCreditAccounts()){
            System.out.println("\t\t"+credit);
        }
    }

    @Override
    public void addBank(User user, Bank bank) {
        user.getBanks().add(bank);
    }

    @Override
    public void deleteBank(User user, Bank bank) {
        if(!user.getBanks().contains(bank)){
                throw new DeletingNULLObjectException("Attempted to delete an object which has been deleted already.");
            }
            user.getBanks().remove(bank);
        }
    }