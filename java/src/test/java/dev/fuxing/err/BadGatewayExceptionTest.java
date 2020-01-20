package dev.fuxing.err;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author Fuxing Loh
 * @since 2020-01-20 at 14:11
 */
public class BadGatewayExceptionTest extends AbstractTest {

    @Test
    void empty() {
        assertErrorURL(assertThrows(BadGatewayException.class, () -> {
            throw new BadGatewayException();
        }), BadGatewayException.class, 502);
    }

    @Test
    void message() {
        assertErrorURL(assertThrows(BadGatewayException.class, () -> {
            throw new BadGatewayException("message 1");
        }), BadGatewayException.class, 502, "message 1");
    }

    @Test
    void messageException() {
        assertErrorURL(assertThrows(BadGatewayException.class, () -> {
            throw new BadGatewayException("message 2", new NullPointerException());
        }), BadGatewayException.class, 502, "message 2", NullPointerException.class);
    }
}
