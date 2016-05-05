package assessment.factories.team;

import assessment.entities.team.Member;
import assessment.testbase.TestBase;
import java.text.ParseException;

/**
 * Created by hmccardell on 4/1/2016.
 */
public class MemberFactory extends TestBase {

    private Member assembleBaseMember() {

		Member baseMember = new Member();

		baseMember.setUserId(generateRandomString(15));
		baseMember.setActive(true);
		baseMember.setAddedOn(getDate(PAST_DATE));
		baseMember.setRemovedOn(null);
		baseMember.setRole(ROLE_DEVELOPER);

		return baseMember;

    }

    public Member assembleMember(MemberOption option) throws ParseException {

        Member member = assembleBaseMember();

        switch (option) {
            case VALID_ACTIVE_MEMBER:
                break;

            case INVALID_MEMBER_ID_EMPTY:
                member.setUserId(EMPTY_STRING);
                break;

            case INVALID_MEMBER_ISACTIVE_NULL:
                member.setActive(null);
                break;

            case INVALID_MEMBER_ADDED_ON_DATE_NULL:
                member.setAddedOn(getDate(null));
                break;

            case INVALID_MEMBER_ROLE_NULL:
                member.setRole(null);
                break;
        }

        return member;
    }

}
