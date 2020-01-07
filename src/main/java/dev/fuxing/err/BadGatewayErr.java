package dev.fuxing.err;

/**
 * The server, while acting as a gateway or proxy, received an invalid response from the upstream server it accessed in
 * attempting to fulfill the request.
 *
 * @author Fuxing Loh
 * @since 2019-04-02 at 11:48
 */
public class BadGatewayErr extends Err {

    public BadGatewayErr() {
        super(502, "Bad gateway.");
    }

    public BadGatewayErr(String message) {
        super(502, message);
    }

    public BadGatewayErr(String message, Throwable throwable) {
        super(502, message, throwable);
    }
}
