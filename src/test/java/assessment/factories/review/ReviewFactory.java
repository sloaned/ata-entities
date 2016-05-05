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

    private Review assembleBaseReview() {

        Review baseReview = new Review();

        Feedback testFeedbackObject = new Feedback();
        List<Feedback> testFeedback = new ArrayList<Feedback>();
        testFeedback.add(testFeedbackObject);

     /*Add an offset to make sure the date isn't in the past.
     * 1000 * 60 = one minute in milliseconds*/

        long offset = 1000 * 60;

        baseReview.setSubmittedDate(new Date(System.currentTimeMillis() + offset));
        baseReview.setFeedback(testFeedback);
        baseReview.setSummaryScore(VALID_SUMMARY_SCORE);
        baseReview.setVersion(REVIEW_CURRENT_VERSION);

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

            case INVALID_REVIEW_REVIEWER_ID_NULL:
                review.setReviewerId(null);
                break;

            case INVALID_REVIEW_REVIEWED_ID_NULL:
                review.setReviewedId(null);
                break;

            case INVALID_REVIEW_SUBMITTED_DATE_NULL:
                review.setSubmittedDate(null);
                break;

            case INVALID_REVIEW_FEEDBACK_EMPTY:
                review.setFeedback(new ArrayList<Feedback>());
                break;

            case INVALID_REVIEW_FEEDBACK_NULL:
                review.setFeedback(null);
                break;

            case INVALID_REVIEW_VERSION_NULL:
                review.setVersion(null);
                break;

            case INVALID_REVIEW_VERSION_ZERO:
                review.setVersion(0);
                break;

            case INVALID_REVIEW_SUMMARY_SCORE_SMALL:
                review.setSummaryScore(generateRandomDouble(SMALL_SUMMARY_SCORE, 1.0));
                break;

            case INVALID_REVIEW_SUMMARY_SCORE_LARGE:
                review.setSummaryScore(generateRandomDouble(5.01, LARGE_SUMMARY_SCORE));
                break;

            case INVALID_REVIEW_SELF_REVIEW:
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
