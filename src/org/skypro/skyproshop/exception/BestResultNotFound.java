package org.skypro.skyproshop.exception;

public class BestResultNotFound extends Exception {
    public BestResultNotFound() {
    }

    public BestResultNotFound(String message) {
        super(message);
    }

    public BestResultNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public BestResultNotFound(Throwable cause) {
        super(cause);
    }
}
