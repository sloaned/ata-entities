package assessment.testbase.User;

import assessment.entities.User.Role;
import assessment.entities.User.User;
import assessment.testbase.TestBaseConstants;

/**
 * Created by hmccardell on 3/29/2016.
 */
public class UserFactory extends TestBaseConstants {


    User user(UserOptions userOption) {

        User user = new User();

        switch(userOption){

            case VALID_ACTIVE_DEVELOPER_USER:
                user.setVersion(VALID_ENTITY_VERSION);
                user.setActive(true);
                user.setAvatar(VALID_USER_GRAVATAR_LINK);
                user.setEmail(VALID_USER_EMAIL);
                user.setFirstName(VALID_USER_FIRST_NAME);
                user.setLastName(VALID_USER_LAST_NAME);
                user.setRole(ROLE_DEVELOPER);
                user.setId(VALID_USER_ID);


        }






        return user;
    }




}
