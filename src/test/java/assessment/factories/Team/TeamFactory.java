package assessment.factories.Team;

import assessment.entities.Team.Team;
import assessment.testbase.TestBaseConstants;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alysha Recore on 3/31/2016.
 */
public class TeamFactory extends TestBaseConstants {

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
                team.setVersion(VALID_ENTITY_VERSION);
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

            case BAD_TEAM:
                team.setActive(true);
                team.setName(BAD_OBJECT_NAME);
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
