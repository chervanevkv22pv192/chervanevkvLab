package tech.reliab.course.chervanevkv.bank.service.impl;

import tech.reliab.course.chervanevkv.bank.entity.BankAtm;
import tech.reliab.course.chervanevkv.bank.entity.BankOffice;
import tech.reliab.course.chervanevkv.bank.entity.Bank;
import tech.reliab.course.chervanevkv.bank.exceptions.DeletingNULLObjectException;
import tech.reliab.course.chervanevkv.bank.exceptions.IncorrectCreditSumException;
import tech.reliab.course.chervanevkv.bank.service.BankOfficeService;

import java.util.List;

public class BankOfficeServiceImpl implements BankOfficeService {

    private static  BankOfficeServiceImpl INSTANCE;

    private BankOfficeServiceImpl(){}

    public static BankOfficeServiceImpl getInstance(){
        if (INSTANCE==null){
            INSTANCE = new BankOfficeServiceImpl();
        }
        return INSTANCE;
    }

    Long id = 0L;

    @Override
    public BankOffice create(String name, Bank bank, String address, double rent){
        var bankOffice = new BankOffice(
                ++id,
                bank,
                name,
                address,
                true,
                true,
                true,
                true,
                true,
                bank.getMoneyAmount(),
                rent
        );
        bank.getOffices().add(bankOffice);
        return bankOffice;
    }

    @Override
    public void addAtm(BankOffice office, BankAtm atm) {
        office.getAtms().add(atm);
    }

    @Override
    public void deleteAtm(BankOffice office, BankAtm atm) {
        if(!office.getAtms().contains(atm)){
            throw new DeletingNULLObjectException("Attempted to delete an object which is already deleted.");
        }
        office.getAtms().remove(atm);
    }

    @Override
    public List<BankAtm> getAtmsForLoans(BankOffice office, double sum) {
        if(sum < 0){
            throw new IncorrectCreditSumException("Credit sum must be above zero.");
        }
        return office.getAtms().stream().filter(
                atm-> atm.isCanPaymentOfMoney() && atm.getMoneyAmount() > sum).toList();
    }

}