package tech.reliab.course.chervanevkv.bank.exceptions;

public class NoAvailableEmployeeException extends RuntimeException{
    public NoAvailableEmployeeException(String message){
        super(message);
    }
}
