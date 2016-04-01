package assessment.factories.review;

import assessment.entities.review.Review;
import assessment.testbase.TestBase;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jtucker on 4/1/2016.
 */
public class ReviewFactory extends TestBase{

    public Review assembleReview(ReviewOption reviewOption) {

        Review review = new Review();

        switch(reviewOption){

            case VALID_REVIEW:
                break;
        }

        return review;
    }

    public List<Review> assembleReviewsAsList(ReviewOption option, int count) throws ParseException {

        List<Review> result = new ArrayList<Review>();

        for (int i = 0; i < count; i++) {
            result.add(assembleReview(option));
        }

        return result;
    }

}
