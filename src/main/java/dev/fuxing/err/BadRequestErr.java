package dev.fuxing.err;

/**
 * The request could not be understood by the server due to malformed syntax.
 * The client SHOULD NOT repeat the request without modifications.
 *
 * @author Fuxing Loh
 * @see ParameterErr a subset of this error
 * @since 2018-09-27 at 15:15
 */
public class BadRequestErr extends Err {

    public BadRequestErr() {
        super(400, "Bad request.");
    }

    public BadRequestErr(String message) {
        super(400, message);
    }

    public BadRequestErr(String message, Throwable throwable) {
        super(400, message, throwable);
    }
}
