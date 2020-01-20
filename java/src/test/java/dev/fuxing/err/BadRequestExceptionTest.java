package dev.fuxing.err;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fuxing Loh
 * @since 2020-01-20 at 14:22
 */
class BadRequestExceptionTest extends AbstractTest {

    @Test
    void empty() {
        assertErrorURL(assertThrows(BadRequestException.class, () -> {
            throw new BadRequestException();
        }), BadRequestException.class, 400);
    }

    @Test
    void message() {
        assertErrorURL(assertThrows(BadRequestException.class, () -> {
            throw new BadRequestException("message 1");
        }), BadRequestException.class, 400, "message 1");
    }

    @Test
    void messageException() {
        assertErrorURL(assertThrows(BadRequestException.class, () -> {
            throw new BadRequestException("message 2", new NullPointerException());
        }), BadRequestException.class, 400, "message 2", NullPointerException.class);
    }
}
