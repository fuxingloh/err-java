package dev.fuxing.err;

/**
 * Similar to 403 Forbidden, but specifically for use when authentication is possible but has failed or required and not
 * yet been provided.
 *
 * @author Fuxing Loh
 * @since 2018-01-05 at 01:48
 */
public class UnauthorizedException extends Err {

    public UnauthorizedException() {
        super(401, "Unauthorized.");
    }

    /**
     * @param message to provide information (not recommended, better to not let the user know why)
     */
    public UnauthorizedException(String message) {
        super(401, message);
    }

    /**
     * @param message   to provide information (not recommended, better to not let the user know why)
     * @param throwable cause
     */
    public UnauthorizedException(String message, Throwable throwable) {
        super(401, message, throwable);
    }
}
