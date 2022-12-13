package tech.reliab.course.chervanevkv.bank.exceptions;

public class IncorrectCreditSumException extends RuntimeException {
    public IncorrectCreditSumException(String message){
        super(message);
    }
}
