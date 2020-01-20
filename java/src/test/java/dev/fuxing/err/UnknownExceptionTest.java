package dev.fuxing.err;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Fuxing Loh
 * @since 2020-01-20 at 14:22
 */
class UnknownExceptionTest extends AbstractTest {

    @Test
    void empty() {
        assertErrorURL(assertThrows(UnknownException.class, () -> {
            throw new UnknownException();
        }), UnknownException.class, 500);
    }

    @Test
    void message() {
        assertErrorURL(assertThrows(UnknownException.class, () -> {
            throw new UnknownException("message UnknownException");
        }), UnknownException.class, 500, "message UnknownException");
    }

    @Test
    void messageException() {
        assertErrorURL(assertThrows(UnknownException.class, () -> {
            throw new UnknownException("message UnknownException", new IllegalArgumentException());
        }), UnknownException.class, 500, "message UnknownException", IllegalArgumentException.class);
    }
}
