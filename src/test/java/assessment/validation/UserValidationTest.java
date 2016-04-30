/*
package assessment.validation;

import assessment.entities.user.User;
import assessment.factories.user.UserFactory;
import assessment.factories.user.UserOption;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.text.ParseException;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

*/
/**
 * Created by hmccardell on 3/30/2016.
 *//*

public class UserValidationTest {

    private static Validator validator;
    private User testUser;
    UserFactory userFactory = new UserFactory();

    @BeforeClass
    public static void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void HappyPathValidationOfUserFactoryValidActiveDeveloper() {
        testUser = userFactory.assembleUser(UserOption.VALID_ACTIVE_DEVELOPER);
        Set<ConstraintViolation<User>> violations = validator.validate(testUser);
        assertTrue("INVALID USER: the user factory assembled a user that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void HappyPathValidationOfUserFactoryValidInactiveDeveloper() {
        testUser = userFactory.assembleUser(UserOption.VALID_INACTIVE_DEVELOPER);
        Set<ConstraintViolation<User>> violations = validator.validate(testUser);
        assertTrue("INVALID USER: the user factory assembled a user that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOUserFactoryFirstNameEmpty() {
        testUser = userFactory.assembleUser(UserOption.INVALID_USER_FIRST_NAME_EMPTY);
        Set<ConstraintViolation<User>> violations = validator.validate(testUser);
        assertFalse("expected empty first name", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOUserFactoryFirstNameNull() {
        testUser = userFactory.assembleUser(UserOption.INVALID_USER_FIRST_NAME_NULL);
        Set<ConstraintViolation<User>> violations = validator.validate(testUser);
        assertFalse("expected null first name", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOUserFactoryFirstNameSpecialCharacters() {
        testUser = userFactory.assembleUser(UserOption.INVALID_USER_FIRST_NAME_SPECIAL_CHARACTERS);
        Set<ConstraintViolation<User>> violations = validator.validate(testUser);
        assertFalse("expected special characters in first name", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOUserFactoryFirstNameLong() {
        testUser = userFactory.assembleUser(UserOption.INVALID_USER_FIRST_NAME_LONG);
        Set<ConstraintViolation<User>> violations = validator.validate(testUser);
        assertFalse("expected first name to be too long", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOUserFactoryLastNameEmpty() {
        testUser = userFactory.assembleUser(UserOption.INVALID_USER_LAST_NAME_EMPTY);
        Set<ConstraintViolation<User>> violations = validator.validate(testUser);
        assertFalse("expected empty last name", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOUserFactoryLastNameNull() {
        testUser = userFactory.assembleUser(UserOption.INVALID_USER_LAST_NAME_NULL);
        Set<ConstraintViolation<User>> violations = validator.validate(testUser);
        assertFalse("expected null last name", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOUserFactoryLastNameSpecialCharacters() {
        testUser = userFactory.assembleUser(UserOption.INVALID_USER_LAST_NAME_SPECIAL_CHARACTERS);
        Set<ConstraintViolation<User>> violations = validator.validate(testUser);
        assertFalse("expected special characters in last name", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOUserFactoryLastNameLong() {
        testUser = userFactory.assembleUser(UserOption.INVALID_USER_LAST_NAME_LONG);
        Set<ConstraintViolation<User>> violations = validator.validate(testUser);
        assertFalse("expected last name to be too long", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOUserFactoryRoleNull() {
        testUser = userFactory.assembleUser(UserOption.INVALID_USER_ROLE_NULL);
        Set<ConstraintViolation<User>> violations = validator.validate(testUser);
        assertFalse("expected role to be null", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOUserFactoryEmailEmpty() {
        testUser = userFactory.assembleUser(UserOption.INVALID_USER_EMAIL_EMPTY);
        Set<ConstraintViolation<User>> violations = validator.validate(testUser);
        assertFalse("expected email to be empty", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOUserFactoryEmailNull() {
        testUser = userFactory.assembleUser(UserOption.INVALID_USER_EMAIL_NULL);
        Set<ConstraintViolation<User>> violations = validator.validate(testUser);
        assertFalse("expected email to be null", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOUserFactoryEmailNotValidAddress() {
        testUser = userFactory.assembleUser(UserOption.INVALID_USER_EMAIL_INVALID_ADDRESS);
        Set<ConstraintViolation<User>> violations = validator.validate(testUser);
        assertFalse("expected email to be invalid against the regex", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfUserFactoryVersionZero() throws ParseException {
        testUser = userFactory.assembleUser(UserOption.INVALID_USER_VERSION_ZERO);
        Set<ConstraintViolation<User>> violations = validator.validate(testUser);
        assertFalse("expected version 0", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfUserFactoryVersionNull() throws ParseException{
        testUser = userFactory.assembleUser(UserOption.INVALID_USER_VERSION_NULL);
        Set<ConstraintViolation<User>> violations = validator.validate(testUser);
        assertFalse("expected version null", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfUserFactoryTitleIsNull() throws ParseException{
        testUser = userFactory.assembleUser(UserOption.INVALID_USER_TITLE_NULL);
        Set<ConstraintViolation<User>> violations = validator.validate(testUser);
        assertFalse("expected title null", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfUserFactoryTitleIsEmpty() throws ParseException{
        testUser = userFactory.assembleUser(UserOption.INVALID_USER_TITLE_EMPTY);
        Set<ConstraintViolation<User>> violations = validator.validate(testUser);
        assertFalse("expected title to be empty", violations.isEmpty());
    }
}
*/
