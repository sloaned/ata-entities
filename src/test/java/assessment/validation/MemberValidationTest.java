package assessment.validation;

import assessment.entities.team.Member;
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
public class MemberValidationTest {

    private static Validator validator;
    private MembershipFactory membershipFactory = new MembershipFactory();

    @BeforeClass
    public static void setup(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();

    }

    @Test
    public void membershipHappyPath() throws ParseException{
        Member goodMember = membershipFactory.assembleMembership(MembershipOption.VALID_ACTIVE_MEMBERSHIP);
        Set<ConstraintViolation<Member>> violations = validator.validate(goodMember);
        assertTrue("failed to create a valid Member object", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfMembershipFactoryEmptyUserId() throws ParseException{
        Member invalidMember = membershipFactory.assembleMembership(MembershipOption.INVALID_MEMBERSHIP_ID_EMPTY);
        Set<ConstraintViolation<Member>> violations = validator.validate(invalidMember);
        assertFalse("expected empty user ID", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfMembershipFactoryNullIsActive() throws ParseException{
        Member invalidMember = membershipFactory.assembleMembership(MembershipOption.INVALID_MEMBERSHIP_ISACTIVE_NULL);
        Set<ConstraintViolation<Member>> violations = validator.validate(invalidMember);
        assertFalse("expected null isActive", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfMembershipFactoryNullAddedOn() throws ParseException{
        Member invalidMember = membershipFactory.assembleMembership(MembershipOption.INVALID_MEMBERSHIP_ADDED_DATE_NULL);
        Set<ConstraintViolation<Member>> violations = validator.validate(invalidMember);
        assertFalse("expected null addedOn date", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfMembershipFactoryVersionZero() throws ParseException{
        Member invalidMember = membershipFactory.assembleMembership(MembershipOption.INVALID_MEMBERSHIP_VERSION_ZERO);
        Set<ConstraintViolation<Member>> violations = validator.validate(invalidMember);
        assertFalse("expected version 0", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfMembershipFactoryNullVersion() throws ParseException{
        Member invalidMember = membershipFactory.assembleMembership(MembershipOption.INVALID_MEMBERSHIP_VERSION_NULL);
        Set<ConstraintViolation<Member>> violations = validator.validate(invalidMember);
        assertFalse("expected version null", violations.isEmpty());
    }


}
