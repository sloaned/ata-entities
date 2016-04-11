package assessment.validation;

import assessment.entities.feedback.Feedback;
import assessment.factories.feedback.FeedbackFactory;
import static assessment.factories.feedback.FeedbackOption.*;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.text.ParseException;
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
    public void HappyPathFeedbackValidation() {
        Feedback myFeedback = feedbackFactory.assembleFeedback(VALID_QUANTITATIVE_FEEDBACK);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertTrue("valid feedback assembler failed", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfFeedbackTypeNull() {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_TYPE_NULL);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("should not pass due to null type", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfFeedbackLabelEmpty() {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_LABEL_EMPTY);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("should fail due to empty strings and object", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfFeedbackLabelTooLongTest() {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_LABEL_LONG);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("should fail because your label was too long", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfFeedbackCommentTooLongTest() {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_COMMENT_LONG);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("should fail because your comment was too long", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfFeedbackScoreRangeTestOverBound() {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_SCORE_OVERBOUND);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("your rating was out of the acceptable range", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfFeedbackFactoryVersionZero() throws ParseException {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_VERSION_ZERO);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("expected version 0", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfFeedbackFactoryNullVersion() throws ParseException{
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_VERSION_NULL);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("expected version null", violations.isEmpty());
    }
}
