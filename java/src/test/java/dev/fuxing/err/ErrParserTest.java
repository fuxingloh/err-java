package dev.fuxing.err;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fuxing Loh
 * @since 2020-01-07 at 12:26
 */
class ErrParserTest {

    @Test
    void notFound() {
        assertThrows(ErrException.class, () -> {
            throw Err.parse("ABC", UUID.randomUUID().toString(), "");
        });
    }

}
