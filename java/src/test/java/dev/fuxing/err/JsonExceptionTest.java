package dev.fuxing.err;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Fuxing Loh
 * @since 2020-01-20 at 14:22
 */
class JsonExceptionTest extends AbstractTest {

    @Test
    void empty() {
        assertErrorURL(assertThrows(JsonException.class, () -> {
            throw new JsonException();
        }), JsonException.class, 400);
    }

    @Test
    void message() {
        assertErrorURL(assertThrows(JsonException.class, () -> {
            throw new JsonException("message 151");
        }), JsonException.class, 400, "message 151");
    }

    @Test
    void messageException() {
        assertErrorURL(assertThrows(JsonException.class, () -> {
            throw new JsonException("message 221", new MalformedURLException());
        }), JsonException.class, 400, "message 221", MalformedURLException.class);
    }
}
