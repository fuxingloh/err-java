package dev.fuxing.err;

/**
 * The server is currently unable to handle the request due to a temporary overloading or maintenance of the server.
 * The implication is that this is a temporary condition which will be alleviated after some delay.
 *
 * @author Fuxing Loh
 * @since 2017-12-03 at 08:13
 */
public class UnavailableException extends Err {

    public UnavailableException() {
        super(503, "Currently unable to handle the request.");
    }

    public UnavailableException(String message) {
        super(503, message);
    }

    public UnavailableException(String message, Throwable throwable) {
        super(503, message, throwable);
    }
}
