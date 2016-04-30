package assessment.factories.team;

import assessment.entities.team.Member;
import assessment.testbase.TestBase;
import java.text.ParseException;

/**
 * Created by hmccardell on 4/1/2016.
 */
public class MemberFactory extends TestBase {

    public Member assembleMember(MemberOption option) throws ParseException {

        Member member = new Member();

        switch (option) {
            case VALID_ACTIVE_MEMBER:
                member.setUserId(generateRandomString(15));
                member.setActive(true);
                member.setAddedOn(getDate(VALID_DATE));
                member.setRemovedOn(null);
                member.setRole(ROLE_DEVELOPER);
                break;

            case INVALID_MEMBER_ID_EMPTY:
                member.setUserId(EMPTY_STRING);
                member.setActive(true);
                member.setAddedOn(getDate(VALID_DATE));
                member.setRemovedOn(null);
                member.setRole(ROLE_DEVELOPER);
                break;

            case INVALID_MEMBER_ISACTIVE_NULL:
                member.setUserId(generateRandomString(15));
                member.setActive(null);
                member.setAddedOn(getDate(VALID_DATE));
                member.setRemovedOn(null);
                member.setRole(ROLE_DEVELOPER);
                break;

            case INVALID_MEMBER_ADDED_ON_DATE_NULL:
                member.setUserId(generateRandomString(15));
                member.setActive(true);
                member.setAddedOn(getDate(null));
                member.setRemovedOn(null);
                member.setRole(ROLE_DEVELOPER);
                break;

            case INVALID_MEMBER_ROLE_NULL:
                member.setUserId(generateRandomString(15));
                member.setActive(true);
                member.setAddedOn(getDate(VALID_DATE));
                member.setRemovedOn(null);
                member.setRole(null);
                break;
        }

        return member;
    }

}
