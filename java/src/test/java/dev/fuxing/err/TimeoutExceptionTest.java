package dev.fuxing.err;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Fuxing Loh
 * @since 2020-01-20 at 14:22
 */
class TimeoutExceptionTest extends AbstractTest {

    @Test
    void empty() {
        assertErrorURL(assertThrows(TimeoutException.class, () -> {
            throw new TimeoutException();
        }), TimeoutException.class, 408);
    }

    @Test
    void message() {
        assertErrorURL(assertThrows(TimeoutException.class, () -> {
            throw new TimeoutException("message 44 45");
        }), TimeoutException.class, 408, "message 44 45");
    }

    @Test
    void messageException() {
        assertErrorURL(assertThrows(TimeoutException.class, () -> {
            throw new TimeoutException(408, "message 154446", new NullPointerException());
        }), TimeoutException.class, 408, "message 154446", NullPointerException.class);
    }

    @Test
    void messageException2() {
        assertErrorURL(assertThrows(TimeoutException.class, () -> {
            throw new TimeoutException(504, "messages", new NumberFormatException());
        }), TimeoutException.class, 504, "messages", NumberFormatException.class);
    }
}
