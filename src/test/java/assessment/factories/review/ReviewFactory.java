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

    public Review assembleReview(ReviewOption reviewOption) {

        Review review = new Review();

        switch(reviewOption){

            case VALID_REVIEW:
                UserFactory userFactory = new UserFactory();
                User reviewer = userFactory.assembleUser(UserOption.VALID_ACTIVE_DEVELOPER);
                User reviewed = userFactory.assembleUser(UserOption.VALID_INACTIVE_DEVELOPER);

                review.setReviewerId(reviewer);
                review.setReviewedId(reviewed);
                review.setTeamName(VALID_TEAM_NAME);
                review.setSubmittedDate(new Date());

                Feedback feedback1 = new Feedback();
                List<Feedback> feedback = new ArrayList<Feedback>();
                feedback.add(feedback1);

                review.setFeedback(feedback);
                review.setSummaryScore(VALID_SUMMARY_SCORE);
                review.setVersion(VALID_ENTITY_VERSION);
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
