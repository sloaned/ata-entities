package assessment.validation;

import assessment.entities.feedback.Feedback;
import assessment.factories.feedback.FeedbackFactory;
import static assessment.factories.feedback.FeedbackOption.*;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by bthomson on 3/28/2016.
 */

public class FeedbackValidationTest {
    private static Validator validator;
    private FeedbackFactory feedbackFactory = new FeedbackFactory();

    @BeforeClass
    public static void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();

    }

    @Test
    public void typeNull() {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_NULL_TYPE);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("should not pass due to null type", violations.isEmpty());
    }

    @Test
    public void versionNull() {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_NULL_VERSION);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("should not pass because everything is null", violations.isEmpty());
    }

    @Test
    public void labelEmpty() {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_EMPTY_LABEL);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("should fail due to empty strings and object", violations.isEmpty());
    }

    @Test
    public void HappyPath() {
        Feedback myFeedback = feedbackFactory.assembleFeedback(VALID_QUANTITATIVE_FEEDBACK);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertTrue("should pass", violations.isEmpty());
    }

    @Test
    public void labelTooLongTest() {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_LONG_LABEL);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("should fail because your label was too long", violations.isEmpty());
    }

    @Test
    public void commentTooLongTest() {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_LONG_COMMENT);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("should fail because your comment was too long", violations.isEmpty());
    }

    @Test
    public void scoreRangeTestOverBound() {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_OVERBOUND_SCORE);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("your rating was out of the acceptable range", violations.isEmpty());
    }
}
