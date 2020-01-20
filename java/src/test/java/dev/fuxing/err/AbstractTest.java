package dev.fuxing.err;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Fuxing Loh
 * @since 2020-01-20 at 14:36
 */
public abstract class AbstractTest {
    public static <T extends ErrorURL> void assertErrorURL(ErrorURL errorURL, Class<T> clazz, int code) {
        assertErrorURL(errorURL, clazz, code, errorURL.getMessage());
    }

    public static <T extends ErrorURL> void assertErrorURL(ErrorURL errorURL, Class<T> clazz, int code, String message) {
        assertErrorURL(errorURL, clazz, code, message, null);
    }

    public static <T extends ErrorURL> void assertErrorURL(ErrorURL errorURL, Class<T> clazz, int code, String message, Class rootErrorClass) {
        String url = "https://err.fuxing.dev/dev.fuxing.err." + clazz.getSimpleName();
        url += "?uuid=" + errorURL.getUuid();

        assertEquals(message, errorURL.getMessage());
        assertEquals(code, errorURL.getCode());
        assertNotNull(errorURL.getUuid());
        assertEquals(url, errorURL.getUrl());
        assertTrue(errorURL.is(ErrorURL.FUXING_ERR_DOMAIN, clazz.getName()));

        if (rootErrorClass != null) {
            assertEquals(rootErrorClass, errorURL.getCause().getClass());
        }
    }
}
