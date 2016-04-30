package assessment.validation;

import assessment.entities.team.ReviewPeriod;
import assessment.factories.team.ReviewPeriodFactory;
import assessment.factories.team.ReviewPeriodOption;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mmosley on 4/29/2016.
 */
public class ReviewPeriodValidationTest {

    private static Validator validator;
    private ReviewPeriod testReviewPeriod;
    ReviewPeriodFactory reviewPeriodFactory = new ReviewPeriodFactory();

    @BeforeClass
    public static void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void HappyPathValidationOfReviewPeriodFactoryValidReviewPeriod() {
        testReviewPeriod = reviewPeriodFactory.assembleReviewPeriod(ReviewPeriodOption.VALID_REVIEW_PERIOD);
        Set<ConstraintViolation<ReviewPeriod>> violations = validator.validate(testReviewPeriod);
        assertTrue("INVALID REVIEW PERIOD: the review period factory assembled a review period that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfReviewPeriodFactoryNameEmpty() {
        testReviewPeriod = reviewPeriodFactory.assembleReviewPeriod(ReviewPeriodOption.INVALID_REVIEW_PERIOD_NAME_EMPTY);
        Set<ConstraintViolation<ReviewPeriod>> violations = validator.validate(testReviewPeriod);
        assertFalse("INVALID REVIEW PERIOD: name is required", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfReviewPeriodFactoryNameHasSpecialCharacters() {
        testReviewPeriod = reviewPeriodFactory.assembleReviewPeriod(ReviewPeriodOption.INVALID_REVIEW_PERIOD_NAME_SPECIAL_CHARACTERS);
        Set<ConstraintViolation<ReviewPeriod>> violations = validator.validate(testReviewPeriod);
        assertFalse("INVALID REVIEW PERIOD: name should not include special characters", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfReviewPeriodFactoryNameTooLong() {
        testReviewPeriod = reviewPeriodFactory.assembleReviewPeriod(ReviewPeriodOption.INVALID_REVIEW_PERIOD_NAME_TOO_LONG);
        Set<ConstraintViolation<ReviewPeriod>> violations = validator.validate(testReviewPeriod);
        assertFalse("INVALID REVIEW PERIOD: name should not include special characters", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfReviewPeriodFactoryFrequencyNull() {
        testReviewPeriod = reviewPeriodFactory.assembleReviewPeriod(ReviewPeriodOption.INVALID_REVIEW_PERIOD_FREQUENCY_NULL);
        Set<ConstraintViolation<ReviewPeriod>> violations = validator.validate(testReviewPeriod);
        assertFalse("INVALID REVIEW PERIOD: frequency should not be null", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfReviewPeriodFactoryTemplateIdEmpty() {
        testReviewPeriod = reviewPeriodFactory.assembleReviewPeriod(ReviewPeriodOption.INVALID_REVIEW_PERIOD_TEMPLATE_ID_EMPTY);
        Set<ConstraintViolation<ReviewPeriod>> violations = validator.validate(testReviewPeriod);
        assertFalse("INVALID REVIEW PERIOD: template id should not be empty", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfReviewPeriodFactoryCurrentPeriodIdEmpty() {
        testReviewPeriod = reviewPeriodFactory.assembleReviewPeriod(ReviewPeriodOption.INVALID_REVIEW_PERIOD_CURRENT_PERIOD_ID_EMPTY);
        Set<ConstraintViolation<ReviewPeriod>> violations = validator.validate(testReviewPeriod);
        assertFalse("INVALID REVIEW PERIOD: current period id should not be empty", violations.isEmpty());
    }

}
