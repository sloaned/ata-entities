package assessment.validation;

import assessment.entities.Team.Team;
import assessment.factories.Team.TeamFactory;
import assessment.factories.Team.TeamOption;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Created by Alysha Recore on 4/1/2016.
 */
public class TeamValidationTest {

    private static Validator validator;
    private Team testTeam;
    TeamFactory teamFactory = new TeamFactory();

    @Before
    public void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void HappyPathValidationOfTeamFactoryValidActiveTeam() {
        testTeam = teamFactory.assembleTeam(TeamOption.VALID_ACTIVE_TEAM);
        Set<ConstraintViolation<Team>> violations = validator.validate(testTeam);
        assertTrue("INVALID TEAM: The team factory assembled a team that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void HappyPathValidationOfTeamFactoryValidInactiveTeam() {
        testTeam = teamFactory.assembleTeam(TeamOption.VALID_INACTIVE_TEAM);
        Set<ConstraintViolation<Team>> violations = validator.validate(testTeam);
        assertTrue("INVALID TEAM: The team factory assembled a team that doesn't pass entity validation", violations.isEmpty());
    }

    @Test void SadPathValidationOfTeamFactoryInvalidTeam() {
        testTeam = teamFactory.assembleTeam(TeamOption.BAD_TEAM);
    }
}
