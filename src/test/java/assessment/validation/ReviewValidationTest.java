package assessment.validation;

import assessment.entities.question.Question;
import assessment.entities.review.Review;
import assessment.factories.question.QuestionFactory;
import assessment.factories.question.QuestionOption;
import assessment.factories.review.ReviewFactory;
import assessment.factories.review.ReviewOption;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Created by jtucker on 4/1/2016.
 */
public class ReviewValidationTest {

    private static Validator validator;
    private Review testReview;
    ReviewFactory reviewFactory = new ReviewFactory();

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

}
