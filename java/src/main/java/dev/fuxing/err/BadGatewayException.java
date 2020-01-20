package dev.fuxing.err;

/**
 * The server, while acting as a gateway or proxy, received an invalid response from the upstream server it accessed in
 * attempting to fulfill the request.
 *
 * @author Fuxing Loh
 * @since 2019-04-02 at 11:48
 */
public class BadGatewayException extends ErrorURL {

    public BadGatewayException() {
        super(502, FUXING_ERR_DOMAIN, BadGatewayException.class, "Bad gateway, received an invalid response from the upstream server.", null);
    }

    public BadGatewayException(String message) {
        super(502, FUXING_ERR_DOMAIN, BadGatewayException.class, message, null);
    }

    public BadGatewayException(String message, Throwable throwable) {
        super(502, FUXING_ERR_DOMAIN, BadGatewayException.class, message, throwable);
    }
}
