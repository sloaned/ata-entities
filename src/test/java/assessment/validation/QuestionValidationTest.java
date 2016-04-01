package assessment.validation;

import assessment.entities.Question.Question;
import assessment.factories.Question.QuestionFactory;
import assessment.factories.Question.QuestionOption;
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
    public void TestValidQuantitativeQuestion() {
        testQuestion = questionFactory.assembleQuestion(QuestionOption.VALID_QUANTITATIVE_QUESTION);
        Set<ConstraintViolation<Question>> violations = validator.validate(testQuestion);
        assertTrue("INVALID QUESTION: the question factory assembled a question that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void TestValidQualitativeQuestion() {
        testQuestion = questionFactory.assembleQuestion(QuestionOption.VALID_QUALITATIVE_QUESTION);
        Set<ConstraintViolation<Question>> violations = validator.validate(testQuestion);
        assertTrue("INVALID QUESTION: the question factory assembled a question that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void TestNullTypeQuestion() {
        testQuestion = questionFactory.assembleQuestion(QuestionOption.NULL_TYPE_QUESTION);
        assertThereIsExactlyOneViolation(validator, testQuestion);
    }

    @Test
    public void TestLongLabelQuestion() {
        testQuestion = questionFactory.assembleQuestion(QuestionOption.LONG_LABEL_QUESTION);
        assertThereIsExactlyOneViolation(validator, testQuestion);
    }

    @Test
    public void TestEmptyLabelQuestion() {
        testQuestion = questionFactory.assembleQuestion(QuestionOption.EMPTY_LABEL_QUESTION);
        assertThereIsExactlyOneViolation(validator, testQuestion);
    }

    @Test
    public void TestNullLabelQuestion() {
        testQuestion = questionFactory.assembleQuestion(QuestionOption.NULL_LABEL_QUESTION);
        assertThereIsExactlyOneViolation(validator, testQuestion);
    }

    @Test
    public void TestNullVersionQuestion() {
        testQuestion = questionFactory.assembleQuestion(QuestionOption.NULL_VERSION_QUESTION);
        assertThereIsExactlyOneViolation(validator, testQuestion);
    }

}
