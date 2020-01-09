package dev.fuxing.err;

/**
 * A subset of bad request error.
 * Parameter is required but no processable.
 * Could be blank, empty or not formatted correctly.
 *
 * @author Fuxing Loh
 * @since 2016-12-10 at 11:16
 */
public class ParameterException extends BadRequestException {

    public ParameterException() {
    }

    public ParameterException(String message) {
        super(message);
    }

    public ParameterException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
