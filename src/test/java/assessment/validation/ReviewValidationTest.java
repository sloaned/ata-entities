package assessment.validation;

import assessment.entities.review.Review;
import assessment.factories.review.ReviewFactory;
import assessment.factories.review.ReviewOption;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by jtucker on 4/1/2016.
 */

public class ReviewValidationTest {

    private static Validator validator;
    private Review testReview;
    ReviewFactory reviewFactory = new ReviewFactory();

    private void assertThereIsExactlyOneViolation(Validator validator, Review review) {
        Set<ConstraintViolation<Review>> violations = validator.validate(review);
        assertFalse("VALID REVIEW: the review factory assembled a review that passes entity validation", violations.isEmpty());
        assertFalse("INVALID REVIEW: the review factory assembled a review that failed multiple validations", violations.size() > 1);
    }

    @BeforeClass
    public static void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void HappyPathReviewValidation() {
        testReview = reviewFactory.assembleReview(ReviewOption.VALID_REVIEW);
        Set<ConstraintViolation<Review>> violations = validator.validate(testReview);
        assertTrue("INVALID REVIEW: the review factory assembled a review that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void SadPathReviewReviewerNull() {
        testReview = reviewFactory.assembleReview(ReviewOption.INVALID_REVIEW_REVIEWER_ID_NULL);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

    @Test
    public void SadPathReviewReviewerIdEmpty() {
        testReview = reviewFactory.assembleReview(ReviewOption.INVALID_REVIEW_REVIEWER_ID_EMPTY);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

    @Test
    public void SadPathReviewReviewedIdNull() {
        testReview = reviewFactory.assembleReview(ReviewOption.INVALID_REVIEW_REVIEWED_ID_NULL);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

    @Test
    public void SadPathReviewReviewedIdEmpty() {
        testReview = reviewFactory.assembleReview(ReviewOption.INVALID_REVIEW_REVIEWED_ID_EMPTY);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

    @Test
    public void SadPathReviewSubmittedDateNull() {
        testReview = reviewFactory.assembleReview(ReviewOption.INVALID_REVIEW_SUBMITTED_DATE_NULL);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

    @Test
    public void SadPathReviewFeedbackEmpty() {
        testReview = reviewFactory.assembleReview(ReviewOption.INVALID_REVIEW_FEEDBACK_EMPTY);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

    @Test
    public void SadPathReviewFeedbackNull() {
        testReview = reviewFactory.assembleReview(ReviewOption.INVALID_REVIEW_FEEDBACK_NULL);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

    @Test
    public void SadPathReviewVersionNull() {
        testReview = reviewFactory.assembleReview(ReviewOption.INVALID_REVIEW_VERSION_NULL);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

    @Test
    public void SadPathReviewVersionZero() {
        testReview = reviewFactory.assembleReview(ReviewOption.INVALID_REVIEW_VERSION_ZERO);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

    @Test
    public void SadPathReviewSummaryScoreSmall() {
        testReview = reviewFactory.assembleReview(ReviewOption.INVALID_REVIEW_SUMMARY_SCORE_SMALL);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

    @Test
    public void SadPathReviewSummaryScoreLarge() {
        testReview = reviewFactory.assembleReview(ReviewOption.INVALID_REVIEW_SUMMARY_SCORE_LARGE);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

    @Test
    public void SadPathReviewSelfReview() {
        testReview = reviewFactory.assembleReview(ReviewOption.INVALID_REVIEW_SELF_REVIEW);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

}
