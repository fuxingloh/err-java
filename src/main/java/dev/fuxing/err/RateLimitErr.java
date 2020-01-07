package dev.fuxing.err;

/**
 * The 429 status code indicates that the user has sent too many requests in a given amount of time ("rate limiting").
 *
 * @author Fuxing Loh
 * @since 2018-06-29 at 14:52
 */
public class RateLimitErr extends Err {

    public RateLimitErr(String message) {
        super(429, message);
    }

    public RateLimitErr(String message, Throwable throwable) {
        super(429, message, throwable);
    }
}
