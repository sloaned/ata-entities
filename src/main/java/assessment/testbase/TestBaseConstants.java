package assessment.testbase;

import assessment.entities.assessment.Assessment;
import assessment.entities.feedback.FeedbackType;
import assessment.entities.membership.Membership;
import assessment.entities.question.Question;
import assessment.entities.question.QuestionType;
import assessment.entities.team.TeamType;
import assessment.entities.user.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hmccardell on 3/29/2016.
 */
public class TestBaseConstants {


    /**
     * ENTITY VERSIONS
     *
     */
    public final static int ASSESSMENT_CURRENT_VERSION = 1;
    public final static int FEEDBACK_CURRENT_VERSION = 1;
    public final static int MEMBERSHIP_CURRENT_VERSION = 1;
    public final static int QUESTION_CURRENT_VERSION = 1;
    public final static int REVIEW_CURRENT_VERSION = 1;
    public final static int TEAM_CURRENT_VERSION = 1;
    public final static int USER_CURRENT_VERSION = 1;
    public final static int KUDO_CURRENT_VERSION = 1;
    public final static int PERIOD_CURRENT_VERSION = 1;


    /**
     * GENERAL
     *
     * Valid Input:
     */
    protected final static int VALID_ENTITY_VERSION = 1;
    protected final static String VALID_DATE_FORMAT = "yyyy-MM-dd";
    protected final static String VALID_USER_NAME = "test name'-";
    protected final static String VALID_DESCRIPTION = "My name is Stuart Smalley, and I'm going to help people. I'm good enough, smart enough, and gosh darnit, people like me";
    protected final static String VALID_OBJECT_NAME = "Test Name 1-'";
    protected final static String VALID_GRAVATAR_HASH = "205e460b479e2e5b48aec07710c08d50";
    protected final static String PAST_DATE = "2016-02-02";
    protected final static String EMPTY_STRING = "";
    protected final static int DATE_OFFSET = 60 * 1000;
    protected final static String VALID_TITLE = "Developer 1";

    /**
     * Invalid Input:
     */
    protected final static String INVALID_USER_NAME_SPECIAL_CHARACTERS = "$@598";
    protected final static String INVALID_OBJECT_NAME_SPECIAL_CHARACTERS = "$%@#";

    /**
     * USER
     *
     * Valid Input:
     */

    protected final static String VALID_USER_EMAIL = "squag@catalystdevworks.com";


    /**
     * Invalid Input
     */
    protected final static String INVALID_USER_EMAIL = "bad email example!";


    /**
     * ROLE
     */
    protected final static Role ROLE_DEVELOPER = Role.valueOf("DEVELOPER");
    protected final static Role ROLE_LEAD = Role.valueOf("LEAD");
    protected final static Role ROLE_MENTOR = Role.valueOf("MENTOR");


    /**
     * QUESTION
     */
    protected final static String VALID_QUESTION_LABEL_QUANTITATIVE = "How " +
            "would you rate your teammate's overall performance on the " +
            "project?";
    protected final static String VALID_QUESTION_LABEL_QUALITATIVE = "Did " +
            "your teammate consistently meet their sprint commitments?";

    protected final static QuestionType QUESTION_TYPE_BOOLEAN = QuestionType.BOOLEAN;
    protected final static QuestionType QUESTION_TYPE_MULTIPLE_CHOICE = QuestionType.MULTIPLE_CHOICE;
    protected final static QuestionType QUESTION_TYPE_COMPETENCY = QuestionType.COMPETENCY;

    /**
     * FEEDBACK
     *
     * Valid Input:
     */
    protected final static String VALID_FEEDBACK_LABEL = "Valid Feedback Label";
    protected final static Integer VALID_FEEDBACK_SCORE = 3;
    protected final static String VALID_FEEDBACK_COMMENT = "A Valid comment for a feedback entity";
    /**
     * Invalid Input:
     */

    protected final static Integer INVALID_FEEDBACK_SCORE_OVERBOUND = 6;


    /**
     * FEEDBACK TYPE
     */
    protected final static FeedbackType FEEDBACK_TYPE_KUDOS = FeedbackType.KUDOS;
    protected final static FeedbackType FEEDBACK_TYPE_ASSESSMENT = FeedbackType.ASSESSMENT;

    /**
     * ASSESSMENT
     */
    protected List<Question> QUESTION_LIST = new ArrayList<Question>();

    /**
     * TEAM
     */
    protected final static String VALID_TEAM_NAME = "Hayes' Heroes";
    protected final static Integer VALID_REVIEW_FREQUENCY = 1;
    public List<Membership> LEADER_LIST = new ArrayList<Membership>();
    public List<Membership> USER_LIST = new ArrayList<Membership>();
    public Assessment ASSESSMENT = new Assessment();

    /**
     * TEAM TYPE
     */
    protected final static TeamType TEAM_O3 = TeamType.valueOf("O3");
    protected final static TeamType TEAM_DEV = TeamType.valueOf("DEV");


    /**
     * REVIEW
     *
     * Valid input:
     */
    protected final static Double VALID_SUMMARY_SCORE = 3.74;

    /**
     * Invalid input:
     */
    protected final static Double SMALL_SUMMARY_SCORE = -100.0;
    protected final static Double LARGE_SUMMARY_SCORE = 100.0;


    /**
     * KUDO
     *
     * Valid Input:
     */

    protected final static String VALID_REVIEWER_HASH = "205e460b479e2e5b48aec07710c08d50";
    protected final static String VALID_REVIEWED_HASH = "E7e104weasdfaeASF117650ae01843";


    /**
    * PERIOD SECTION
    *
    * Valid input
    */
    protected final static String VALID_PERIOD_NAME = "PeriodTest-";

}
