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
    public void SadPathValidationOfMembershipFactoryEmptyUserId() throws ParseException{
        Membership invalidMembership = membershipFactory.assembleMembership(MembershipOption.INVALID_MEMBERSHIP_ID_EMPTY);
        Set<ConstraintViolation<Membership>> violations = validator.validate(invalidMembership);
        assertFalse("expected empty user ID", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfMembershipFactoryNullIsActive() throws ParseException{
        Membership invalidMembership = membershipFactory.assembleMembership(MembershipOption.INVALID_MEMBERSHIP_ISACTIVE_NULL);
        Set<ConstraintViolation<Membership>> violations = validator.validate(invalidMembership);
        assertFalse("expected null isActive", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfMembershipFactoryNullAddedOn() throws ParseException{
        Membership invalidMembership = membershipFactory.assembleMembership(MembershipOption.INVALID_MEMBERSHIP_ADDED_DATE_NULL);
        Set<ConstraintViolation<Membership>> violations = validator.validate(invalidMembership);
        assertFalse("expected null addedOn date", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfMembershipFactoryVersionZero() throws ParseException{
        Membership invalidMembership = membershipFactory.assembleMembership(MembershipOption.INVALID_MEMBERSHIP_VERSION_ZERO);
        Set<ConstraintViolation<Membership>> violations = validator.validate(invalidMembership);
        assertFalse("expected version 0", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfMembershipFactoryNullVersion() throws ParseException{
        Membership invalidMembership = membershipFactory.assembleMembership(MembershipOption.INVALID_MEMBERSHIP_VERSION_NULL);
        Set<ConstraintViolation<Membership>> violations = validator.validate(invalidMembership);
        assertFalse("expected version null", violations.isEmpty());
    }


}
