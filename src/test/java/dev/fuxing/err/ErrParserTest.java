package dev.fuxing.err;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fuxing Loh
 * @since 2020-01-07 at 12:26
 */
class ErrParserTest {

    @Test
    void notFound() {
        assertThrows(ImplErr.class, () -> {
            throw Err.parse("ABC", "");
        });
    }

}
