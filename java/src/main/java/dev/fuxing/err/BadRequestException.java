package dev.fuxing.err;

/**
 * The request could not be understood by the server due to malformed syntax.
 * The client SHOULD NOT repeat the request without modifications.
 *
 * @author Fuxing Loh
 * @since 2018-09-27 at 15:15
 */
public class BadRequestException extends ErrorURL {

    public BadRequestException() {
        super(400, FUXING_ERR_DOMAIN, BadRequestException.class, "The request could not be understood by the server due to malformed request.", null);
    }

    public BadRequestException(String message) {
        super(400, FUXING_ERR_DOMAIN, BadRequestException.class, message, null);
    }

    public BadRequestException(String message, Throwable throwable) {
        super(400, FUXING_ERR_DOMAIN, BadRequestException.class, message, throwable);
    }
}
