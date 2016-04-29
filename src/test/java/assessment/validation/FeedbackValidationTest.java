package assessment.validation;

import assessment.entities.feedback.Feedback;
import assessment.factories.feedback.FeedbackFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.text.ParseException;
import java.util.Set;

import static assessment.factories.feedback.FeedbackOption.*;
import static assessment.utilities.ErrorMessages.INVALID_DUE_TO_EMPTY_STRING;
import static assessment.utilities.ErrorMessages.INVALID_DUE_TO_NULL_TYPE;
import static assessment.utilities.ErrorMessages.VALID_FEEDBACK_ASSEMBLER_FAILED;
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
        Feedback myFeedback = feedbackFactory.assembleFeedback(VALID_FEEDBACK);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertTrue("", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfFeedbackTypeNull() {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_TYPE_NULL);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfFeedbackLabelEmpty() {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_LABEL_EMPTY);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfFeedbackLabelTooLong() {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_LABEL_LONG);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("should fail because your label was too long", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfFeedbackScoreZero() {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_SCORE_ZERO);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("your rating was out of the acceptable range", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfFeedbackScoreOverbound() {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_SCORE_OVERBOUND);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("your rating was out of the acceptable range", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfFeedbackCommentTooLong() {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_COMMENT_LONG);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("should fail because your comment was too long", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfFeedbackFactoryNullVersion() throws ParseException {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_VERSION_NULL);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("expected version null", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfFeedbackFactoryVersionZero() throws ParseException {
        Feedback myFeedback = feedbackFactory.assembleFeedback(INVALID_FEEDBACK_VERSION_ZERO);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("expected version 0", violations.isEmpty());
    }
}
