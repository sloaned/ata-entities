package assessment.factories.team;

import assessment.entities.team.Team;
import assessment.testbase.TestBase;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alysha Recore on 3/31/2016.
 */
public class TeamFactory extends TestBase {

    public Team assembleTeam (TeamOption teamOption){

        Team team = new Team();

        switch(teamOption){

            case VALID_ACTIVE_TEAM:
                team.setId(generateRandomHash(24));
                team.setName(VALID_TEAM_NAME);
                team.setActive(true);
                team.setMemberList(USER_LIST);
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(VALID_TEAM_DESCRIPTION);
                team.setReviewPeriods(REVIEW_PERIOD_LIST);
                team.setSummaryScore(VALID_SUMMARY_SCORE);
                team.setVersion(TEAM_CURRENT_VERSION);
                break;

            case VALID_INACTIVE_TEAM:
                team.setId(generateRandomHash(24));
                team.setName(VALID_INACTIVE_TEAM_NAME);
                team.setActive(false);
                team.setMemberList(USER_LIST);
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(VALID_TEAM_DESCRIPTION);
                team.setReviewPeriods(REVIEW_PERIOD_LIST);
                team.setSummaryScore(VALID_SUMMARY_SCORE);
                team.setVersion(TEAM_CURRENT_VERSION);
                break;

            case INVALID_TEAM_DUPLICATE:
                break;

            case INVALID_TEAM_NAME_SPECIAL_CHARACTERS:
                team.setId(generateRandomHash(24));
                team.setName(INVALID_OBJECT_NAME_SPECIAL_CHARACTERS);
                team.setActive(true);
                team.setMemberList(USER_LIST);
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(VALID_TEAM_DESCRIPTION);
                team.setReviewPeriods(REVIEW_PERIOD_LIST);
                team.setSummaryScore(VALID_SUMMARY_SCORE);
                team.setVersion(TEAM_CURRENT_VERSION);
                break;

            case INVALID_TEAM_NAME_TOO_LONG:
                team.setId(generateRandomHash(24));
                team.setName(generateRandomString(101));
                team.setActive(true);
                team.setMemberList(USER_LIST);
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(VALID_TEAM_DESCRIPTION);
                team.setReviewPeriods(REVIEW_PERIOD_LIST);
                team.setSummaryScore(VALID_SUMMARY_SCORE);
                team.setVersion(TEAM_CURRENT_VERSION);
                break;

            case INVALID_TEAM_NAME_NULL:
                team.setId(generateRandomHash(24));
                team.setName(null);
                team.setActive(true);
                team.setMemberList(USER_LIST);
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(VALID_TEAM_DESCRIPTION);
                team.setReviewPeriods(REVIEW_PERIOD_LIST);
                team.setSummaryScore(VALID_SUMMARY_SCORE);
                team.setVersion(TEAM_CURRENT_VERSION);
                break;

            case INVALID_TEAM_IS_ACTIVE_NULL:
                team.setId(generateRandomHash(24));
                team.setName(VALID_TEAM_NAME);
                team.setActive(null);
                team.setMemberList(USER_LIST);
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(VALID_TEAM_DESCRIPTION);
                team.setReviewPeriods(REVIEW_PERIOD_LIST);
                team.setSummaryScore(VALID_SUMMARY_SCORE);
                team.setVersion(TEAM_CURRENT_VERSION);
                break;

            case INVALID_TEAM_DESCRIPTION_TOO_LONG:
                team.setId(generateRandomHash(24));
                team.setName(VALID_TEAM_NAME);
                team.setActive(true);
                team.setMemberList(USER_LIST);
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(generateRandomString(256));
                team.setReviewPeriods(REVIEW_PERIOD_LIST);
                team.setSummaryScore(VALID_SUMMARY_SCORE);
                team.setVersion(TEAM_CURRENT_VERSION);
                break;

            case INVALID_TEAM_VERSION_NULL:
                team.setId(generateRandomHash(24));
                team.setName(VALID_TEAM_NAME);
                team.setActive(true);
                team.setMemberList(USER_LIST);
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(VALID_TEAM_DESCRIPTION);
                team.setReviewPeriods(REVIEW_PERIOD_LIST);
                team.setSummaryScore(VALID_SUMMARY_SCORE);
                team.setVersion(null);
                break;

            case INVALID_TEAM_VERSION_ZERO:
                team.setId(generateRandomHash(24));
                team.setName(VALID_TEAM_NAME);
                team.setActive(true);
                team.setMemberList(USER_LIST);
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(VALID_TEAM_DESCRIPTION);
                team.setReviewPeriods(REVIEW_PERIOD_LIST);
                team.setSummaryScore(VALID_SUMMARY_SCORE);
                team.setVersion(0);
                break;
        }
        return team;
    }

    public List<Team> assembleTeamsAsList(TeamOption option, int count) throws ParseException {

        List<Team> result = new ArrayList<Team>();

        for (int i = 0; i < count; i++) {
            result.add(assembleTeam(option));
        }

        return result;
    }
}
