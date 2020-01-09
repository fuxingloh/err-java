package dev.fuxing.err;

/**
 * The server understood the request, but is refusing to fulfill it.
 * Authorization will not help and the request SHOULD NOT be repeated.
 *
 * @author Fuxing Loh
 * @since 2018-07-17 at 12:39
 */
public class ForbiddenException extends Err {

    public ForbiddenException() {
        super(403, "Forbidden");
    }

    /**
     * @param message reasons, (not recommended, better to not let the user know why, especially for private content)
     */
    public ForbiddenException(String message) {
        super(403, message);
    }

    public ForbiddenException(String message, Throwable throwable) {
        super(403, message, throwable);
    }
}
