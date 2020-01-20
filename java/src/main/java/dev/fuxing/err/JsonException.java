package dev.fuxing.err;

/**
 * @author Fuxing Loh
 * @since 2016-12-10 at 11:26
 */
public class JsonException extends ErrorURL {

    public JsonException() {
        super(400, FUXING_ERR_DOMAIN, JsonException.class, "Your JSON is malformed.", null);
    }

    /**
     * Don't encode the JSON into string and send it.
     * You might accidentally leak user info.
     */
    public JsonException(String message) {
        super(400, FUXING_ERR_DOMAIN, JsonException.class, message, null);
    }

    public JsonException(String message, Throwable throwable) {
        super(400, FUXING_ERR_DOMAIN, JsonException.class, message, throwable);
    }
}
