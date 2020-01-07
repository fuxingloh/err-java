package dev.fuxing.err;

/**
 * The client did not produce a request within the time that the server was prepared to wait.
 * The client MAY repeat the request without modifications at any later time.
 *
 * @author Fuxing Loh
 * @since 2017-03-22 at 17:19
 */
public class TimeoutErr extends Err {

    public TimeoutErr() {
        super(408, "Request from client to server has timeout.");
    }

    public TimeoutErr(String message) {
        super(408, message);
    }

    /**
     * @param code      408 or 504
     * @param message   of timeout
     * @param throwable cause of timeout
     */
    public TimeoutErr(int code, String message, Throwable throwable) {
        super(code, message, throwable);
    }
}
