package dev.fuxing.err;

/**
 * @author Fuxing Loh
 * @since 2016-12-10 at 11:26
 */
public class JsonErr extends Err {

    public JsonErr() {
        super(400, "JSON malformed.");
    }

    public JsonErr(String message) {
        super(400, message);
    }

    public JsonErr(String message, Throwable throwable) {
        super(400, message, throwable);
    }
}
