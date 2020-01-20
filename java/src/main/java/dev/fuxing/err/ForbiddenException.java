package dev.fuxing.err;

/**
 * The server understood the request, but is refusing to fulfill it.
 * Authorization will not help and the request SHOULD NOT be repeated.
 *
 * @author Fuxing Loh
 * @since 2018-07-17 at 12:39
 */
public class ForbiddenException extends ErrorURL {

    public ForbiddenException() {
        super(403, FUXING_ERR_DOMAIN, ForbiddenException.class, "The server understood the request, but is refusing to fulfill it.", null);
    }

    /**
     * @param message reasons, (not recommended, better to not let the user know why, especially for private content)
     */
    public ForbiddenException(String message) {
        super(403, FUXING_ERR_DOMAIN, ForbiddenException.class, message, null);
    }

    public ForbiddenException(String message, Throwable throwable) {
        super(403, FUXING_ERR_DOMAIN, ForbiddenException.class, message, throwable);
    }
}
