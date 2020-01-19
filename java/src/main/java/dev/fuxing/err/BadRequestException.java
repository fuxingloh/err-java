package dev.fuxing.err;

/**
 * The request could not be understood by the server due to malformed syntax.
 * The client SHOULD NOT repeat the request without modifications.
 *
 * @author Fuxing Loh
 * @see ParameterException a subset of this error
 * @since 2018-09-27 at 15:15
 */
public class BadRequestException extends Err {

    public BadRequestException() {
        super(400, "Bad request.");
    }

    public BadRequestException(String message) {
        super(400, message);
    }

    public BadRequestException(String message, Throwable throwable) {
        super(400, message, throwable);
    }
}
