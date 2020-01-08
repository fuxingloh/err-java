package dev.fuxing.err;

/**
 * @author Fuxing Loh
 * @since 2019-06-06 at 15:37
 */
public class NotFoundErr extends Err {

    public NotFoundErr() {
        super(404, "Not found.");
    }

    public NotFoundErr(String message) {
        super(404, message);
    }

    public NotFoundErr(String message, Throwable throwable) {
        super(404, message, throwable);
    }
}
