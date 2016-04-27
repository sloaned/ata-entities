package assessment.validation;

import assessment.entities.kudo.Kudo;
import assessment.factories.kudo.KudoFactory;
import assessment.factories.kudo.KudoOption;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.Validator;
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
        Set<ConstraintViolation<Kudo>> violations = validator.validate(testKudo);
        assertFalse("VALID REVIEW: the review factory assembled a review that passes entity validation", violations.isEmpty());
    }



}
