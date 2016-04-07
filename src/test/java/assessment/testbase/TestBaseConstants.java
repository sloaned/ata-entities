package assessment.testbase;

import assessment.entities.question.Question;
import assessment.entities.assessment.Assessment;
import assessment.entities.feedback.FeedbackType;
import assessment.entities.membership.Membership;
import assessment.entities.team.TeamType;
import assessment.entities.question.QuestionType;
import assessment.entities.user.Role;

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
    protected final static String VALID_DATE_FORMAT = "yyyy-MM-dd";
    protected final static String VALID_PERSON_NAME = "test name'-";
    protected final static String VALID_DESCRIPTION = "My name is Stuart Smalley, and I'm going to help people. I'm good enough, smart enough, and gosh darnit, people like me";
    protected final static String VALID_OBJECT_NAME = "Test Name 1-'";
    protected final static String VALID_GRAVATAR_HASH = "205e460b479e2e5b48aec07710c08d50";

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
     * QUESTION SECTION
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
     * FEEDBACK SECTION
     *
     * Valid Input:
     */
    protected final static Integer VALID_FEEDBACK_VERSION = 1;
    protected final static String VALID_FEEDBACK_LABEL = "Valid Feedback Label";
    protected final static Integer VALID_FEEDBACK_SCORE = 3;
    protected final static String VALID_FEEDBACK_COMMENT = "A Valid comment for a feedback entity";
    /**
     * Invalid Input:
     */
    protected final static String INVALID_FEEDBACK_LABEL_EMTPY = "";
    protected final static Integer INVALID_FEEDBACK_SCORE_OVERBOUND = 6;


    /**
     * FEEDBACK TYPE SECTION
     */
    protected final static FeedbackType FEEDBACK_TYPE_KUDOS = FeedbackType.KUDOS;
    protected final static FeedbackType FEEDBACK_TYPE_ASSESSMENT = FeedbackType.ASSESSMENT;

    /**
     * ASSESSMENT SECTION
     */
    protected List<Question> QUESTION_LIST = new ArrayList<Question>();

    /**
     * TEAM SECTION
     */
    protected final static String VALID_TEAM_NAME = "Hayes' Heroes";
    protected final static Integer VALID_REVIEW_FREQUENCY = 1;
    public List<Membership> LEADER_LIST = new ArrayList<Membership>();
    public List<Membership> USER_LIST = new ArrayList<Membership>();
    public Assessment ASSESSMENT = new Assessment();

    /**
     * TEAM TYPE SECTION
     */
    protected final static TeamType TEAM_O3 = TeamType.valueOf("O3");
    protected final static TeamType TEAM_DEV = TeamType.valueOf("DEV");


    /**
     * REVIEW SECTION
     *
     * Valid input:
     */
    protected final static Double VALID_SUMMARY_SCORE = 3.74;

    /**
     * Invalid input:
     */
    protected final static Double SMALL_SUMMARY_SCORE = -100.0;
    protected final static Double LARGE_SUMMARY_SCORE = 100.0;
}
