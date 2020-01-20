package dev.fuxing.err;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Fuxing Loh
 * @since 2020-01-20 at 14:22
 */
class NotFoundExceptionTest extends AbstractTest {

    @Test
    void empty() {
        assertErrorURL(assertThrows(NotFoundException.class, () -> {
            throw new NotFoundException();
        }), NotFoundException.class, 404);
    }

    @Test
    void message() {
        assertErrorURL(assertThrows(NotFoundException.class, () -> {
            throw new NotFoundException("message 45");
        }), NotFoundException.class, 404, "message 45");
    }

    @Test
    void messageException() {
        assertErrorURL(assertThrows(NotFoundException.class, () -> {
            throw new NotFoundException("message 56", new NullPointerException());
        }), NotFoundException.class, 404, "message 56", NullPointerException.class);
    }
}
