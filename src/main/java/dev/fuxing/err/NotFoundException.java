package dev.fuxing.err;

/**
 * @author Fuxing Loh
 * @since 2019-06-06 at 15:37
 */
public class NotFoundException extends Err {

    public NotFoundException() {
        super(404, "Not found.");
    }

    public NotFoundException(String message) {
        super(404, message);
    }

    public NotFoundException(String message, Throwable throwable) {
        super(404, message, throwable);
    }
}
