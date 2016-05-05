package assessment.factories.user;

import assessment.entities.user.User;
import assessment.testbase.TestBase;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hmccardell on 3/29/2016.
 */

public class UserFactory extends TestBase {

    private User assembleBaseUser() {

		User baseUser = new User();

		baseUser.setVersion(USER_CURRENT_VERSION);
		baseUser.setIsActive(true);
		baseUser.setAvatar(VALID_GRAVATAR_HASH);
		baseUser.setEmail(VALID_USER_EMAIL);
		baseUser.setFirstName(VALID_USER_NAME);
		baseUser.setLastName(VALID_USER_NAME);
		baseUser.setProfileDescription(VALID_DESCRIPTION);
		baseUser.setStartDate(new Date());
		baseUser.setTitle(VALID_TITLE);

		return baseUser;

    }

    public User assembleUser(UserOption userOption) {

        User user = assembleBaseUser();

        switch(userOption){

            case VALID_ACTIVE_DEVELOPER:
                break;

            case VALID_INACTIVE_DEVELOPER:
                user.setIsActive(false);
                break;

            case INVALID_USER_FIRST_NAME_EMPTY:
                user.setFirstName(EMPTY_STRING);
                break;

            case INVALID_USER_FIRST_NAME_NULL:
                user.setFirstName(null);
                break;

            case INVALID_USER_FIRST_NAME_SPECIAL_CHARACTERS:
                user.setFirstName(INVALID_USER_NAME_SPECIAL_CHARACTERS);
                break;

            case INVALID_USER_FIRST_NAME_LONG:
                user.setFirstName(generateRandomString(51));
                break;

            case INVALID_USER_LAST_NAME_EMPTY:
                user.setLastName(EMPTY_STRING);
                break;

            case INVALID_USER_LAST_NAME_NULL:
                user.setLastName(null);
                break;

            case INVALID_USER_LAST_NAME_SPECIAL_CHARACTERS:
                user.setLastName(INVALID_USER_NAME_SPECIAL_CHARACTERS);
                break;

            case INVALID_USER_LAST_NAME_LONG:
                user.setLastName(generateRandomString(51));
                break;

            case INVALID_USER_EMAIL_EMPTY:
                user.setEmail(EMPTY_STRING);
                break;

            case INVALID_USER_EMAIL_NULL:
                user.setEmail(null);
                break;

            case INVALID_USER_EMAIL_INVALID_ADDRESS:
                user.setEmail(INVALID_USER_EMAIL);
                break;

            case INVALID_USER_VERSION_ZERO:
                user.setVersion(0);
                break;

            case INVALID_USER_VERSION_NULL:
                user.setVersion(null);
                break;

            case INVALID_USER_DESCRIPTION_LONG:
                user.setProfileDescription(generateRandomString(256));
                break;

            case INVALID_USER_ISACTIVE_NULL:
                user.setIsActive(null);
                break;

            case INVALID_USER_TITLE_NULL:
                user.setTitle(null);
                break;

            case INVALID_USER_TITLE_EMPTY:
                user.setTitle(EMPTY_STRING);
                break;
        }

        return user;
    }

    public List<User> assembleUsersAsList(UserOption option, int count) throws ParseException {

        List<User> result = new ArrayList<User>();

        for (int i = 0; i < count; i++) {
            result.add(assembleUser(option));
        }

        return result;
    }

}
