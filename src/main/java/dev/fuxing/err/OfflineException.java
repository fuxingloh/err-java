package dev.fuxing.err;

/**
 * The server, while acting as a gateway or proxy, received an invalid response from the upstream server it accessed in
 * attempting to fulfill the request.
 *
 * @author Fuxing Loh
 * @since 2017-03-18 at 15:42
 */
public class OfflineException extends Err {

    public OfflineException() {
        super(502, "Offline error.");
    }

    public OfflineException(String message) {
        super(502, message);
    }

    public OfflineException(String message, Throwable throwable) {
        super(502, message, throwable);
    }
}
