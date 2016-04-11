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
                feedback.setVersion(VALID_ENTITY_VERSION);
                break;

            case VALID_QUANTITATIVE_FEEDBACK:
                feedback.setType(FEEDBACK_TYPE_KUDOS);
                feedback.setLabel(VALID_FEEDBACK_LABEL);
                feedback.setScore(VALID_FEEDBACK_SCORE);
                feedback.setComment(VALID_FEEDBACK_COMMENT);
                feedback.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_FEEDBACK_NULL_TYPE:
                feedback.setType(null);
                feedback.setLabel(VALID_FEEDBACK_LABEL);
                feedback.setScore(VALID_FEEDBACK_SCORE);
                feedback.setComment(VALID_FEEDBACK_COMMENT);
                feedback.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_FEEDBACK_NULL_VERSION:
                feedback.setType(FEEDBACK_TYPE_KUDOS);
                feedback.setLabel(VALID_FEEDBACK_LABEL);
                feedback.setScore(VALID_FEEDBACK_SCORE);
                feedback.setComment(VALID_FEEDBACK_COMMENT);
                feedback.setVersion(null);
                break;

            case INVALID_FEEDBACK_EMPTY_LABEL:
                feedback.setType(FEEDBACK_TYPE_KUDOS);
                feedback.setLabel(EMPTY_STRING);
                feedback.setScore(VALID_FEEDBACK_SCORE);
                feedback.setComment(VALID_FEEDBACK_COMMENT);
                feedback.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_FEEDBACK_LONG_LABEL:
                feedback.setType(FEEDBACK_TYPE_KUDOS);
                feedback.setLabel(generateRandomString(256));
                feedback.setScore(VALID_FEEDBACK_SCORE);
                feedback.setComment(VALID_FEEDBACK_COMMENT);
                feedback.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_FEEDBACK_LONG_COMMENT:
                feedback.setType(FEEDBACK_TYPE_KUDOS);
                feedback.setLabel(VALID_FEEDBACK_LABEL);
                feedback.setScore(VALID_FEEDBACK_SCORE);
                feedback.setComment(generateRandomString(1501));
                feedback.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_FEEDBACK_OVERBOUND_SCORE:
                feedback.setType(FEEDBACK_TYPE_KUDOS);
                feedback.setLabel(VALID_FEEDBACK_LABEL);
                feedback.setScore(INVALID_FEEDBACK_SCORE_OVERBOUND);
                feedback.setComment(VALID_FEEDBACK_COMMENT);
                feedback.setVersion(VALID_ENTITY_VERSION);
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
