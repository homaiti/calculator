package pro.sky.java.course2.exception;

public class WrongLoginException extends Exception{

    public WrongLoginException(){}

    public WrongLoginException(String message){
        super(message);
    }
}
