package assessment.testbase.Membership;

import assessment.entities.Membership.Membership;
import assessment.testbase.TestBase;

import java.text.ParseException;

/**
 * Created by hmccardell on 3/29/2016.
 */
public class MemberObjectFactory extends TestBase {

    public Membership membership(MembershipOptions membershipOption) throws ParseException{

        Membership membership = new Membership();

        switch(membershipOption){
            case VALID_ACTIVE_MEMBERSHIP_OBJECT:
                membership.setActive(true);
                membership.setAddedOn(getDate(VALID_DATE));
                membership.setVersion(VALID_ENTITY_VERSION);

                break;

            case VALID_INACTIVE_MEMBERSHIP_OBJECT:
                membership.setActive(false);
                membership.setAddedOn(getDate(VALID_DATE));
                membership.setVersion(VALID_ENTITY_VERSION);
        }

        return membership;

    }

}
