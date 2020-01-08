package dev.fuxing.err;

/**
 * A subset of bad request error.
 * Parameter is required but no processable.
 * Could be blank, empty or not formatted correctly.
 *
 * @author Fuxing Loh
 * @since 2016-12-10 at 11:16
 */
public class ParameterErr extends BadRequestErr {

    public ParameterErr() {
    }

    public ParameterErr(String message) {
        super(message);
    }

    public ParameterErr(String message, Throwable throwable) {
        super(message, throwable);
    }
}
