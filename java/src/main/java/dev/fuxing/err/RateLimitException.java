package dev.fuxing.err;

/**
 * The 429 status code indicates that the user has sent too many requests in a given amount of time ("rate limiting").
 *
 * @author Fuxing Loh
 * @since 2018-06-29 at 14:52
 */
public class RateLimitException extends ErrorURL {

    public RateLimitException() {
        super(429, FUXING_ERR_DOMAIN, RateLimitException.class, "Too many request in a given amount of time.", null);
    }

    public RateLimitException(String message) {
        super(429, FUXING_ERR_DOMAIN, RateLimitException.class, message, null);
    }

    public RateLimitException(String message, Throwable throwable) {
        super(429, FUXING_ERR_DOMAIN, RateLimitException.class, message, throwable);
    }
}
