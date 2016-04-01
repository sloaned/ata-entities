package assessment.testbase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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


    public String generateRandomString(Integer length) {
        Random rng = new Random();
        String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] randomCharacters = new char[length];
        for (int i = 0; i < length; i++) {
            randomCharacters[i] = characterSet.charAt(rng.nextInt(characterSet
                    .length()));
        }
        return new String(randomCharacters);
    }

}
