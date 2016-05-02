package assessment.validation;

import assessment.entities.period.Period;
import assessment.factories.period.PeriodFactory;
import assessment.factories.period.PeriodOption;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PeriodValidationTest {

    private PeriodFactory factory;
    public Validator validator;

    @Before
    public void setup() {
        factory = new PeriodFactory();
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    private void assertThereIsExactlyOneViolation(Validator validator, Period period) {
        Set<ConstraintViolation<Period>> violations = validator.validate(period);
        assertFalse("VALID PERIOD: the period factory assembled a period that passes entity validation", violations.isEmpty());
        assertFalse("INVALID PERIOD: the period factory assembled a period that failed " + violations.size() + " validations", violations.size() > 1);
    }

    @Test
    public void happyValidPeriodWithIdPassesValidation() {
        Period period = factory.assemblePeriod(PeriodOption.VALID_PERIOD_WITH_ID);

        Set<ConstraintViolation<Period>> violations = validator.validate(period);
        assertTrue("INVALID PERIOD: the period factory assembled a period that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void happyValidPeriodWithoutIdPassesValidation() {
        Period period = factory.assemblePeriod(PeriodOption.VALID_PERIOD_WITHOUT_ID);

        Set<ConstraintViolation<Period>> violations = validator.validate(period);
        assertTrue("INVALID PERIOD: the period factory assembled a period that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void sadInvalidPeriodTemplateNull() {
        Period period = factory.assemblePeriod(PeriodOption.INVALID_PERIOD_TEMPLATE_NULL);

        assertThereIsExactlyOneViolation(validator, period);
    }

    @Test
    public void sadInvalidPeriodWithSeriesNumberAsNullFailsValidation() {
        Period period = factory.assemblePeriod(PeriodOption.INVALID_PERIOD_SERIES_NUMBER_NULL);

        assertThereIsExactlyOneViolation(validator, period);
    }

    @Test
    public void sadInvalidPeriodWithSeriesNumberAs0FailsValidation() {
        Period period = factory.assemblePeriod(PeriodOption.INVALID_PERIOD_SERIES_NUMBER_ZERO);

        assertThereIsExactlyOneViolation(validator, period);
    }

    @Test
    public void sadInvalidPeriodWithNameAsNullFailsValidation() {
        Period period = factory.assemblePeriod(PeriodOption.INVALID_PERIOD_NAME_NULL);

        assertThereIsExactlyOneViolation(validator, period);
    }

    @Test
    public void sadInvalidPeriodWithNameContainingSpecialCharsFailsValidation() {
        Period period = factory.assemblePeriod(PeriodOption.INVALID_PERIOD_NAME_WITH_SPECIAL_CHARS);

        assertThereIsExactlyOneViolation(validator, period);
    }

    @Test
    public void sadInvalidPeriodWithNameAsEmptyStringFailsValidation() {
        Period period = factory.assemblePeriod(PeriodOption.INVALID_PERIOD_NAME_EMPTY_STRING);

        Set<ConstraintViolation<Period>> violations = validator.validate(period);
        assertTrue("Entity passes either NotEmpty validation, Pattern validation, or both on name", violations.size() == 2);
    }

    @Test
    public void sadInvalidPeriodWithNameContainingAStringThatsTooLongFailsValidation() {
        Period period = factory.assemblePeriod(PeriodOption.INVALID_PERIOD_NAME_TOO_LONG);

        assertThereIsExactlyOneViolation(validator, period);
    }

    @Test
    public void sadInvalidPeriodWithTeamIdAsNullStringFailsValidation() {
        Period period = factory.assemblePeriod(PeriodOption.INVALID_PERIOD_TEAM_ID_NULL);

        assertThereIsExactlyOneViolation(validator, period);
    }

    @Test
    public void sadInvalidPeriodWithTeamIdAsEmptyStringFailsValidation() {
        Period period = factory.assemblePeriod(PeriodOption.INVALID_PERIOD_TEAM_ID_EMPTY_STRING);

        assertThereIsExactlyOneViolation(validator, period);
    }

    @Test
    public void sadInvalidPeriodWithDateTriggeredAsNullFailsValidation() {
        Period period = factory.assemblePeriod(PeriodOption.INVALID_PERIOD_DATE_NULL);

        assertThereIsExactlyOneViolation(validator, period);
    }

    @Test
    public void sadInvalidPeriodSummaryScoreMinFailsValidation() {
        Period period = factory.assemblePeriod(PeriodOption.INVALID_PERIOD_SUMMARY_SCORE_MIN);

        assertThereIsExactlyOneViolation(validator, period);
    }

    @Test
    public void sadInvalidPeriodSummaryScoreMaxFailsValidation() {
        Period period = factory.assemblePeriod(PeriodOption.INVALID_PERIOD_SUMMARY_SCORE_MAX);

        assertThereIsExactlyOneViolation(validator, period);
    }

    @Test
    public void sadInvalidPeriodWithVersionAsNullFailsValidation() {
        Period period = factory.assemblePeriod(PeriodOption.INVALID_PERIOD_VERSION_NULL);

        assertThereIsExactlyOneViolation(validator, period);
    }

    @Test
    public void sadInvalidPeriodWithVersionAs0FailsValidation() {
        Period period = factory.assemblePeriod(PeriodOption.INVALID_PERIOD_VERSION_ZERO);

        assertThereIsExactlyOneViolation(validator, period);
    }
}
