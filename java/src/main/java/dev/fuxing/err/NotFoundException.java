package dev.fuxing.err;

/**
 * @author Fuxing Loh
 * @since 2019-06-06 at 15:37
 */
public class NotFoundException extends ErrorURL {

    public NotFoundException() {
        super(404, FUXING_ERR_DOMAIN, NotFoundException.class, "Resource not found.", null);
    }

    public NotFoundException(String message) {
        super(404, FUXING_ERR_DOMAIN, NotFoundException.class, message, null);
    }

    public NotFoundException(String message, Throwable throwable) {
        super(404, FUXING_ERR_DOMAIN, NotFoundException.class, message, throwable);
    }
}
