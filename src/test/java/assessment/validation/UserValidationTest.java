package assessment.validation;

import assessment.entities.User.User;
import assessment.factories.User.UserFactory;
import assessment.factories.User.UserOption;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Created by hmccardell on 3/30/2016.
 */
public class UserValidationTest {

    private static Validator validator;
    private User testUser;
    UserFactory userFactory = new UserFactory();

    @BeforeClass
    public static void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void HappyPathValidationOfUserFactory() {
        testUser = userFactory.assembleUser(UserOption.VALID_ACTIVE_DEVELOPER);
        Set<ConstraintViolation<User>> violations = validator.validate(testUser);
        assertTrue("the user factory has created a user that doesn't match entity constraints", violations.isEmpty());
    }
}
