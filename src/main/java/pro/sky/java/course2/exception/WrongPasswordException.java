package pro.sky.java.course2.exception;

public class WrongPasswordException extends Exception{

    public WrongPasswordException(){}

    public WrongPasswordException(String messages){
        super(messages);
    }
}
