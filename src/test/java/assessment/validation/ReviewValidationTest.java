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
    public void TestValidReview() {
        testReview = reviewFactory.assembleReview(ReviewOption.VALID_REVIEW);
        Set<ConstraintViolation<Review>> violations = validator.validate(testReview);
        assertTrue("INVALID REVIEW: the review factory assembled a review that doesn't pass entity validation", violations.isEmpty());
    }

    @Test
    public void TestNullReviewerIdReview() {
        testReview = reviewFactory.assembleReview(ReviewOption.NULL_REVIEWER_ID_REVIEW);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

    @Test
    public void TestNullReviewedIdReview() {
        testReview = reviewFactory.assembleReview(ReviewOption.NULL_REVIEWED_ID_REVIEW);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

    @Test
    public void TestEmptyTeamNameReview() {
        testReview = reviewFactory.assembleReview(ReviewOption.EMPTY_TEAM_NAME_REVIEW);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

    @Test
    public void TestNullTeamNameReview() {
        testReview = reviewFactory.assembleReview(ReviewOption.NULL_TEAM_NAME_REVIEW);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

    @Test
    public void TestNullSubmittedDateReview() {
        testReview = reviewFactory.assembleReview(ReviewOption.NULL_SUBMITTED_DATE_REVIEW);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

    @Test
    public void TestEmptyFeedbackReview() {
        testReview = reviewFactory.assembleReview(ReviewOption.EMPTY_FEEDBACK_REVIEW);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

    @Test
    public void TestNullFeedbackReview() {
        testReview = reviewFactory.assembleReview(ReviewOption.NULL_FEEDBACK_REVIEW);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

    @Test
    public void TestNullVersionReview() {
        testReview = reviewFactory.assembleReview(ReviewOption.NULL_VERSION_REVIEW);
        assertThereIsExactlyOneViolation(validator, testReview);
    }

}
