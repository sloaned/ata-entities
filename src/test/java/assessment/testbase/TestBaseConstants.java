package assessment.testbase;

import assessment.entities.Assessment.Assessment;
import assessment.entities.Membership.Membership;
import assessment.entities.Team.TeamType;
import assessment.entities.User.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hmccardell on 3/29/2016.
 */
public class TestBaseConstants {

    /**
     * GENERAL SECTION
     *
     * Valid Input:
     */
    protected final static int VALID_ENTITY_VERSION = 1;
    protected final static String VALID_DATE = "2016-03-25";
    protected final static String VALID_DATE_FORMAT = "yyyy-MM-dd";
    protected final static String VALID_PERSON_NAME = "test name'-";
    protected final static String VALID_DESCRIPTION = "My name is Stuart Smalley, and I'm going to help people. I'm good enough, smart enough, and gosh darnit, people like me";
    protected final static String VALID_OBJECT_NAME = "Test Name 1-'";
    protected final static String VALID_GRAVATAR_HASH = "simulatedHASH0123456789SIMULATEDhash";

    /**
     * Invalid Input:
     */
    protected final static String BAD_PERSON_NAME = "$@598";
    protected final static String BAD_OBJECT_NAME = "$%@#";

    /**
     * USER SECTION
     *
     * Valid Input:
     */
    protected final static String VALID_USER_EMAIL = "squag@catalystdevworks.com";

    /**
     * Invalid Input
     */
    protected final static String BAD_USER_EMAIL = "bad email example!";

    /**
     * ROLE SECTION
     */
    protected final static Role ROLE_DEVELOPER = Role.valueOf("DEVELOPER");
    protected final static Role ROLE_LEAD = Role.valueOf("LEAD");
    protected final static Role ROLE_MENTOR = Role.valueOf("MENTOR");


    /**
     * FEEDBACK SECTION
     */

    /**
     * TEAM SECTION
     */
    protected final static Integer VALID_REVIEW_FREQUENCY = 1;
    public List<Membership> LEADER_LIST = new ArrayList<Membership>();
    public List<Membership> USER_LIST = new ArrayList<Membership>();
    public Assessment ASSESSMENT = new Assessment();


    /**
     * TEAM TYPE SECTION
     */
    protected final static TeamType TEAM_O3 = TeamType.valueOf("O3");
    protected final static TeamType TEAM_DEV = TeamType.valueOf("DEV");

}
