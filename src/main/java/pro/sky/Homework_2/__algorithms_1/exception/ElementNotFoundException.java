package pro.sky.Homework_2.__algorithms_1.exception;

public class ElementNotFoundException extends RuntimeException{
    public ElementNotFoundException() {
    }

    public ElementNotFoundException(String message) {
        super(message);
    }
}
