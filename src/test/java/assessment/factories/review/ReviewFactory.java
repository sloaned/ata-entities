package assessment.factories.review;

import assessment.entities.feedback.Feedback;
import assessment.entities.review.Review;
import assessment.factories.user.UserFactory;
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
		baseReview.setTeamName(VALID_TEAM_NAME);
        baseReview.setVersion(REVIEW_CURRENT_VERSION);

        return baseReview;
    }

    public Review assembleReview(ReviewOption reviewOption) {

        Review review = assembleBaseReview();

        UserFactory userFactory = new UserFactory();

        review.setReviewerId(VALID_REVIEWER_HASH);
        review.setReviewedId(VALID_REVIEWED_HASH);

        switch(reviewOption){

            case VALID_REVIEW:
                break;

            case INVALID_REVIEW_REVIEWER_ID_NULL:
                review.setReviewerId(null);
                break;

            case INVALID_REVIEW_REVIEWER_ID_EMPTY:
                review.setReviewerId("");
                break;

            case INVALID_REVIEW_REVIEWED_ID_NULL:
                review.setReviewedId(null);
                break;

            case INVALID_REVIEW_REVIEWED_ID_EMPTY:
                review.setReviewedId("");
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

			case INVALID_TEAM_NAME_SPECIAL_CHARACTERS:
				review.setTeamName(INVALID_OBJECT_NAME_SPECIAL_CHARACTERS);
				break;

			case INVALID_TEAM_NAME_TOO_LONG:
				review.setTeamName(generateRandomString(101));
				break;

			case INVALID_TEAM_NAME_NULL:
				review.setTeamName(null);
				break;

			case INVALID_REVIEW_SELF_REVIEW:
                String randomId = generateRandomString(10);

                review.setReviewerId(randomId);
                review.setReviewedId(randomId);
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
