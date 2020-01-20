package dev.fuxing.err;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Fuxing Loh
 * @since 2020-01-20 at 14:22
 */
class UnavailableExceptionTest extends AbstractTest {

    @Test
    void empty() {
        assertErrorURL(assertThrows(UnavailableException.class, () -> {
            throw new UnavailableException();
        }), UnavailableException.class, 503);
    }

    @Test
    void message() {
        assertErrorURL(assertThrows(UnavailableException.class, () -> {
            throw new UnavailableException("message UnavailableException");
        }), UnavailableException.class, 503, "message UnavailableException");
    }

    @Test
    void messageException() {
        assertErrorURL(assertThrows(UnavailableException.class, () -> {
            throw new UnavailableException("message UnavailableException", new IllegalArgumentException());
        }), UnavailableException.class, 503, "message UnavailableException", IllegalArgumentException.class);
    }
}
