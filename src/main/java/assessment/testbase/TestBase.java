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


    /**
     * generates a random string composed of capital letters between A and Z
     * @param length - number of characters in the generated string
     * @return - the randomly generated string
     */
    protected String generateRandomString(Integer length) {
        Random rng = new Random();
        String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] randomCharacters = new char[length];
        for (int i = 0; i < length; i++) {
            randomCharacters[i] = characterSet.charAt(rng.nextInt(characterSet
                    .length()));
        }
        return new String(randomCharacters);
    }


    /**
     * generates a random string composed of capital letters between A and Z
     * and numbers 0 through 9 to simulate a hash
     * @param length - number of characters in the generated string
     * @return - the randomly generated string
     */
    protected String generateRandomHash(Integer length) {
        Random rng = new Random();
        String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        char[] randomCharacters = new char[length];
        for (int i = 0; i < length; i++) {
            randomCharacters[i] = characterSet.charAt(rng.nextInt(characterSet
                    .length()));
        }
        return new String(randomCharacters);
    }


    /**
     * generates a random Double in the range of a minimum value (inclusive)
     * and a maximum value (exclusive)
     * @return - the randomly generated Double
     */
    protected Double generateRandomDouble(Double min, Double max) {
        Double range = max - min;
        Random rng = new Random();

        return min + rng.nextDouble() * range;
    }

    /**
     * Generates a random integer between min and max range, both inclusive
     * @param min The minimum value
     * @param max The maximum value
     * @return The random number
     */
    protected int generateRandomInteger(int min, int max) {
        //add one to make it inclusive
        int range = max + 1 - min;
        double random = Math.random() * range;

        return min + (int) random;
    }
}
