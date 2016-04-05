package assessment.validation;

import assessment.entities.feedback.Feedback;
import assessment.entities.question.QuestionType;
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

    @BeforeClass
    public static void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();

    }

    @Test
    public void typeNull() {
        Feedback myFeedback = new Feedback(null, "asd", 1, "grd", 3);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("should not pass due to null type", violations.isEmpty());
    }

    @Test
    public void versionNull() {
        QuestionType type = QuestionType.BOOLEAN;

        Feedback myFeedback = new Feedback(type, "", 2, "", null);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("should not pass because everything is null", violations.isEmpty());
    }

    @Test
    public void labelEmpty() {
        Feedback myFeedback = new Feedback(null, "", 0, "", 0);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("should fail due to empty strings and object", violations.isEmpty());
    }

    @Test
    public void HappyPath() {
        QuestionType type = QuestionType.BOOLEAN;
        Feedback myFeedback = new Feedback(type, "sag", 2, "sdf", 4);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertTrue("should pass", violations.isEmpty());
    }

    @Test
    public void labelTooLongTest() {
        QuestionType type = QuestionType.BOOLEAN;
        String word = "";
        for (int i = 0; i < 500; i++) {
            word = word + "B";
        }
        Feedback myFeedback = new Feedback(type, word, 3, "wet", 3);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("should fail because your label was too long", violations.isEmpty());
    }

    @Test
    public void commentTooLongTest() {
        QuestionType type = QuestionType.BOOLEAN;
        String word = "";
        for (int i = 0; i < 1501; i++) {
            word = word + "B";
        }
        Feedback myFeedback = new Feedback(type, "wet", 3, word, 3);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("should fail because your comment was too long", violations.isEmpty());
    }

    @Test
    public void scoreRangeTestOverBound() {
        QuestionType type = QuestionType.BOOLEAN;
        String word = "word to ya";
        Feedback myFeedback = new Feedback(type, word, 9, word, 3);
        Set<ConstraintViolation<Feedback>> violations = validator.validate(myFeedback);
        assertFalse("your rating was out of the acceptable range", violations.isEmpty());
    }
}
