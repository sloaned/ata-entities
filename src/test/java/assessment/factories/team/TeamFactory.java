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

    private Team assembleBaseTeam() {

		Team baseTeam = new Team();

		baseTeam.setId(generateRandomHash(24));
		baseTeam.setName(VALID_TEAM_NAME);
		baseTeam.setActive(true);
		baseTeam.setMemberList(USER_LIST);
		baseTeam.setAvatar(VALID_GRAVATAR_HASH);
		baseTeam.setDescription(VALID_TEAM_DESCRIPTION);
		baseTeam.setReviewPeriods(REVIEW_PERIOD_LIST);
		baseTeam.setSummaryScore(VALID_SUMMARY_SCORE);
		baseTeam.setVersion(TEAM_CURRENT_VERSION);

		return baseTeam;

    }

    public Team assembleTeam(TeamOption teamOption) {

        Team team = assembleBaseTeam();

        switch (teamOption) {

            case VALID_ACTIVE_TEAM:
                break;

            case VALID_INACTIVE_TEAM:
                team.setActive(false);
                break;

            case INVALID_TEAM_NAME_SPECIAL_CHARACTERS:
                team.setName(INVALID_OBJECT_NAME_SPECIAL_CHARACTERS);
                break;

            case INVALID_TEAM_NAME_TOO_LONG:
                team.setName(generateRandomString(101));
                break;

            case INVALID_TEAM_NAME_NULL:
                team.setName(null);
                break;

            case INVALID_TEAM_IS_ACTIVE_NULL:
                team.setActive(null);
                break;

            case INVALID_TEAM_DESCRIPTION_TOO_LONG:
                team.setDescription(generateRandomString(256));
                break;

            case INVALID_TEAM_SUMMARY_SCORE_MIN:
                team.setSummaryScore(generateRandomDouble(SMALL_SUMMARY_SCORE, 1.0));
                break;

            case INVALID_TEAM_SUMMARY_SCORE_MAX:
                team.setSummaryScore(generateRandomDouble(LARGE_SUMMARY_SCORE, 5.01));
                break;

            case INVALID_TEAM_VERSION_NULL:
                team.setVersion(null);
                break;

            case INVALID_TEAM_VERSION_ZERO:
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
