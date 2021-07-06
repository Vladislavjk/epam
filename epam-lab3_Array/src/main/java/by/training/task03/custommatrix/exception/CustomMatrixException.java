package by.training.task03.custommatrix.exception;

public class CustomMatrixException extends Exception {
    public CustomMatrixException() {
        super();
    }

    public CustomMatrixException(String message) {
        super(message);
    }

    public CustomMatrixException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomMatrixException(Throwable cause) {
        super(cause);
    }
}
