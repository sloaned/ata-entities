package assessment.factories.review;

import assessment.entities.feedback.Feedback;
import assessment.entities.review.Review;
import assessment.entities.user.User;
import assessment.factories.user.UserFactory;
import assessment.factories.user.UserOption;
import assessment.testbase.TestBase;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jtucker on 4/1/2016.
 */
public class ReviewFactory extends TestBase{

    public Review assembleBaseReview() {

        Review baseReview = new Review();

        Feedback testFeedbackObject = new Feedback();
        List<Feedback> testFeedback = new ArrayList<Feedback>();
        testFeedback.add(testFeedbackObject);

        baseReview.setTeamName(VALID_TEAM_NAME);
        baseReview.setSubmittedDate(new Date());
        baseReview.setFeedback(testFeedback);
        baseReview.setSummaryScore(VALID_SUMMARY_SCORE);
        baseReview.setVersion(VALID_ENTITY_VERSION);

        return baseReview;
    }

    public Review assembleReview(ReviewOption reviewOption) {

        Review review = assembleBaseReview();

        UserFactory userFactory = new UserFactory();
        User testReviewer = userFactory.assembleUser(UserOption.VALID_ACTIVE_DEVELOPER);
        User testReviewed = userFactory.assembleUser(UserOption.VALID_INACTIVE_DEVELOPER);

        review.setReviewerId(testReviewer);
        review.setReviewedId(testReviewed);

        switch(reviewOption){

            case VALID_REVIEW:
                break;

            case NULL_REVIEWER_ID_REVIEW:
                review.setReviewerId(null);
                break;

            case NULL_REVIEWED_ID_REVIEW:
                review.setReviewedId(null);
                break;

            case EMPTY_TEAM_NAME_REVIEW:
                review.setTeamName("");
                break;

            case NULL_TEAM_NAME_REVIEW:
                review.setTeamName(null);
                break;

            case NULL_SUBMITTED_DATE_REVIEW:
                review.setSubmittedDate(null);
                break;

            case EMPTY_FEEDBACK_REVIEW:
                review.setFeedback(new ArrayList<Feedback>());
                break;

            case NULL_FEEDBACK_REVIEW:
                review.setFeedback(null);
                break;

            case NULL_VERSION_REVIEW:
                review.setVersion(null);
                break;

            case SMALL_SUMMARY_SCORE_REVIEW:
                review.setSummaryScore(generateRandomDouble(SMALL_SUMMARY_SCORE, 1.0));
                break;

            case LARGE_SUMMARY_SCORE_REVIEW:
                review.setSummaryScore(generateRandomDouble(5.01, LARGE_SUMMARY_SCORE));
                break;

            case SELF_REVIEW:
                String randomId = generateRandomString(10);

                testReviewer.setId(randomId);
                testReviewed.setId(randomId);

                review.setReviewerId(testReviewer);
                review.setReviewedId(testReviewed);
                break;
        }

        return review;
    }

    public List<Review> assembleReviewsAsList(ReviewOption reviewOption, int count) throws ParseException {

        List<Review> result = new ArrayList<Review>();

        for (int i = 0; i < count; i++) {
            result.add(assembleReview(reviewOption));
        }

        return result;
    }

}
