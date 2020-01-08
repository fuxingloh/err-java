package dev.fuxing.err;

/**
 * The server encountered an unexpected condition which prevented it from fulfilling the request.
 * With a message indicating the reason why the message occurred.
 *
 * @author Fuxing Loh
 * @since 2017-06-16 at 13:27
 */
public class UnknownErr extends Err {

    public UnknownErr() {
        super(500, "Unknown error.");
    }

    public UnknownErr(String message) {
        super(500, message);
    }

    public UnknownErr(String message, Throwable throwable) {
        super(500, message, throwable);
    }
}
