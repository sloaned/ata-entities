package assessment.testbase;

import assessment.entities.User.Role;

/**
 * Created by hmccardell on 3/29/2016.
 */
public class TestBaseConstants {

    /**
     * GENERAL SECTION
     */
    protected final static int VALID_ENTITY_VERSION = 1;
    protected final static String VALID_DATE = "2016-03-25";
    protected final static String VALID_DATE_FORMAT = "yyyy-MM-dd";


    /**
     * USER SECTION
     */
    protected final static String VALID_USER_ID = "testid";
    protected final static String VALID_USER_GRAVATAR_HASH = "simulatedHASH0123456789SIMULATEDhash";
    protected final static String VALID_USER_EMAIL = "squag@catalystdevworks.com";
    protected final static String VALID_USER_FIRST_NAME = "Stuart";
    protected final static String VALID_USER_LAST_NAME = "Smalley";
    protected final static String VALID_USER_DESCRIPTION = "My name is Stuart Smalley, and I'm going to help people. I'm good enough, smart enough, and gosh darnit, people like me";


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