package dev.fuxing.err;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Fuxing Loh
 * @since 2020-01-20 at 14:22
 */
class RateLimitExceptionTest extends AbstractTest {

    @Test
    void empty() {
        assertErrorURL(assertThrows(RateLimitException.class, () -> {
            throw new RateLimitException();
        }), RateLimitException.class, 429);
    }

    @Test
    void message() {
        assertErrorURL(assertThrows(RateLimitException.class, () -> {
            throw new RateLimitException("message 4 45");
        }), RateLimitException.class, 429, "message 4 45");
    }

    @Test
    void messageException() {
        assertErrorURL(assertThrows(RateLimitException.class, () -> {
            throw new RateLimitException("message 156", new NullPointerException());
        }), RateLimitException.class, 429, "message 156", NullPointerException.class);
    }
}
