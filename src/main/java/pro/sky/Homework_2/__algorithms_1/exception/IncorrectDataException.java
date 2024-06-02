package pro.sky.Homework_2.__algorithms_1.exception;

public class IncorrectDataException extends RuntimeException{
    public IncorrectDataException() {
    }

    public IncorrectDataException(String message) {
        super(message);
    }
}
