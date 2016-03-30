package assessment.factories.User;

import assessment.entities.User.Role;
import assessment.entities.User.User;
import assessment.testbase.TestBaseConstants;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hmccardell on 3/29/2016.
 */
public class UserFactory extends TestBaseConstants {

    public User assembleUser(UserOptions userOption) {

        User user = new User();
        Role role = Role.valueOf("DEVELOPER");

        switch(userOption){

            case VALID_ACTIVE_DEVELOPER:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(true);
                user.setAvatar(VALID_USER_GRAVATAR_LINK);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(VALID_USER_FIRST_NAME);
                user.setLastName(VALID_USER_LAST_NAME);
                user.setRole(role);
                user.setId(VALID_USER_ID);
                user.setProfileDescription(VALID_USER_DESCRIPTION);
                break;

            case VALID_INACTIVE_DEVELOPER:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(false);
                user.setAvatar(VALID_USER_GRAVATAR_LINK);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(VALID_USER_FIRST_NAME);
                user.setLastName(VALID_USER_LAST_NAME);
                user.setRole(role);
                user.setId(VALID_USER_ID);
                user.setProfileDescription(VALID_USER_DESCRIPTION);
                break;

        }

        return user;
    }

    public List<User> assembleUsersAsList(UserOptions option, int count) throws ParseException {

        List<User> result = new ArrayList<User>();

        for (int i = 0; i < count; i++) {
            result.add(assembleUser(option));
        }

        return result;
    }


}
