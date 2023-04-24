package pro.sky.java.course2.exception;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//@SpringBootApplication
public class ExceptionApplication {
    public static void main(String[] args) {
  //      SpringApplication.run(pro.sky.java.course2.exception.ExceptionApplication.class, args);

        try {
            check("imLogin123__3", "qwerty123_", "qwerty123_");
            }catch (WrongLoginException e) {
                e.printStackTrace(System.err);
            }catch (WrongPasswordException e) {
                throw new IllegalStateException("Ошибка входа", e);
            }
            finally {
            System.out.println("Завершена работа проверки");
            }
        System.out.println("Логин\\Пасс получены");
    }





    private static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException{


        if(login.length() > 20 || !login.matches( "[a-zA-Z0-9_]+")) {
            throw new WrongLoginException("Логин должен содержадть только латинские буквы, цифры или знак \"_\" и должен быть меньше или равен 20 символам");
        }
        if(password.length() >= 20 || !password.equals(confirmPassword) || !login.matches( "[a-zA-Z0-9_]+")) {
            throw new WrongPasswordException("Пароль должен содержадть только латинские буквы, цифры или знак \"_\" и должен быть меньше или равен 20 символам");
        }
    }
}






