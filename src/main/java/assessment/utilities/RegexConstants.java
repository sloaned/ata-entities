package assessment.utilities;

/**
 * Created by gfisher on 3/14/2016.
 */
public class RegexConstants {
    public static final String USERNAME = "^[0-9a-zA-Z-@\\.]{1,32}$";
    public static final String PASSWORD = "^(?=.*\\d)(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,32}$";
    public static final String EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
}
