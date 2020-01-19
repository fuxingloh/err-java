package dev.fuxing.err;

/**
 * @author Fuxing Loh
 * @since 2016-12-10 at 11:26
 */
public class JsonException extends Err {

    public JsonException() {
        super(400, "JSON malformed.");
    }

    public JsonException(String message) {
        super(400, message);
    }

    public JsonException(String message, Throwable throwable) {
        super(400, message, throwable);
    }
}
