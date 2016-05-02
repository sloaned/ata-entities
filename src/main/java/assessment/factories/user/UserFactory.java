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

    public User assembleUser(UserOption userOption) {

        User user = new User();

        switch(userOption){

            case VALID_ACTIVE_DEVELOPER:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(true);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(VALID_USER_NAME);
                user.setLastName(VALID_USER_NAME);
                user.setProfileDescription(VALID_DESCRIPTION);
                user.setStartDate(new Date());
                user.setTitle(VALID_TITLE);
                user.setVersion(USER_CURRENT_VERSION);
                break;

            case VALID_INACTIVE_DEVELOPER:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(false);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(VALID_USER_NAME);
                user.setLastName(VALID_USER_NAME);
                user.setProfileDescription(VALID_DESCRIPTION);
                user.setStartDate(new Date());
                user.setTitle(VALID_TITLE);
                user.setVersion(USER_CURRENT_VERSION);
                break;

            case INVALID_USER_FIRST_NAME_EMPTY:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(true);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(EMPTY_STRING);
                user.setLastName(VALID_USER_NAME);
                user.setProfileDescription(VALID_DESCRIPTION);
                user.setStartDate(new Date());
                user.setTitle(VALID_TITLE);
                user.setVersion(USER_CURRENT_VERSION);
                break;

            case INVALID_USER_FIRST_NAME_NULL:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(true);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(null);
                user.setLastName(VALID_USER_NAME);
                user.setProfileDescription(VALID_DESCRIPTION);
                user.setStartDate(new Date());
                user.setTitle(VALID_TITLE);
                user.setVersion(USER_CURRENT_VERSION);
                break;

            case INVALID_USER_FIRST_NAME_SPECIAL_CHARACTERS:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(true);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(INVALID_USER_NAME_SPECIAL_CHARACTERS);
                user.setLastName(VALID_USER_NAME);
                user.setProfileDescription(VALID_DESCRIPTION);
                user.setStartDate(new Date());
                user.setTitle(VALID_TITLE);
                user.setVersion(USER_CURRENT_VERSION);
                break;

            case INVALID_USER_FIRST_NAME_LONG:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(true);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(generateRandomString(51));
                user.setLastName(VALID_USER_NAME);
                user.setProfileDescription(VALID_DESCRIPTION);
                user.setStartDate(new Date());
                user.setTitle(VALID_TITLE);
                user.setVersion(USER_CURRENT_VERSION);
                break;

            case INVALID_USER_LAST_NAME_EMPTY:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(true);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(VALID_USER_NAME);
                user.setLastName(EMPTY_STRING);
                user.setProfileDescription(VALID_DESCRIPTION);
                user.setStartDate(new Date());
                user.setTitle(VALID_TITLE);
                user.setVersion(USER_CURRENT_VERSION);
                break;

            case INVALID_USER_LAST_NAME_NULL:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(true);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(VALID_USER_NAME);
                user.setLastName(null);
                user.setProfileDescription(VALID_DESCRIPTION);
                user.setStartDate(new Date());
                user.setTitle(VALID_TITLE);
                user.setVersion(USER_CURRENT_VERSION);
                break;

            case INVALID_USER_LAST_NAME_SPECIAL_CHARACTERS:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(true);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(VALID_USER_NAME);
                user.setLastName(INVALID_USER_NAME_SPECIAL_CHARACTERS);
                user.setStartDate(new Date());
                user.setProfileDescription(VALID_DESCRIPTION);
                user.setTitle(VALID_TITLE);
                user.setVersion(USER_CURRENT_VERSION);
                break;

            case INVALID_USER_LAST_NAME_LONG:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(true);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(VALID_USER_NAME);
                user.setLastName(generateRandomString(51));
                user.setProfileDescription(VALID_DESCRIPTION);
                user.setStartDate(new Date());
                user.setTitle(VALID_TITLE);
                user.setVersion(USER_CURRENT_VERSION);
                break;

            case INVALID_USER_ROLE_NULL:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(true);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(VALID_USER_NAME);
                user.setLastName(VALID_USER_NAME);
                user.setProfileDescription(VALID_DESCRIPTION);
                user.setStartDate(new Date());
                user.setTitle(VALID_TITLE);
                user.setVersion(USER_CURRENT_VERSION);
                break;

            case INVALID_USER_EMAIL_EMPTY:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(true);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(EMPTY_STRING);
                user.setLastName(VALID_USER_NAME);
                user.setProfileDescription(VALID_DESCRIPTION);
                user.setStartDate(new Date());
                user.setTitle(VALID_TITLE);
                user.setVersion(USER_CURRENT_VERSION);
                break;

            case INVALID_USER_EMAIL_NULL:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(true);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(null);
                user.setFirstName(VALID_USER_NAME);
                user.setLastName(VALID_USER_NAME);
                user.setProfileDescription(VALID_DESCRIPTION);
                user.setStartDate(new Date());
                user.setTitle(VALID_TITLE);
                user.setVersion(USER_CURRENT_VERSION);
                break;

            case INVALID_USER_EMAIL_INVALID_ADDRESS:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(true);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(INVALID_USER_EMAIL);
                user.setFirstName(VALID_USER_NAME);
                user.setLastName(VALID_USER_NAME);
                user.setProfileDescription(VALID_DESCRIPTION);
                user.setStartDate(new Date());
                user.setVersion(USER_CURRENT_VERSION);
                break;

            case INVALID_USER_VERSION_ZERO:
                user.setVersion(0);
                user.setActive(true);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(VALID_USER_NAME);
                user.setLastName(VALID_USER_NAME);
                user.setProfileDescription(VALID_DESCRIPTION);
                user.setStartDate(new Date());
                user.setTitle(VALID_TITLE);
                user.setVersion(0);
                break;

            case INVALID_USER_VERSION_NULL:
                user.setVersion(null);
                user.setActive(true);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(VALID_USER_NAME);
                user.setLastName(VALID_USER_NAME);
                user.setProfileDescription(VALID_DESCRIPTION);
                user.setStartDate(new Date());
                user.setTitle(VALID_TITLE);
                user.setVersion(null);
                break;

            case INVALID_USER_DESCRIPTION_LONG:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(true);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(VALID_USER_NAME);
                user.setLastName(VALID_USER_NAME);
                user.setProfileDescription(generateRandomString(256));
                user.setStartDate(new Date());
                user.setTitle(VALID_TITLE);
                user.setVersion(USER_CURRENT_VERSION);
                break;

            case INVALID_USER_ISACTIVE_NULL:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(null);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(VALID_USER_NAME);
                user.setLastName(VALID_USER_NAME);
                user.setProfileDescription(generateRandomString(256));
                user.setStartDate(new Date());
                user.setTitle(VALID_TITLE);
                user.setVersion(USER_CURRENT_VERSION);
                break;

            case INVALID_USER_TITLE_NULL:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(null);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(VALID_USER_NAME);
                user.setLastName(VALID_USER_NAME);
                user.setProfileDescription(generateRandomString(256));
                user.setStartDate(new Date());
                user.setTitle(null);
                user.setVersion(USER_CURRENT_VERSION);
                break;

            case INVALID_USER_TITLE_EMPTY:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(null);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(VALID_USER_NAME);
                user.setLastName(VALID_USER_NAME);
                user.setProfileDescription(generateRandomString(256));
                user.setStartDate(new Date());
                user.setTitle(EMPTY_STRING);
                user.setVersion(USER_CURRENT_VERSION);
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
