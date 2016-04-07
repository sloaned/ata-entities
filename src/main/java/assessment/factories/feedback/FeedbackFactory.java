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

        Feedback feedback = null;

        switch (option) {
            case VALID_QUALITATIVE_FEEDBACK:
                feedback = new Feedback(
                        FEEDBACK_TYPE_KUDOS,
                        VALID_FEEDBACK_LABEL,
                        VALID_FEEDBACK_SCORE,
                        VALID_FEEDBACK_COMMENT,
                        VALID_ENTITY_VERSION
                );
                break;

            case VALID_QUANTITATIVE_FEEDBACK:
                feedback = new Feedback(
                        FEEDBACK_TYPE_KUDOS,
                        VALID_FEEDBACK_LABEL,
                        VALID_FEEDBACK_SCORE,
                        VALID_FEEDBACK_COMMENT,
                        VALID_ENTITY_VERSION
                );
                break;

            case INVALID_FEEDBACK_NULL_TYPE:
                feedback = new Feedback(
                        null,
                        VALID_FEEDBACK_LABEL,
                        VALID_FEEDBACK_SCORE,
                        VALID_FEEDBACK_COMMENT,
                        VALID_ENTITY_VERSION
                );
                break;

            case INVALID_FEEDBACK_NULL_VERSION:
                feedback = new Feedback(
                        FEEDBACK_TYPE_KUDOS,
                        VALID_FEEDBACK_LABEL,
                        VALID_FEEDBACK_SCORE,
                        VALID_FEEDBACK_COMMENT,
                        null
                );
                break;

            case INVALID_FEEDBACK_EMPTY_LABEL:
                feedback = new Feedback(
                        FEEDBACK_TYPE_KUDOS,
                        INVALID_FEEDBACK_LABEL_EMTPY,
                        VALID_FEEDBACK_SCORE,
                        VALID_FEEDBACK_COMMENT,
                        VALID_ENTITY_VERSION
                );
                break;

            case INVALID_FEEDBACK_LONG_LABEL:
                feedback = new Feedback(
                        FEEDBACK_TYPE_KUDOS,
                        generateRandomString(256),
                        VALID_FEEDBACK_SCORE,
                        VALID_FEEDBACK_COMMENT,
                        VALID_ENTITY_VERSION
                );
                break;

            case INVALID_FEEDBACK_LONG_COMMENT:
                feedback = new Feedback(
                        FEEDBACK_TYPE_KUDOS,
                        VALID_FEEDBACK_LABEL,
                        VALID_FEEDBACK_SCORE,
                        generateRandomString(1501),
                        VALID_ENTITY_VERSION
                );
                break;

            case INVALID_FEEDBACK_OVERBOUND_SCORE:
                feedback = new Feedback(
                        FEEDBACK_TYPE_KUDOS,
                        VALID_FEEDBACK_LABEL,
                        INVALID_FEEDBACK_SCORE_OVERBOUND,
                        VALID_FEEDBACK_COMMENT,
                        VALID_ENTITY_VERSION
                );
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
