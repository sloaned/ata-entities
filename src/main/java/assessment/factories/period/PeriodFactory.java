package assessment.factories.period;

import assessment.entities.period.Period;
import assessment.testbase.TestBase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeriodFactory extends TestBase {

    /**
     * Assembles a period object
     * @param periodOption The type of period to assemble
     * @return The period object
     */
    public Period assemblePeriod(PeriodOption periodOption) {

        Period period = new Period();

        switch(periodOption){
            case VALID_PERIOD_WITH_ID:
                period.setId(generateRandomHash(24));
                period.setTemplate(TEMPLATE);
                period.setSeriesNumber(generateRandomInteger(1, 10));
                period.setName(VALID_PERIOD_NAME + generateRandomString(5));
                period.setTeamId(generateRandomHash(24));
                period.setDateTriggered(new Date());
                period.setVersion(VALID_ENTITY_VERSION);
                break;
            case VALID_PERIOD_WITHOUT_ID:
                period.setTemplate(TEMPLATE);
                period.setSeriesNumber(generateRandomInteger(1, 10));
                period.setName(VALID_PERIOD_NAME + generateRandomString(5));
                period.setTeamId(generateRandomHash(24));
                period.setDateTriggered(new Date());
                period.setVersion(VALID_ENTITY_VERSION);
                break;
            case INVALID_PERIOD_TEMPLATE_NULL:
                period.setId(generateRandomHash(24));
                period.setTemplate(null);
                period.setSeriesNumber(generateRandomInteger(1, 10));
                period.setName(VALID_PERIOD_NAME + generateRandomString(5));
                period.setTeamId(generateRandomHash(24));
                period.setDateTriggered(new Date());
                period.setVersion(VALID_ENTITY_VERSION);
                break;
           case INVALID_PERIOD_SERIES_NUMBER_NULL:
                period.setId(generateRandomHash(24));
               period.setTemplate(TEMPLATE);
                period.setSeriesNumber(null);
                period.setName(VALID_PERIOD_NAME + generateRandomString(5));
                period.setTeamId(generateRandomHash(24));
                period.setDateTriggered(new Date());
                period.setVersion(VALID_ENTITY_VERSION);
                break;
            case INVALID_PERIOD_SERIES_NUMBER_ZERO:
                period.setId(generateRandomHash(24));
                period.setTemplate(TEMPLATE);
                period.setSeriesNumber(0);
                period.setName(VALID_PERIOD_NAME + generateRandomString(5));
                period.setTeamId(generateRandomHash(24));
                period.setDateTriggered(new Date());
                period.setVersion(VALID_ENTITY_VERSION);
                break;
            case INVALID_PERIOD_NAME_NULL:
                period.setId(generateRandomHash(24));
                period.setTemplate(TEMPLATE);
                period.setSeriesNumber(generateRandomInteger(1, 10));
                period.setName(null);
                period.setTeamId(generateRandomHash(24));
                period.setDateTriggered(new Date());
                period.setVersion(VALID_ENTITY_VERSION);
                break;
            case INVALID_PERIOD_NAME_WITH_SPECIAL_CHARS:
                period.setId(generateRandomHash(24));
                period.setTemplate(TEMPLATE);
                period.setSeriesNumber(generateRandomInteger(1, 10));
                period.setName(INVALID_OBJECT_NAME_SPECIAL_CHARACTERS);
                period.setTeamId(generateRandomHash(24));
                period.setDateTriggered(new Date());
                period.setVersion(VALID_ENTITY_VERSION);
                break;
            case INVALID_PERIOD_NAME_EMPTY_STRING:
                period.setId(generateRandomHash(24));
                period.setTemplate(TEMPLATE);
                period.setSeriesNumber(generateRandomInteger(1, 10));
                period.setName(EMPTY_STRING);
                period.setTeamId(generateRandomHash(24));
                period.setDateTriggered(new Date());
                period.setVersion(VALID_ENTITY_VERSION);
                break;
            case INVALID_PERIOD_NAME_TOO_LONG:
                period.setId(generateRandomHash(24));
                period.setTemplate(TEMPLATE);
                period.setSeriesNumber(generateRandomInteger(1, 10));
                period.setName(generateRandomString(101));
                period.setTeamId(generateRandomHash(24));
                period.setDateTriggered(new Date());
                period.setVersion(VALID_ENTITY_VERSION);
                break;
            case INVALID_PERIOD_TEAM_ID_NULL:
                period.setId(generateRandomHash(24));
                period.setTemplate(TEMPLATE);
                period.setSeriesNumber(generateRandomInteger(1, 10));
                period.setName(VALID_PERIOD_NAME + generateRandomString(5));
                period.setTeamId("");
                period.setDateTriggered(new Date());
                period.setVersion(VALID_ENTITY_VERSION);
                break;
            case INVALID_PERIOD_TEAM_ID_EMPTY_STRING:
                period.setId(generateRandomHash(24));
                period.setTemplate(TEMPLATE);
                period.setSeriesNumber(generateRandomInteger(1, 10));
                period.setName(VALID_PERIOD_NAME + generateRandomString(5));
                period.setTeamId(EMPTY_STRING);
                period.setDateTriggered(new Date());
                period.setVersion(VALID_ENTITY_VERSION);
                break;
            case INVALID_PERIOD_DATE_NULL:
                period.setId(generateRandomHash(24));
                period.setTemplate(TEMPLATE);
                period.setSeriesNumber(generateRandomInteger(1, 10));
                period.setName(VALID_PERIOD_NAME + generateRandomString(5));
                period.setTeamId(generateRandomHash(24));
                period.setDateTriggered(null);
                period.setVersion(VALID_ENTITY_VERSION);
                break;
            case INVALID_PERIOD_VERSION_NULL:
                period.setId(generateRandomHash(24));
                period.setTemplate(TEMPLATE);
                period.setSeriesNumber(generateRandomInteger(1, 10));
                period.setName(VALID_PERIOD_NAME + generateRandomString(5));
                period.setTeamId(generateRandomHash(24));
                period.setDateTriggered(new Date());
                period.setVersion(null);
                break;
            case INVALID_PERIOD_VERSION_ZERO:
                period.setId(generateRandomHash(24));
                period.setTemplate(TEMPLATE);
                period.setSeriesNumber(generateRandomInteger(1, 10));
                period.setName(VALID_PERIOD_NAME + generateRandomString(5));
                period.setTeamId(generateRandomHash(24));
                period.setDateTriggered(new Date());
                period.setVersion(0);
                break;
        }

        return period;
    }

    /**
     * Assemble a list of periods
     *
     * @param count The number of period options to assemble
     * @param options The types of period options to assemble
     * @return A list of period objects with the given types
     */
    public List<Period> assemblePeriodsAsList(int count, PeriodOption... options) {

        List<Period> result = new ArrayList<>();

        int randomType;
        for (int i = 0; i < count; i++) {
            randomType = generateRandomInteger(0, options.length - 1);
            result.add(assemblePeriod(options[randomType]));
        }

        return result;
    }
}
