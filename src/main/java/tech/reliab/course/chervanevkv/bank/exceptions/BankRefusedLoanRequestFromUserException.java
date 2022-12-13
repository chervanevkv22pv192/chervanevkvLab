package tech.reliab.course.chervanevkv.bank.exceptions;

public class BankRefusedLoanRequestFromUserException extends RuntimeException{
    public BankRefusedLoanRequestFromUserException(String message){
        super(message);
    }
}
