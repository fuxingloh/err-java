package dev.fuxing.err;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fuxing Loh
 * @since 2020-01-20 at 13:20
 */
class ErrorURLTest  {

    @Test
    void construct() {
        ErrorURL errorURL = new ErrorURL(500, "https://err.fuxing.dev/dev.fuxing.err.UnknownException?uuid=1234", "Message");

        assertEquals(500, errorURL.getCode());
        assertEquals("https://err.fuxing.dev/dev.fuxing.err.UnknownException?uuid=1234", errorURL.getUrl());
        assertEquals("Message", errorURL.getMessage());

        assertEquals("1234", errorURL.getUuid());

        assertTrue(errorURL.is("err.fuxing.dev", "dev.fuxing.err.UnknownException"));
        assertFalse(errorURL.is("err.fuxing.dev", "UnknownException"));
        assertFalse(errorURL.is("err.not.fuxing.dev", "dev.fuxing.err.UnknownException"));
        assertFalse(errorURL.is("err.not.fuxing.dev", "UnknownException"));
    }

    @Test
    void invalidUrl() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            throw new ErrorURL(500, "/err.fuxing.dev/dev.fuxing.err.UnknownException?uuid=1234", "Message");
        });

        assertEquals(exception.getCause().getClass(), MalformedURLException.class);
    }
}
