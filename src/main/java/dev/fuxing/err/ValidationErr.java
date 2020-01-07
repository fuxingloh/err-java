package dev.fuxing.err;


/**
 * Request body contains error.
 *
 * @author Fuxing Loh
 * @since 2017-07-05 at 19:49
 */
public class ValidationErr extends Err {

    public ValidationErr() {
        super(422, "Request body contains error.");
    }

    public ValidationErr(String message) {
        super(422, message);
    }

    public ValidationErr(String message, Throwable throwable) {
        super(422, message, throwable);
    }
}
