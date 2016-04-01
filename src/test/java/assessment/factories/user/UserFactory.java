package assessment.factories.user;

import assessment.entities.user.User;
import assessment.testbase.TestBase;

import java.text.ParseException;
import java.util.ArrayList;
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
                user.setFirstName(VALID_PERSON_NAME);
                user.setLastName(VALID_PERSON_NAME);
                user.setRole(ROLE_DEVELOPER);
                user.setProfileDescription(VALID_DESCRIPTION);
                break;

            case VALID_INACTIVE_DEVELOPER:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(false);
                user.setAvatar(VALID_GRAVATAR_HASH);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(VALID_PERSON_NAME);
                user.setLastName(VALID_PERSON_NAME);
                user.setRole(ROLE_DEVELOPER);
                user.setProfileDescription(VALID_DESCRIPTION);
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