package dev.fuxing.err;


/**
 * Request body contains error.
 *
 * @author Fuxing Loh
 * @since 2017-07-05 at 19:49
 */
public class ValidationException extends ErrorURL {

    public ValidationException() {
        super(422, FUXING_ERR_DOMAIN, ValidationException.class, "Request body contains error.", null);
    }

    public ValidationException(String message) {
        super(422, FUXING_ERR_DOMAIN, ValidationException.class, message, null);
    }

    public ValidationException(String message, Throwable throwable) {
        super(422, FUXING_ERR_DOMAIN, ValidationException.class, message, throwable);
    }
}
