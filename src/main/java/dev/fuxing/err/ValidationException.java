package dev.fuxing.err;


/**
 * Request body contains error.
 *
 * @author Fuxing Loh
 * @since 2017-07-05 at 19:49
 */
public class ValidationException extends Err {

    public ValidationException() {
        super(422, "Request body contains error.");
    }

    public ValidationException(String message) {
        super(422, message);
    }

    public ValidationException(String message, Throwable throwable) {
        super(422, message, throwable);
    }
}
