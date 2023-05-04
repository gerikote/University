package exceptions;

public class MaxStudentsReachedException extends Exception {
    public MaxStudentsReachedException(String message) {
        super(message);
    }
}