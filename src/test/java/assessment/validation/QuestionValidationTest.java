package assessment.validation;

import assessment.entities.question.Question;
import assessment.factories.question.QuestionFactory;
import assessment.factories.question.QuestionOption;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by jtucker on 3/31/2016.
 */
public class QuestionValidationTest {

    private static Validator validator;
    private Question testQuestion;
    QuestionFactory questionFactory = new QuestionFactory();

    private void assertThereIsExactlyOneViolation(Validator validator, Question question) {
        Set<ConstraintViolation<Question>> violations = validator.validate(question);
        assertFalse("VALID QUESTION: the question factory assembled a question that passes entity validation", violations.isEmpty());
        assertFalse("INVALID QUESTION: the question factory assembled a question that failed multiple validations", violations.size() > 1);
    }

    @BeforeClass
    public static void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void HappyPathBooleanQuestion() {
        testQuestion = questionFactory.assembleQuestion(QuestionOption.VALID_BOOLEAN_QUESTION);
        Set<ConstraintViolation<Question>> violations = validator.validate(testQuestion);
        assertTrue("INVALID QUESTION: the question factory assembled a question that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void HappyPathMultipleChoiceQuestion() {
        testQuestion = questionFactory.assembleQuestion(QuestionOption.VALID_MULTIPLE_CHOICE_QUESTION);
        Set<ConstraintViolation<Question>> violations = validator.validate(testQuestion);
        assertTrue("INVALID QUESTION: the question factory assembled a question that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void HappyPathCompetencyQuestion() {
        testQuestion = questionFactory.assembleQuestion(QuestionOption.VALID_COMPETENCY_QUESTION);
        Set<ConstraintViolation<Question>> violations = validator.validate(testQuestion);
        assertTrue("INVALID QUESTION: the question factory assembled a question that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void SadPathNullType() {
        testQuestion = questionFactory.assembleQuestion(QuestionOption.INVALID_QUESTION_TYPE_NULL);
        assertThereIsExactlyOneViolation(validator, testQuestion);
    }

    @Test
    public void SadPathLabelTooLong() {
        testQuestion = questionFactory.assembleQuestion(QuestionOption.INVALID_QUESTION_LABEL_LONG);
        assertThereIsExactlyOneViolation(validator, testQuestion);
    }

    @Test
    public void SadPathLabelEmpty() {
        testQuestion = questionFactory.assembleQuestion(QuestionOption.INVALID_QUESTION_LABEL_EMPTY);
        assertThereIsExactlyOneViolation(validator, testQuestion);
    }

    @Test
    public void SadPathLabelNull() {
        testQuestion = questionFactory.assembleQuestion(QuestionOption.INVALID_QUESTION_LABEL_NULL);
        assertThereIsExactlyOneViolation(validator, testQuestion);
    }

    @Test
    public void SadPathVersionNull() {
        testQuestion = questionFactory.assembleQuestion(QuestionOption.INVALID_QUESTION_VERSION_NULL);
        assertThereIsExactlyOneViolation(validator, testQuestion);
    }

    @Test
    public void SadPathVersionZero() {
        testQuestion = questionFactory.assembleQuestion(QuestionOption.INVALID_QUESTION_VERSION_NULL);
        assertThereIsExactlyOneViolation(validator, testQuestion);
    }

}
