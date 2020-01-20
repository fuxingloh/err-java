package dev.fuxing.err;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Fuxing Loh
 * @since 2020-01-20 at 14:22
 */
class UnauthorizedExceptionTest extends AbstractTest {

    @Test
    void empty() {
        assertErrorURL(assertThrows(UnauthorizedException.class, () -> {
            throw new UnauthorizedException();
        }), UnauthorizedException.class, 401);
    }

    @Test
    void message() {
        assertErrorURL(assertThrows(UnauthorizedException.class, () -> {
            throw new UnauthorizedException("messages 4 45");
        }), UnauthorizedException.class, 401, "messages 4 45");
    }

    @Test
    void messageException() {
        assertErrorURL(assertThrows(UnauthorizedException.class, () -> {
            throw new UnauthorizedException("messages 156", new NullPointerException());
        }), UnauthorizedException.class, 401, "messages 156", NullPointerException.class);
    }
}
