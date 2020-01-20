package dev.fuxing.err;

/**
 * The client did not produce a request within the time that the server was prepared to wait.
 * The client MAY repeat the request without modifications at any later time.
 *
 * @author Fuxing Loh
 * @since 2017-03-22 at 17:19
 */
public class TimeoutException extends ErrorURL {

    public TimeoutException() {
        super(408, FUXING_ERR_DOMAIN, TimeoutException.class, "Request from client to server has timeout.", null);
    }

    public TimeoutException(String message) {
        super(408, FUXING_ERR_DOMAIN, TimeoutException.class, message, null);
    }

    /**
     * @param code      408 or 504
     * @param message   of timeout
     * @param throwable cause of timeout
     */
    public TimeoutException(int code, String message, Throwable throwable) {
        super(code, FUXING_ERR_DOMAIN, TimeoutException.class, message, throwable);
    }
}
