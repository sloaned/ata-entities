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
                team.setActive(true);
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(VALID_DESCRIPTION);
                team.setName(VALID_OBJECT_NAME);
                team.setReviewFrequency(VALID_REVIEW_FREQUENCY);
                team.setTeamType(TEAM_DEV);
                team.setVersion(TEAM_CURRENT_VERSION);
                team.setLeaderList(LEADER_LIST);
                team.setUserList(USER_LIST);
                team.setAssessment(ASSESSMENT);
                break;

            case VALID_INACTIVE_TEAM:
                team.setActive(false);
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(VALID_DESCRIPTION);
                team.setName(VALID_OBJECT_NAME);
                team.setReviewFrequency(VALID_REVIEW_FREQUENCY);
                team.setTeamType(TEAM_O3);
                team.setVersion(VALID_ENTITY_VERSION);
                team.setLeaderList(LEADER_LIST);
                team.setUserList(USER_LIST);
                team.setAssessment(ASSESSMENT);
                break;

            case INVALID_TEAM_NAME_SPECIAL_CHARACTERS:
                team.setActive(true);
                team.setName(INVALID_OBJECT_NAME_SPECIAL_CHARACTERS);
                team.setReviewFrequency(VALID_REVIEW_FREQUENCY);
                team.setTeamType(TEAM_O3);
                team.setVersion(VALID_ENTITY_VERSION);
                team.setLeaderList(LEADER_LIST);
                team.setUserList(USER_LIST);
                team.setAssessment(ASSESSMENT);
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(VALID_DESCRIPTION);
                break;

            case INVALID_TEAM_NAME_LONG:
                team.setActive(false);
                team.setReviewFrequency(VALID_REVIEW_FREQUENCY);
                team.setTeamType(TEAM_O3);
                team.setVersion(VALID_ENTITY_VERSION);
                team.setLeaderList(LEADER_LIST);
                team.setUserList(USER_LIST);
                team.setAssessment(ASSESSMENT);
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(VALID_DESCRIPTION);
                team.setName(generateRandomString(110));

            case INVALID_TEAM_NAME_NULL:
                team.setActive(false);
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(VALID_DESCRIPTION);
                team.setReviewFrequency(VALID_REVIEW_FREQUENCY);
                team.setTeamType(TEAM_O3);
                team.setVersion(VALID_ENTITY_VERSION);
                team.setLeaderList(LEADER_LIST);
                team.setUserList(USER_LIST);
                team.setAssessment(ASSESSMENT);
                team.setName(null);
                break;

            case INVALID_TEAM_ACTIVE_NULL:
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(VALID_DESCRIPTION);
                team.setName(VALID_OBJECT_NAME);
                team.setReviewFrequency(VALID_REVIEW_FREQUENCY);
                team.setTeamType(TEAM_O3);
                team.setVersion(VALID_ENTITY_VERSION);
                team.setLeaderList(LEADER_LIST);
                team.setUserList(USER_LIST);
                team.setAssessment(ASSESSMENT);
                team.setActive(null);
                break;

            case INVALID_TEAM_TYPE_NULL:
                team.setActive(false);
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(VALID_DESCRIPTION);
                team.setName(VALID_OBJECT_NAME);
                team.setReviewFrequency(VALID_REVIEW_FREQUENCY);
                team.setVersion(VALID_ENTITY_VERSION);
                team.setLeaderList(LEADER_LIST);
                team.setUserList(USER_LIST);
                team.setAssessment(ASSESSMENT);
                team.setTeamType(null);
                break;

            case INVALID_TEAM_VERSION_NULL:
                team.setActive(false);
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(VALID_DESCRIPTION);
                team.setName(VALID_OBJECT_NAME);
                team.setReviewFrequency(VALID_REVIEW_FREQUENCY);
                team.setTeamType(TEAM_O3);
                team.setLeaderList(LEADER_LIST);
                team.setUserList(USER_LIST);
                team.setAssessment(ASSESSMENT);
                team.setVersion(null);
                break;

            case INVALID_TEAM_VERSION_ZERO:
                team.setActive(false);
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(VALID_DESCRIPTION);
                team.setName(VALID_OBJECT_NAME);
                team.setReviewFrequency(VALID_REVIEW_FREQUENCY);
                team.setTeamType(TEAM_O3);
                team.setLeaderList(LEADER_LIST);
                team.setUserList(USER_LIST);
                team.setAssessment(ASSESSMENT);
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
