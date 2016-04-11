package assessment.validation;

import assessment.factories.assessment.AssessmentFactory;
import assessment.factories.assessment.AssessmentOption;
import assessment.entities.assessment.Assessment;
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
 * Created by Alysha Recore on 4/1/2016.
 */
public class AssessmentValidationTest {

    private static Validator validator;
    private Assessment testAssessment;
    AssessmentFactory assessmentFactory = new AssessmentFactory();

    private void assertThereIsExactlyOneViolation(Validator validator, Assessment assessment) {
        Set<ConstraintViolation<Assessment>> violations = validator.validate(assessment);
        assertFalse("VALID ASSESSMENT: the assessment factory assembled an assessment that passes entity validation", violations.isEmpty());
        assertFalse("INVALID ASSESSMENT: the assessment factory assembled an assessment that failed multiple validations", violations.size() > 1);
    }

    @BeforeClass
    public static void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void HappyPathAssessmentValidation() {
        testAssessment = assessmentFactory.assembleAssessment(AssessmentOption.VALID_ASSESSMENT);
        Set<ConstraintViolation<Assessment>> violations = validator.validate(testAssessment);
        assertTrue("INVALID ASSESSMENT: the assessment factory assembled an assessment that doesn't " +
                "pass entity validation", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfAssessmentFactoryBadAssessmentLongName() {
        testAssessment = assessmentFactory.assembleAssessment(AssessmentOption.INVALID_ASSESSMENT_NAME_LONG);
        assertThereIsExactlyOneViolation(validator, testAssessment);
    }

    @Test
    public void SadPathValidationOfAssessmentFactoryBadAssessmentBadName() {
        testAssessment = assessmentFactory.assembleAssessment(AssessmentOption.INVALID_ASSESSMENT_NAME_SPECIAL_CHARACTERS);
        assertThereIsExactlyOneViolation(validator, testAssessment);
    }

    @Test
    public void SadPathValidationOfAssessmentFactoryBadAssessmentNullName() {
        testAssessment = assessmentFactory.assembleAssessment(AssessmentOption.INVALID_ASSESSMENT_NULL_NAME);
        assertThereIsExactlyOneViolation(validator, testAssessment);
    }

    @Test
    public void SadPathValidationOfAssessmentFactoryVersionZero() throws ParseException {
        testAssessment = assessmentFactory.assembleAssessment(AssessmentOption.INVALID_ASSESSMENT_VERSION_ZERO);
        Set<ConstraintViolation<Assessment>> violations = validator.validate(testAssessment);
        assertFalse("expected version 0", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfAssessmentFactoryNullVersion() throws ParseException{
        testAssessment = assessmentFactory.assembleAssessment(AssessmentOption.INVALID_ASSESSMENT_VERSION_NULL);
        Set<ConstraintViolation<Assessment>> violations = validator.validate(testAssessment);
        assertFalse("expected version null", violations.isEmpty());
    }


}
