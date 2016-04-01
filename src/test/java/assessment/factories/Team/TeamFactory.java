package assessment.factories.Team;

import assessment.entities.Team.Team;
import assessment.testbase.TestBaseConstants;

/**
 * Created by Alysha Recore on 3/31/2016.
 */
public class TeamFactory extends TestBaseConstants {

    public Team assembleValidTeam (TeamOption teamOption){
        Team team = new Team();

        switch(teamOption){
            case VALID_ACTIVE_TEAM:
                team.setActive(true);
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(VALID_DESCRIPTION);
                team.setName(VALID_OBJECT_NAME);
                team.setReviewFrequency(VALID_REVIEW_FREQUENCY);
                team.setType(TEAM_DEV);
                team.setVersion(VALID_ENTITY_VERSION);

                break;

            case VALID_INACTIVE_TEAM:
                team.setActive(false);
                team.setAvatar(VALID_GRAVATAR_HASH);
                team.setDescription(VALID_DESCRIPTION);
                team.setName(VALID_OBJECT_NAME);
                team.setReviewFrequency(VALID_REVIEW_FREQUENCY);
                team.setType(TEAM_O3);
                team.setVersion(VALID_ENTITY_VERSION);
                break;
        }
        return team;
    }

    public Team assembleBadTeam(TeamOption teamOption) {
        Team team = new Team();

        switch(teamOption){
            case BAD_ACTIVE_TEAM:

                break;

            case BAD_INACTIVE_TEAM:

                break;
        }
        return team;
    }
}
