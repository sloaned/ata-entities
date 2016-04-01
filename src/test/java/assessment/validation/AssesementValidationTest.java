package assessment.validation;

import assessment.assessment.AssessmentFactory;
import assessment.assessment.AssessmentOption;
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
public class AssesementValidationTest {

    private static Validator validator;
    private Assessment testAssessment;
    AssessmentFactory assessmentFactory = new AssessmentFactory();

    @BeforeClass
    public static void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void HappyPathValidationOfAssesementFactoryValidAssesement() {
        testAssessment = assessmentFactory.assembleAssessment(AssessmentOption.VALID_ASSESSMENT);
        Set<ConstraintViolation<Assessment>> violations = validator.validate(testAssessment);
        assertTrue("INVALID ASSESSMENT: the assessment factory assembled an assessment that doesn't " +
                "pass entity validation", violations.isEmpty());
    }

    @Test
    public void HappyPathValidationOfAssesementFactoryBadAssesementLongName() {
        testAssessment = assessmentFactory.assembleAssessment(AssessmentOption.BAD_ASSESSMENT_LONG_NAME);
        Set<ConstraintViolation<Assessment>> violations = validator.validate(testAssessment);
        assertFalse("INVALID ASSESSMENT: the assessment factory assembled an assessment that doesn't " +
                "pass entity validation", violations.isEmpty());
    }

    @Test
    public void HappyPathValidationOfAssesementFactoryBadAssesementBadName() {
        testAssessment = assessmentFactory.assembleAssessment(AssessmentOption.BAD_ASSESSMENT_BAD_NAME);
        Set<ConstraintViolation<Assessment>> violations = validator.validate(testAssessment);
        assertFalse("INVALID ASSESSMENT: the assessment factory assembled an assessment that doesn't " +
                "pass entity validation", violations.isEmpty());
    }

    @Test
    public void HappyPathValidationOfAssesementFactoryBadAssesementNullName() {
        testAssessment = assessmentFactory.assembleAssessment(AssessmentOption.BAD_ASSESSMENT_NULL_NAME);
        Set<ConstraintViolation<Assessment>> violations = validator.validate(testAssessment);
        assertFalse("INVALID ASSESSMENT: the assessment factory assembled an assessment that doesn't " +
                "pass entity validation", violations.isEmpty());
    }

    @Test
    public void HappyPathValidationOfAssesementFactoryBadAssesementNullVersion() {
        testAssessment = assessmentFactory.assembleAssessment(AssessmentOption.BAD_ASSESSMENT_NULL_VERSION);
        Set<ConstraintViolation<Assessment>> violations = validator.validate(testAssessment);
        assertFalse("INVALID ASSESSMENT: the assessment factory assembled an assessment that doesn't " +
                "pass entity validation", violations.isEmpty());
    }
}
