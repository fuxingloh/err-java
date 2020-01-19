package dev.fuxing.err;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fuxing Loh
 * @since 2020-01-07 at 08:28
 */
class UnknownExceptionTest {

    /**
     * Test UnknownErr is automatically registered and auto parsed
     */
    @Test
    void parse() {
        Err err = Err.parse("https://err.fuxing.dev/UnknownErr", UUID.randomUUID().toString(), "Unknown error.");
        assertEquals(UnknownException.class, err.getClass());
        assertEquals("UnknownErr", err.getClass().getSimpleName());
        assertEquals("Unknown error.", err.getMessage());
    }
}
