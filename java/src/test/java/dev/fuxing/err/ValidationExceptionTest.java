package dev.fuxing.err;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Fuxing Loh
 * @since 2020-01-20 at 14:22
 */
class ValidationExceptionTest extends AbstractTest {

    @Test
    void empty() {
        assertErrorURL(assertThrows(ValidationException.class, () -> {
            throw new ValidationException();
        }), ValidationException.class, 422);
    }

    @Test
    void message() {
        assertErrorURL(assertThrows(ValidationException.class, () -> {
            throw new ValidationException("message ValidationException");
        }), ValidationException.class, 422, "message ValidationException");
    }

    @Test
    void messageException() {
        assertErrorURL(assertThrows(ValidationException.class, () -> {
            throw new ValidationException("message ValidationException", new NumberFormatException());
        }), ValidationException.class, 422, "message ValidationException", NumberFormatException.class);
    }
}
