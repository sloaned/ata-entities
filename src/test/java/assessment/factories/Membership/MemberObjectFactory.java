package assessment.factories.Membership;

import assessment.entities.Membership.Membership;
import assessment.testbase.TestBase;
import assessment.factories.User.UserFactory;
import assessment.factories.User.UserOptions;

import java.text.ParseException;

/**
 * Created by hmccardell on 3/29/2016.
 */
public class MemberObjectFactory extends TestBase {

    public Membership assembleMemberShipObject(MembershipOptions membershipOption) throws ParseException{

        Membership membership = new Membership();
        UserFactory userFactory = new UserFactory();

        switch(membershipOption){
            case VALID_ACTIVE_MEMBERSHIP_OBJECT:
                membership.setActive(true);
                membership.setAddedOn(getDate(VALID_DATE));
                membership.setVersion(VALID_ENTITY_VERSION);
                membership.setUserId(userFactory.assembleUser(UserOptions.VALID_ACTIVE_DEVELOPER));
                break;

            case VALID_INACTIVE_MEMBERSHIP_OBJECT:
                membership.setActive(false);
                membership.setAddedOn(getDate(VALID_DATE));
                membership.setVersion(VALID_ENTITY_VERSION);
                membership.setUserId(userFactory.assembleUser(UserOptions.VALID_ACTIVE_DEVELOPER));
                break;
        }

        return membership;

    }

}
