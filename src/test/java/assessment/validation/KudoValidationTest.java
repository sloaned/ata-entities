package assessment.validation;

import assessment.entities.kudo.Kudo;
import assessment.factories.kudo.KudoFactory;
import assessment.factories.kudo.KudoOption;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by hmccardell on 4/27/2016.
 */
public class KudoValidationTest {

    private static Validator validator;
    private Kudo testKudo;
    KudoFactory kudoFactory = new KudoFactory();

    private void assertThereIsExactlyOneViolation(Validator validator, Kudo kudo) {
        Set<ConstraintViolation<Kudo>> violations = validator.validate(kudo);
        assertFalse("VALID KUDO: the kudo factory assembled a kudo that passes entity validation", violations.isEmpty());
        assertFalse("INVALID KUDO: the kudo factory assembled a kudo that failed " + violations.size() + " validations", violations.size() > 1);
    }

    @BeforeClass
    public static void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void HappyPathValidationOfValidKudo() {
        testKudo = kudoFactory.assembleKudo(KudoOption.VALID_KUDO);
        Set<ConstraintViolation<Kudo>> violations = validator.validate(testKudo);
        assertTrue("INVALID KUDO: the kudo factory assembled a kudo that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void SadPathKudoReviewerNull() {
        testKudo = kudoFactory.assembleKudo(KudoOption.INVALID_KUDO_REVIEWER_NULL);
        assertThereIsExactlyOneViolation(validator, testKudo);
    }

    @Test
    public void SadPathKudoReviewedNull() {
        testKudo = kudoFactory.assembleKudo(KudoOption.INVALID_KUDO_REVIEWED_NULL);
        assertThereIsExactlyOneViolation(validator, testKudo);
    }

    @Test
    public void SadPathKudoSelfReview() {
        testKudo = kudoFactory.assembleKudo(KudoOption.INVALID_KUDO_SELF_REVIEW);
        assertThereIsExactlyOneViolation(validator, testKudo);
    }

    @Test
    public void SadPathCommentTooLong() {
        testKudo = kudoFactory.assembleKudo(KudoOption.INVALID_KUDO_COMMENT_LONG);
        assertThereIsExactlyOneViolation(validator, testKudo);
    }

    @Test
    public void sadInvalidKudoWithDateTriggeredAsNullFailsValidation() {
        testKudo = kudoFactory.assembleKudo(KudoOption.INVALID_KUDO_DATE_NULL);
        assertThereIsExactlyOneViolation(validator, testKudo);
    }

    @Test
    public void sadInvalidKudoWithDateTriggeredAsPastFailsValidation() {
        testKudo = kudoFactory.assembleKudo(KudoOption.INVALID_KUDO_DATE_PAST);
        assertThereIsExactlyOneViolation(validator, testKudo);
    }

    @Test
    public void sadInvalidKudoWithVersionAsNullFailsValidation() {
        testKudo = kudoFactory.assembleKudo(KudoOption.INVALID_KUDO_VERSION_NULL);
        assertThereIsExactlyOneViolation(validator, testKudo);
    }

    @Test
    public void sadInvalidKudoWithVersionAs0FailsValidation() {
        testKudo = kudoFactory.assembleKudo(KudoOption.INVALID_KUDO_VERSION_0);
        assertThereIsExactlyOneViolation(validator, testKudo);
    }

}
