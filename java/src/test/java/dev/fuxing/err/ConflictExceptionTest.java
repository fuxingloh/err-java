package dev.fuxing.err;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Fuxing Loh
 * @since 2020-01-20 at 14:22
 */
class ConflictExceptionTest extends AbstractTest {

    @Test
    void empty() {
        assertErrorURL(assertThrows(ConflictException.class, () -> {
            throw new ConflictException();
        }), ConflictException.class, 409);
    }

    @Test
    void message() {
        assertErrorURL(assertThrows(ConflictException.class, () -> {
            throw new ConflictException("message 1");
        }), ConflictException.class, 409, "message 1");
    }

    @Test
    void messageException() {
        assertErrorURL(assertThrows(ConflictException.class, () -> {
            throw new ConflictException("message 2", new IllegalAccessError());
        }), ConflictException.class, 409, "message 2", IllegalAccessError.class);
    }
}
