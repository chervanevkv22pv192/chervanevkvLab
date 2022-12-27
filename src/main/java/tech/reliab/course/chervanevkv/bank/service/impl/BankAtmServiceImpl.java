package tech.reliab.course.chervanevkv.bank.service.impl;

import tech.reliab.course.chervanevkv.bank.entity.BankAtm;
import tech.reliab.course.chervanevkv.bank.entity.BankOffice;
import tech.reliab.course.chervanevkv.bank.enums.AtmStatus;
import tech.reliab.course.chervanevkv.bank.entity.Bank;
import tech.reliab.course.chervanevkv.bank.entity.Employee;
import tech.reliab.course.chervanevkv.bank.exceptions.BankRefusedLoanRequestFromUserException;
import tech.reliab.course.chervanevkv.bank.exceptions.IncorrectCreditSumException;
import tech.reliab.course.chervanevkv.bank.service.BankAtmService;

public class BankAtmServiceImpl implements BankAtmService {
    private static  BankAtmServiceImpl INSTANCE;

    private BankAtmServiceImpl(){}

    public static BankAtmServiceImpl getInstance(){
        if (INSTANCE==null){
            INSTANCE = new BankAtmServiceImpl();
        }
        return INSTANCE;
    }

    private Long id = 0L;


    @Override
    public BankAtm create(String name, Bank bank, BankOffice bankOffice, Employee employee, double maintenance){
        var bankAtm = new BankAtm(
                ++id,
                name,
                AtmStatus.WORKING,
                bankOffice.getAddress(),
                bank,
                bankOffice,
                employee,
                true,
                true,
                bank.getMoneyAmount(),
                maintenance
        );
        bank.getAtms().add(bankAtm);
        bankOffice.getAtms().add(bankAtm);
        return bankAtm;
    }

    @Override
    public void withdrawMoney(BankAtm atm, double sum){
        if(atm.getMoneyAmount()<sum){
            throw new BankRefusedLoanRequestFromUserException("No such sum available in this bank.");
        }
        if(sum < 0){
            throw new IncorrectCreditSumException("Credit sum can't be above zero.");
        }
        atm.setMoneyAmount(atm.getMoneyAmount()-sum);
    }


}