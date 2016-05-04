package assessment.factories.feedback;

import assessment.entities.feedback.Feedback;
import assessment.testbase.TestBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory used for creating feedback entities
 */
public class FeedbackFactory extends TestBase {

    public Feedback assembleBaseFeedback() {

		Feedback baseFeedback = new Feedback();

		baseFeedback.setLabel(VALID_FEEDBACK_LABEL);
		baseFeedback.setScore(VALID_FEEDBACK_SCORE);
		baseFeedback.setComment(VALID_FEEDBACK_COMMENT);
		baseFeedback.setVersion(VALID_ENTITY_VERSION);

		return baseFeedback;

    }

    public Feedback assembleFeedback(FeedbackOption option) {

        Feedback feedback = assembleBaseFeedback();

        switch (option) {

            case VALID_FEEDBACK:
                break;

            case INVALID_FEEDBACK_LABEL_EMPTY:
                feedback.setLabel(EMPTY_STRING);
                break;

            case INVALID_FEEDBACK_LABEL_TOO_LONG:
                feedback.setLabel(generateRandomString(256));
                break;

            case INVALID_FEEDBACK_SCORE_ZERO:
                feedback.setScore(0);
                break;

            case INVALID_FEEDBACK_SCORE_OVERBOUND:
                feedback.setScore(INVALID_SCORE_OVERBOUND);
                break;

            case INVALID_FEEDBACK_COMMENT_TOO_LONG:
                feedback.setComment(generateRandomString(1501));
                break;

            case INVALID_FEEDBACK_VERSION_NULL:
                feedback.setVersion(null);
                break;

            case INVALID_FEEDBACK_VERSION_ZERO:
                feedback.setVersion(0);
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
