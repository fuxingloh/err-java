package dev.fuxing.err;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Fuxing Loh
 * @since 2020-01-20 at 14:22
 */
class ForbiddenExceptionTest extends AbstractTest {

    @Test
    void empty() {
        assertErrorURL(assertThrows(ForbiddenException.class, () -> {
            throw new ForbiddenException();
        }), ForbiddenException.class, 403);
    }

    @Test
    void message() {
        assertErrorURL(assertThrows(ForbiddenException.class, () -> {
            throw new ForbiddenException("message 15");
        }), ForbiddenException.class, 403, "message 15");
    }

    @Test
    void messageException() {
        assertErrorURL(assertThrows(ForbiddenException.class, () -> {
            throw new ForbiddenException("message 22", new IllegalAccessException());
        }), ForbiddenException.class, 403, "message 22", IllegalAccessException.class);
    }
}
