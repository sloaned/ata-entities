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
                membership.setVersion(MEMBERSHIP_CURRENT_VERSION);
                break;

            case INVALID_MEMBERSHIP_ID_EMPTY:
                membership.setUserId(EMPTY_STRING);
                membership.setActive(true);
                membership.setAddedOn(getDate(VALID_DATE));
                membership.setRemovedOn(null);
                membership.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_MEMBERSHIP_ISACTIVE_NULL:
                membership.setUserId(generateRandomHash(15));
                membership.setActive(null);
                membership.setAddedOn(getDate(VALID_DATE));
                membership.setRemovedOn(null);
                membership.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_MEMBERSHIP_ADDED_DATE_NULL:
                membership.setUserId(generateRandomHash(15));
                membership.setActive(true);
                membership.setAddedOn(getDate(null));
                membership.setRemovedOn(null);
                membership.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_MEMBERSHIP_VERSION_ZERO:
                membership.setUserId(generateRandomHash(15));
                membership.setActive(true);
                membership.setAddedOn(getDate(VALID_DATE));
                membership.setRemovedOn(null);
                membership.setVersion(0);
                break;

            case INVALID_MEMBERSHIP_VERSION_NULL:
                membership.setUserId(generateRandomHash(15));
                membership.setActive(true);
                membership.setAddedOn(getDate(VALID_DATE));
                membership.setRemovedOn(null);
                membership.setVersion(null);
                break;
        }

        return membership;
    }

}
