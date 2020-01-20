package dev.fuxing.err;


import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
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
public class ErrorURL extends RuntimeException {

    /**
     * My static domain, for all the common error.
     */
    static final String FUXING_ERR_DOMAIN = "err.fuxing.dev";

    /**
     * https going to be the default, it's very easy to setup https now.
     */
    private static final String SCHEME = "https";

    private final int code;
    private final String url;
    private final String message;

    private final String host;
    private final String type;
    private final String uuid;

    /**
     * Helper method to create Exception
     *
     * @param code      HTTP status code, following HTTP status description.
     * @param host      of where the error is going to be hosted e.g. (err.fuxing.dev)
     * @param clazz     of the error, to extract class name to be used as the type
     * @param message   static human readable message
     * @param throwable for root cause tracing
     * @param <T>       to ensure it extends ErrorURL
     */
    public <T extends ErrorURL> ErrorURL(int code, String host, Class<T> clazz, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
        this.type = clazz.getName();
        this.message = message;
        this.host = host;
        this.uuid = UUID.randomUUID().toString();

        this.url = SCHEME + "://" + host + "/" + type + "?uuid=" + uuid;
    }

    /**
     * @param code    HTTP status code, following HTTP status description.
     * @param url     uniquely identifiable exception type
     * @param message human readable message
     */
    public ErrorURL(int code, String url, String message) {
        this(code, url, message, null);
    }

    /**
     * @param code      HTTP status code, following HTTP status description.
     * @param url       uniquely identifiable exception type
     * @param message   human readable message
     * @param throwable for root cause tracing
     */
    public ErrorURL(int code, String url, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
        this.url = url;
        this.message = message;

        try {
            URL uri = new URL(url);
            this.host = uri.getHost();
            this.type = uri.getPath().replaceFirst("^/", "");

            Map<String, String> queries = splitQuery(uri);
            this.uuid = queries.get("uuid");

        } catch (MalformedURLException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Follows the HTTP status code spec, it's an easy to understand number that proxy or load balancer knows what to do.
     *
     * @return HTTP status code, following HTTP status description.
     */
    public int getCode() {
        return code;
    }

    /**
     * Think of it as an `URI`, being a unique identifier that will guarantee uniqueness across systems and company.
     * Also an `URL` where user/programmer can go to to seek help regarding the error and what causes it.
     * Also included, `?uuid=1234` for tracing, where internal engineer can use that info for tracing.
     *
     * @return uniquely identifiable exception type
     */
    public String getUrl() {
        return url;
    }

    /**
     * Just an error message that is detail enough for anyone to understand what to do next.
     * Message must not contain any information of object manipulated, you might accidentally leak user/security info.
     * Same for stacktrace, or internal error message, just don't include any dynamic info.
     * Error message must be static message you wrote and never inferred.
     *
     * @return human readable message
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * @return uuid of err that is pass along from err to err
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param host to match
     * @param type to match
     * @return whether error is from 'domain' and 'type'
     */
    public boolean is(String host, String type) {
        return this.host.equals(host) && this.type.equals(type);
    }

    /**
     * A pure java, split query implementation
     * https://stackoverflow.com/questions/13592236/parse-a-uri-string-into-name-value-collection
     */
    private static Map<String, String> splitQuery(URL url) throws UnsupportedEncodingException {
        Map<String, String> query_pairs = new LinkedHashMap<>();
        String query = url.getQuery();
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
        }
        return query_pairs;
    }
}
