package dev.fuxing.err;

/**
 * Err implementation err.
 * <br>
 * <li>Err class not found.</li>
 * <li>ImplErr(Err err) constructor not implemented.</li>
 *
 * @author Fuxing Loh
 * @since 2020-01-07 at 12:09
 */
public final class ImplErr extends Err {

    /**
     * @param reason to help identity error
     */
    public ImplErr(String reason) {
        super(500, "Err implementation error.", new Exception(reason));
    }
}
