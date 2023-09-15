package fr.takima.codereview.exceptions;

public class ValideException extends Exception {
    public ValideException(String message) {
        super(message);
    }

    public ValideException(Throwable cause) {
        super(cause);
    }
}