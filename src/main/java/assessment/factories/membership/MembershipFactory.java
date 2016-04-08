package assessment.factories.membership;

import assessment.entities.membership.Membership;
import assessment.testbase.TestBase;
import java.text.ParseException;

/**
 * Created by hmccardell on 4/1/2016.
 */
public class MembershipFactory extends TestBase {

    public Membership assembleMembership(MembershipOption option) throws ParseException {

        Membership membership = new Membership();

        switch (option) {
            case VALID_ACTIVE_MEMBERSHIP:
                membership.setUserId(generateRandomHash(15));
                membership.setActive(true);
                membership.setAddedOn(getDate(VALID_DATE));
                membership.setRemovedOn(null);
                break;

            case INVALID_MEMBERSHIP_EMPTY_USER_ID:
                membership.setUserId(EMPTY_STRING);
                membership.setActive(true);
                membership.setAddedOn(getDate(VALID_DATE));
                membership.setRemovedOn(null);
                break;

            case INVALID_MEMBERSHIP_NULL_ISACTIVE:
                membership.setUserId(generateRandomHash(15));
                membership.setActive(null);
                membership.setAddedOn(getDate(VALID_DATE));
                membership.setRemovedOn(null);
                break;

            case INVALID_MEMBERSHIP_NULL_ADDED_DATE:
                membership.setUserId(generateRandomHash(15));
                membership.setActive(true);
                membership.setAddedOn(getDate(null));
                membership.setRemovedOn(null);
                break;

            case INVALID_MEMBERSHIP_VERSION_ZERO:
                membership.setUserId(generateRandomHash(15));
                membership.setActive(true);
                membership.setAddedOn(getDate(VALID_DATE));
                membership.setRemovedOn(null);
                membership.setVersion(0);
                break;
        }

        return membership;
    }

}
