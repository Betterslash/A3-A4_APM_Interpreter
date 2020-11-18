package Model.CustomExceptions;

public class MyException extends Exception{
    final String message;

    public MyException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
