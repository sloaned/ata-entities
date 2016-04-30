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
 * Updated by mmosley on 4/29/2016.
 */
public class TeamValidationTest {

    private static Validator validator;
    private Team testTeam;
    TeamFactory teamFactory = new TeamFactory();

    @Before
    public static void setUp() {
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

    /*@Test
    public void SadPathValidationOfTeamFactoryTeamDuplicate() {
        testTeam = teamFactory.assembleTeam(TeamOption.INVALID_TEAM_DUPLICATE);
        Set<ConstraintViolation<Team>> violations = validator.validate(testTeam);
        assertTrue("INVALID TEAM: duplicate", violations.isEmpty());
    }*/

    @Test
    public void SadPathValidationOfTeamFactoryNameHasSpecialCharacters() {
        testTeam = teamFactory.assembleTeam(TeamOption.INVALID_TEAM_NAME_SPECIAL_CHARACTERS);
        Set<ConstraintViolation<Team>> violations = validator.validate(testTeam);
        assertFalse("INVALID TEAM: name should not include special characters", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfTeamFactoryTeamNameTooLong() {
        testTeam = teamFactory.assembleTeam(TeamOption.INVALID_TEAM_NAME_TOO_LONG);
        Set<ConstraintViolation<Team>> violations = validator.validate(testTeam);
        assertFalse("INVALID TEAM: name should not exceed maximum limit of characters", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfTeamFactoryTeamNameIsNull() {
        testTeam = teamFactory.assembleTeam(TeamOption.INVALID_TEAM_NAME_NULL);
        Set<ConstraintViolation<Team>> violations = validator.validate(testTeam);
        assertFalse("INVALID TEAM: name should not be null", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfTeamFactoryTeamActiveNull() {
        testTeam = teamFactory.assembleTeam(TeamOption.INVALID_TEAM_IS_ACTIVE_NULL);
        Set<ConstraintViolation<Team>> violations = validator.validate(testTeam);
        assertFalse("INVALID TEAM: team isActive should not be null", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfTeamFactoryTeamDescriptionTooLong() {
        testTeam = teamFactory.assembleTeam(TeamOption.INVALID_TEAM_DESCRIPTION_TOO_LONG);
        Set<ConstraintViolation<Team>> violations = validator.validate(testTeam);
        assertFalse("INVALID TEAM: description should not exceed maximum limit of characters", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfTeamFactoryInvalidTeamVersionNull() {
        testTeam = teamFactory.assembleTeam(TeamOption.INVALID_TEAM_VERSION_NULL);
        Set<ConstraintViolation<Team>> violations = validator.validate(testTeam);
        assertFalse("INVALID TEAM: version should not be null", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfTeamFactoryInvalidTeamVersionZero() {
        testTeam = teamFactory.assembleTeam(TeamOption.INVALID_TEAM_VERSION_ZERO);
        Set<ConstraintViolation<Team>> violations = validator.validate(testTeam);
        assertFalse("INVALID TEAM: version should be minimum of 1", violations.isEmpty());
    }
}
