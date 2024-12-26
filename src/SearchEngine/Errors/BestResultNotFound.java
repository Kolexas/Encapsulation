package SearchEngine.Errors;

public class BestResultNotFound extends Error {
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
