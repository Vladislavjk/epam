package by.training.task05.service.exception;

public class CreateShapeException extends Exception {

    public CreateShapeException() {

    }

    public CreateShapeException(String message) {
        super(message);
    }

    public CreateShapeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateShapeException(Throwable cause) {
        super(cause);
    }
}

