package assessment.factories.period;

import assessment.entities.period.Period;
import assessment.testbase.TestBase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeriodFactory extends TestBase {

    private Period assembleBasePeriod() {

		Period basePeriod = new Period();

		basePeriod.setTemplateId(VALID_OBJECT_NAME);
		basePeriod.setSeriesNumber(generateRandomInteger(1, 10));
		basePeriod.setName(VALID_PERIOD_NAME + generateRandomString(5));
		basePeriod.setTeamId(generateRandomHash(24));
		basePeriod.setDateTriggered(new Date());
		basePeriod.setVersion(VALID_ENTITY_VERSION);

		return basePeriod;

    }

	private Period assembleBasePeriodWithId() {

		Period basePeriodWithId = assembleBasePeriod();
		basePeriodWithId.setId(generateRandomHash(24));
		return basePeriodWithId;

	}

    /**
     * Assembles a period object
     * @param periodOption The type of period to assemble
     * @return The period object
     */
    public Period assemblePeriod(PeriodOption periodOption) {

        Period period = assembleBasePeriodWithId();

        switch(periodOption){

            case VALID_PERIOD_WITH_ID:
				break;

            case VALID_PERIOD_WITHOUT_ID:
				period = assembleBasePeriod();
                break;

            case INVALID_PERIOD_TEMPLATEID_NULL:
                period.setTemplateId(null);
                break;

            case INVALID_PERIOD_TEMPLATEID_EMPTY:
                period.setTemplateId("");
                break;

			case INVALID_PERIOD_SERIES_NUMBER_NULL:
                period.setSeriesNumber(null);
                break;

            case INVALID_PERIOD_SERIES_NUMBER_ZERO:
                period.setSeriesNumber(0);
                break;

            case INVALID_PERIOD_NAME_NULL:
                period.setName(null);
                break;

            case INVALID_PERIOD_NAME_WITH_SPECIAL_CHARS:
                period.setName(INVALID_OBJECT_NAME_SPECIAL_CHARACTERS);
                break;

            case INVALID_PERIOD_NAME_EMPTY_STRING:
                period.setName(EMPTY_STRING);
                break;

            case INVALID_PERIOD_NAME_TOO_LONG:
                period.setName(generateRandomString(101));
                break;

            case INVALID_PERIOD_TEAM_ID_NULL:
                period.setTeamId(null);
                break;

            case INVALID_PERIOD_TEAM_ID_EMPTY_STRING:
                period.setTeamId(EMPTY_STRING);
                break;

            case INVALID_PERIOD_DATE_NULL:
                period.setDateTriggered(null);
                break;

            case INVALID_PERIOD_SUMMARY_SCORE_MIN:
                period.setSummaryScore(generateRandomDouble(SMALL_SUMMARY_SCORE, 1.0));
                break;

            case INVALID_PERIOD_SUMMARY_SCORE_MAX:
                period.setSummaryScore(generateRandomDouble(LARGE_SUMMARY_SCORE, 5.01));
                break;

            case INVALID_PERIOD_VERSION_NULL:
                period.setVersion(null);
                break;

            case INVALID_PERIOD_VERSION_ZERO:
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
