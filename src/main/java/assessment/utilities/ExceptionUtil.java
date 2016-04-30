package assessment.utilities;

/**
 * Created by mmosley on 4/29/2016.
 */
public class ExceptionUtil {

    public static final String DUPLICATE_KEY = "duplicate key value violates unique";

    public String convertDatabaseExceptionToERRMessage(Exception e) {
        if (isNotUniqueException(e)) {
            return "Duplicate entry in database";
        } else {
            return "Unknown database error";
        }
    }

    public String getRootCauseMessage(Throwable e) {
        Throwable cause = e;
        while (cause.getCause() != null) {
            cause = cause.getCause();
        }
        return cause.getMessage();
    }

    public boolean isNotUniqueException(Exception e) {
        return getRootCauseMessage(e).contains(DUPLICATE_KEY);
    }

}
