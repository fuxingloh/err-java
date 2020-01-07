package dev.fuxing.err;

/**
 * The server is currently unable to handle the request due to a temporary overloading or maintenance of the server.
 * The implication is that this is a temporary condition which will be alleviated after some delay.
 *
 * @author Fuxing Loh
 * @since 2017-12-03 at 08:13
 */
public class UnavailableErr extends Err {

    public UnavailableErr() {
        super(503, "Currently unable to handle the request.");
    }

    public UnavailableErr(String message) {
        super(503, message);
    }

    public UnavailableErr(String message, Throwable throwable) {
        super(503, message, throwable);
    }
}
