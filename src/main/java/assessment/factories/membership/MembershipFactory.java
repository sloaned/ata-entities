package assessment.factories.membership;

import assessment.entities.team.Member;
import assessment.testbase.TestBase;
import java.text.ParseException;

/**
 * Created by hmccardell on 4/1/2016.
 */
public class MembershipFactory extends TestBase {

    public Member assembleMembership(MembershipOption option) throws ParseException {

        Member member = new Member();

        switch (option) {
            case VALID_ACTIVE_MEMBERSHIP:
                member.setUserId(generateRandomHash(15));
                member.setActive(true);
                member.setAddedOn(getDate(VALID_DATE));
                member.setRemovedOn(null);
                //member.setVersion(MEMBERSHIP_CURRENT_VERSION);
                break;

            case INVALID_MEMBERSHIP_ID_EMPTY:
                member.setUserId(EMPTY_STRING);
                member.setActive(true);
                member.setAddedOn(getDate(VALID_DATE));
                member.setRemovedOn(null);
                //member.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_MEMBERSHIP_ISACTIVE_NULL:
                member.setUserId(generateRandomHash(15));
                member.setActive(null);
                member.setAddedOn(getDate(VALID_DATE));
                member.setRemovedOn(null);
                //member.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_MEMBERSHIP_ADDED_DATE_NULL:
                member.setUserId(generateRandomHash(15));
                member.setActive(true);
                member.setAddedOn(getDate(null));
                member.setRemovedOn(null);
                //member.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_MEMBERSHIP_VERSION_ZERO:
                member.setUserId(generateRandomHash(15));
                member.setActive(true);
                member.setAddedOn(getDate(VALID_DATE));
                member.setRemovedOn(null);
                //member.setVersion(0);
                break;

            case INVALID_MEMBERSHIP_VERSION_NULL:
                member.setUserId(generateRandomHash(15));
                member.setActive(true);
                member.setAddedOn(getDate(VALID_DATE));
                member.setRemovedOn(null);
                //member.setVersion(null);
                break;
        }

        return member;
    }

}
