package assessment.validation;

import assessment.factories.assessment.AssessmentFactory;
import assessment.factories.assessment.AssessmentOption;
import assessment.entities.assessment.Assessment;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
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
    public void HappyPathValidationOfAssessmentFactoryValidAssessment() {
        testAssessment = assessmentFactory.assembleAssessment(AssessmentOption.VALID_ASSESSMENT);
        Set<ConstraintViolation<Assessment>> violations = validator.validate(testAssessment);
        assertTrue("INVALID ASSESSMENT: the assessment factory assembled an assessment that doesn't " +
                "pass entity validation", violations.isEmpty());
    }

    @Test
    public void HappyPathValidationOfAssessmentFactoryBadAssessmentLongName() {
        testAssessment = assessmentFactory.assembleAssessment(AssessmentOption.BAD_ASSESSMENT_LONG_NAME);
        assertThereIsExactlyOneViolation(validator, testAssessment);
    }

    @Test
    public void HappyPathValidationOfAssessmentFactoryBadAssessmentBadName() {
        testAssessment = assessmentFactory.assembleAssessment(AssessmentOption.BAD_ASSESSMENT_BAD_NAME);
        assertThereIsExactlyOneViolation(validator, testAssessment);
    }

    @Test
    public void HappyPathValidationOfAssessmentFactoryBadAssessmentNullName() {
        testAssessment = assessmentFactory.assembleAssessment(AssessmentOption.BAD_ASSESSMENT_NULL_NAME);
        assertThereIsExactlyOneViolation(validator, testAssessment);
    }

    @Test
    public void HappyPathValidationOfAssessmentFactoryBadAssessmentNullVersion() {
        testAssessment = assessmentFactory.assembleAssessment(AssessmentOption.BAD_ASSESSMENT_NULL_VERSION);
        assertThereIsExactlyOneViolation(validator, testAssessment);
    }
}
