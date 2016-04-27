package assessment.factories.period;

import assessment.entities.period.Period;
import assessment.testbase.TestBase;

import java.util.ArrayList;
import java.util.Calendar;
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
                period.setAssessmentId(generateRandomHash(24));
                period.setSeriesNumber(generateRandomInteger(1, 10));
                period.setName(VALID_PERIOD_NAME + generateRandomString(5));
                period.setTeamName(VALID_TEAM_NAME + "-" + generateRandomString(5));
                period.setDateTriggered(new Date());
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
