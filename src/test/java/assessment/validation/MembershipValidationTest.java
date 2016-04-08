package assessment.validation;

import assessment.entities.membership.Membership;
import assessment.factories.membership.MembershipFactory;
import assessment.factories.membership.MembershipOption;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.text.ParseException;
import java.util.Set;

/**
 * Created by hmccardell on 4/8/2016.
 */
public class MembershipValidationTest {

    private static Validator validator;
    private MembershipFactory membershipFactory = new MembershipFactory();

    @BeforeClass
    public static void setup(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();

    }

    @Test
    public void membershipHappyPath() throws ParseException{
        Membership goodMembership = membershipFactory.assembleMembership(MembershipOption.VALID_ACTIVE_MEMBERSHIP);
        Set<ConstraintViolation<Membership>> violations = validator.validate(goodMembership);
        assertTrue("failed to create a valid Membership object", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfMembershpFactoryEmptyUserId() throws ParseException{
        Membership invalidMembership = membershipFactory.assembleMembership(MembershipOption.INVALID_MEMBERSHIP_EMPTY_USER_ID);
        Set<ConstraintViolation<Membership>> violations = validator.validate(invalidMembership);
        assertFalse("expected empty user ID", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfMembershpFactoryNullIsActive() throws ParseException{
        Membership invalidMembership = membershipFactory.assembleMembership(MembershipOption.INVALID_MEMBERSHIP_NULL_ISACTIVE);
        Set<ConstraintViolation<Membership>> violations = validator.validate(invalidMembership);
        assertFalse("expected null isActive", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfMembershpFactoryNullAddedOn() throws ParseException{
        Membership invalidMembership = membershipFactory.assembleMembership(MembershipOption.INVALID_MEMBERSHIP_NULL_ADDED_DATE);
        Set<ConstraintViolation<Membership>> violations = validator.validate(invalidMembership);
        assertFalse("expected null addedOn date", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfMembershpFactoryVersionZero() throws ParseException{
        Membership invalidMembership = membershipFactory.assembleMembership(MembershipOption.INVALID_MEMBERSHIP_VERSION_ZERO);
        Set<ConstraintViolation<Membership>> violations = validator.validate(invalidMembership);
        assertFalse("expected version 0", violations.isEmpty());
    }

}
