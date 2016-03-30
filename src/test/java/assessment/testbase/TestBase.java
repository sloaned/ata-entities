package assessment.testbase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hmccardell on 3/29/2016.
 */
public class TestBase extends TestBaseConstants {

    protected Date getDate(String date) throws ParseException {
        if (date == null) {
            return null;
        }

        DateFormat dateFormat = new SimpleDateFormat(VALID_DATE_FORMAT);
        return dateFormat.parse(date);
    }








}
