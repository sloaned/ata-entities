package assessment.testbase;

import assessment.entities.user.Role;

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

    /**
     * Invalid Input:
     */
    protected final static String BAD_PERSON_NAME = "$@598";

    /**
     * USER SECTION
     *
     * Valid Input:
     */
    protected final static String VALID_USER_GRAVATAR_HASH = "simulatedHASH0123456789SIMULATEDhash";
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



}
