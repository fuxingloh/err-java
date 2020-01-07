package dev.fuxing.err;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fuxing Loh
 * @since 2020-01-07 at 08:28
 */
class UnknownErrTest {

    /**
     * Test UnknownErr is automatically registered and auto parsed
     */
    @Test
    void parse() {
        Err err = Err.parse("https://err.fuxing.dev/UnknownErr", "Unknown error.");
        assertEquals(UnknownErr.class, err.getClass());
        assertEquals("UnknownErr", err.getClass().getSimpleName());
        assertEquals("Unknown error.", err.getMessage());
    }
}
