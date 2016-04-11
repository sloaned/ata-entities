package assessment.validation;

import assessment.entities.team.Team;
import assessment.factories.team.TeamFactory;
import assessment.factories.team.TeamOption;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertFalse;
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

    @Test
    public void SadPathValidationOfTeamFactoryNameHasSpecialCharacters() {
        testTeam = teamFactory.assembleTeam(TeamOption.INVALID_TEAM_NAME_SPECIAL_CHARACTERS);
        Set<ConstraintViolation<Team>> violations = validator.validate(testTeam);
        assertFalse("INVALID TEAM: The team factory assembled a team that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfTeamFactoryTeamNameTooLong() {
        testTeam = teamFactory.assembleTeam(TeamOption.INVALID_TEAM_NAME_LONG);
        Set<ConstraintViolation<Team>> violations = validator.validate(testTeam);
        assertFalse("INVALID TEAM: The team factory assembled a team that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfTeamFactoryTeamNameIsNull() {
        testTeam = teamFactory.assembleTeam(TeamOption.INVALID_TEAM_NAME_NULL);
        Set<ConstraintViolation<Team>> violations = validator.validate(testTeam);
        assertFalse("INVALID TEAM: The team factory assembled a team that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfTeamFactoryTeamActiveNull() {
        testTeam = teamFactory.assembleTeam(TeamOption.INVALID_TEAM_ACTIVE_NULL);
        Set<ConstraintViolation<Team>> violations = validator.validate(testTeam);
        assertFalse("INVALID TEAM: The team factory assembled a team that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfTeamFactoryTeamTypeIsNull() {
        testTeam = teamFactory.assembleTeam(TeamOption.INVALID_TEAM_TYPE_NULL);
        Set<ConstraintViolation<Team>> violations = validator.validate(testTeam);
        assertFalse("INVALID TEAM: The team factory assembled a team that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfTeamFactoryInvalidTeamVersionNull() {
        testTeam = teamFactory.assembleTeam(TeamOption.INVALID_TEAM_VERSION_NULL);
        Set<ConstraintViolation<Team>> violations = validator.validate(testTeam);
        assertFalse("INVALID TEAM: The team factory assembled a team that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfTeamFactoryInvalidTeamVersionZero() {
        testTeam = teamFactory.assembleTeam(TeamOption.INVALID_TEAM_VERSION_ZERO);
        Set<ConstraintViolation<Team>> violations = validator.validate(testTeam);
        assertFalse("INVALID TEAM: The team factory assembled a team that doesn't pass entity validation", violations.isEmpty());
    }
}
