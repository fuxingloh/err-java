package dev.fuxing.err;

/**
 * A catch all error. Not recommended for production use but bloody useful for prototyping.
 * <p>
 * The server encountered an unexpected condition which prevented it from fulfilling the request.
 * With a message indicating the reason why the message occurred.
 *
 * @author Fuxing Loh
 * @since 2017-06-16 at 13:27
 */
public class UnknownException extends ErrorURL {

    public UnknownException() {
        super(500, FUXING_ERR_DOMAIN, UnknownException.class, "The server encountered an unexpected condition which prevented it from fulfilling the request.", null);
    }

    public UnknownException(String message) {
        super(500, FUXING_ERR_DOMAIN, UnknownException.class, message, null);
    }

    public UnknownException(String message, Throwable throwable) {
        super(500, FUXING_ERR_DOMAIN, UnknownException.class, message, throwable);
    }
}
