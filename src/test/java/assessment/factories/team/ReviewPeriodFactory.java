package assessment.factories.team;

import assessment.entities.team.ReviewPeriod;
import assessment.testbase.TestBase;


/**
 * Created by mmosley on 4/29/2016.
 */
public class ReviewPeriodFactory extends TestBase {

    private ReviewPeriod assembleBaseReviewPeriod() {

		ReviewPeriod baseReviewPeriod = new ReviewPeriod();

		baseReviewPeriod.setName(generateRandomString(45));
		baseReviewPeriod.setFrequency(FREQUENCY_WEEK);
		baseReviewPeriod.setTemplateId(generateRandomString(10));
		baseReviewPeriod.setCurrentPeriodId(generateRandomString(10));

		return baseReviewPeriod;

    }

    public ReviewPeriod assembleReviewPeriod(ReviewPeriodOption option) {

        ReviewPeriod reviewPeriod = assembleBaseReviewPeriod();

        switch (option) {
            case VALID_REVIEW_PERIOD:
                break;

            case INVALID_REVIEW_PERIOD_NAME_EMPTY:
                reviewPeriod.setName(EMPTY_STRING);
                break;

            case INVALID_REVIEW_PERIOD_NAME_SPECIAL_CHARACTERS:
                reviewPeriod.setName(INVALID_OBJECT_NAME_SPECIAL_CHARACTERS);
                break;

            case INVALID_REVIEW_PERIOD_NAME_TOO_LONG:
                reviewPeriod.setName(generateRandomString(51));
                break;

            case INVALID_REVIEW_PERIOD_FREQUENCY_NULL:
                reviewPeriod.setFrequency(null);
                break;

            case INVALID_REVIEW_PERIOD_TEMPLATE_ID_EMPTY:
                reviewPeriod.setTemplateId(EMPTY_STRING);
                break;

            case INVALID_REVIEW_PERIOD_CURRENT_PERIOD_ID_EMPTY:
                reviewPeriod.setCurrentPeriodId(EMPTY_STRING);
                break;

        }

        return reviewPeriod;
    }

}
