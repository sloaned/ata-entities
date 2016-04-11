package assessment.factories.feedback;

import assessment.entities.feedback.Feedback;
import assessment.testbase.TestBase;
import java.util.ArrayList;
import java.util.List;

/**
 * Factory used for creating feedback entities
 */
public class FeedbackFactory extends TestBase {

    public Feedback assembleFeedback(FeedbackOption option) {

        Feedback feedback = new Feedback();

        switch (option) {
            case VALID_QUALITATIVE_FEEDBACK:
                feedback.setType(FEEDBACK_TYPE_KUDOS);
                feedback.setLabel(VALID_FEEDBACK_LABEL);
                feedback.setScore(VALID_FEEDBACK_SCORE);
                feedback.setComment(VALID_FEEDBACK_COMMENT);
                feedback.setVersion(FEEDBACK_CURRENT_VERSION);
                break;

            case VALID_QUANTITATIVE_FEEDBACK:
                feedback.setType(FEEDBACK_TYPE_KUDOS);
                feedback.setLabel(VALID_FEEDBACK_LABEL);
                feedback.setScore(VALID_FEEDBACK_SCORE);
                feedback.setComment(VALID_FEEDBACK_COMMENT);
                feedback.setVersion(FEEDBACK_CURRENT_VERSION);
                break;

            case INVALID_FEEDBACK_TYPE_NULL:
                feedback.setType(null);
                feedback.setLabel(VALID_FEEDBACK_LABEL);
                feedback.setScore(VALID_FEEDBACK_SCORE);
                feedback.setComment(VALID_FEEDBACK_COMMENT);
                feedback.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_FEEDBACK_LABEL_EMPTY:
                feedback.setType(FEEDBACK_TYPE_KUDOS);
                feedback.setLabel(EMPTY_STRING);
                feedback.setScore(VALID_FEEDBACK_SCORE);
                feedback.setComment(VALID_FEEDBACK_COMMENT);
                feedback.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_FEEDBACK_LABEL_LONG:
                feedback.setType(FEEDBACK_TYPE_KUDOS);
                feedback.setLabel(generateRandomString(256));
                feedback.setScore(VALID_FEEDBACK_SCORE);
                feedback.setComment(VALID_FEEDBACK_COMMENT);
                feedback.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_FEEDBACK_COMMENT_LONG:
                feedback.setType(FEEDBACK_TYPE_KUDOS);
                feedback.setLabel(VALID_FEEDBACK_LABEL);
                feedback.setScore(VALID_FEEDBACK_SCORE);
                feedback.setComment(generateRandomString(1501));
                feedback.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_FEEDBACK_SCORE_OVERBOUND:
                feedback.setType(FEEDBACK_TYPE_KUDOS);
                feedback.setLabel(VALID_FEEDBACK_LABEL);
                feedback.setScore(INVALID_FEEDBACK_SCORE_OVERBOUND);
                feedback.setComment(VALID_FEEDBACK_COMMENT);
                feedback.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_FEEDBACK_VERSION_ZERO:
                feedback.setType(FEEDBACK_TYPE_KUDOS);
                feedback.setLabel(VALID_FEEDBACK_LABEL);
                feedback.setScore(VALID_FEEDBACK_SCORE);
                feedback.setComment(VALID_FEEDBACK_COMMENT);
                feedback.setVersion(0);
                break;

            case INVALID_FEEDBACK_VERSION_NULL:
                feedback.setType(FEEDBACK_TYPE_KUDOS);
                feedback.setLabel(VALID_FEEDBACK_LABEL);
                feedback.setScore(VALID_FEEDBACK_SCORE);
                feedback.setComment(VALID_FEEDBACK_COMMENT);
                feedback.setVersion(null);
                break;



        }

        return feedback;
    }

    public List<Feedback> assembleFeedbackList(FeedbackOption option, int count) {

        List<Feedback> feedbackList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            feedbackList.add(assembleFeedback(option));
        }

        return feedbackList;
    }
}
