package dev.fuxing.err;

import com.typesafe.config.ConfigFactory;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/**
 * Err, an idea to <b>full-stack language agnostic error handling</b> that can survive transport between service and
 * client.
 *
 * <li>HTTP status code, a language agnostic standardised specification for everyone to understand.</li>
 * <li>URL of the error, a universal place to host your errors to speed up debugging.</li>
 * <li>UUID of the error, unique and passed along from err to err.</li>
 * <li>Message of the error, human readable message for developer and user. Passed along from err to err.</li>
 *
 * @author Fuxing Loh
 * @since 2017-06-16 at 12:42
 */
public class Err extends RuntimeException {
    public static final String DOMAIN;
    public static final String PACKAGE;

    static {
        String domain = ConfigFactory.load().getString("err.domain");
        DOMAIN = domain.replaceAll("/+$", "") + "/";

        PACKAGE = Err.class.getPackage().getName();
    }

    private final int code;
    private final String url;
    private String uuid;
    private String message;

    /**
     * @param code    HTTP status code
     * @param message human readable message for developer and user
     */
    protected Err(int code, String message) {
        super(message);
        this.code = code;
        this.url = getUrl(getClass());
        this.uuid = UUID.randomUUID().toString();
        this.message = message;
    }

    /**
     * @param code      HTTP status code
     * @param message   human readable message for developer and user
     * @param throwable root error for stacktrace
     */
    protected Err(int code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
        this.url = getUrl(getClass());
        this.uuid = UUID.randomUUID().toString();
        this.message = message;
    }

    /**
     * @return status code, following HTTP status description
     */
    public int getCode() {
        return code;
    }

    /**
     * @return uniquely identifiable exception type
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return uuid of err that is pass along from err to err
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @return human readable message
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * @param clazz of the err
     * @param <T>   err type
     * @return type of the error with domain and it's an url destination
     */
    public static <T extends Err> String getUrl(Class<T> clazz) {
        String packageName = clazz.getPackage().getName();
        if (packageName.equals("dev.fuxing.err")) {
            return DOMAIN + clazz.getSimpleName();
        }

        return DOMAIN + clazz.getName();
    }

    /**
     * @param url of the err
     * @return Class of the err type
     * @throws ClassNotFoundException if error not found
     */
    public static Class<?> getClass(String url) throws ClassNotFoundException {
        String className = StringUtils.removeStart(url, DOMAIN);
        if (className.contains(".")) {
            return Class.forName(className);
        }
        return Class.forName(PACKAGE + "." + className);
    }

    /**
     * @param url     of the error to parse
     * @param uuid    of the error to pass along
     * @param message of the error to pass along
     * @return parsed Err
     * @throws ErrException cased by parsing
     */
    public static Err parse(String url, String uuid, String message) throws ErrException {
        try {
            Class<?> clazz = Err.getClass(url);
            Constructor<?> constructor = clazz.getConstructor();

            Err err = (Err) constructor.newInstance();
            err.uuid = uuid;
            err.message = message;
            return err;
        } catch (ClassNotFoundException ex) {
            throw new ErrException("Error class not found for " + url);
        } catch (NoSuchMethodException ex) {
            throw new ErrException("public Constructor.<init>(String) not found for " + url);
        } catch (IllegalAccessException ex) {
            throw new ErrException("Constructor.<init>(String) access control for " + url);
        } catch (InstantiationException ex) {
            throw new ErrException("Abstract error class for " + url);
        } catch (InvocationTargetException ex) {
            throw new ErrException("Underlying constructor initialization error for " + url);
        }
    }
}
