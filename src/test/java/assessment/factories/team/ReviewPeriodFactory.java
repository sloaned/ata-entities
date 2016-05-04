package assessment.factories.team;

import assessment.entities.team.ReviewPeriod;
import assessment.testbase.TestBase;


/**
 * Created by mmosley on 4/29/2016.
 */
public class ReviewPeriodFactory extends TestBase {

    public ReviewPeriod assembleReviewPeriod(ReviewPeriodOption option) {

        ReviewPeriod reviewPeriod = new ReviewPeriod();

        switch (option) {
            case VALID_REVIEW_PERIOD:
                reviewPeriod.setName(generateRandomString(45));
                reviewPeriod.setFrequency(FREQUENCY_WEEK);
                reviewPeriod.setTemplateId(generateRandomString(10));
                reviewPeriod.setCurrentPeriodId(generateRandomString(10));
                break;

            case INVALID_REVIEW_PERIOD_NAME_EMPTY:
                reviewPeriod.setName(EMPTY_STRING);
                reviewPeriod.setFrequency(FREQUENCY_WEEK);
                reviewPeriod.setTemplateId(generateRandomString(10));
                reviewPeriod.setCurrentPeriodId(generateRandomString(10));
                break;

            case INVALID_REVIEW_PERIOD_NAME_SPECIAL_CHARACTERS:
                reviewPeriod.setName(INVALID_OBJECT_NAME_SPECIAL_CHARACTERS);
                reviewPeriod.setFrequency(FREQUENCY_WEEK);
                reviewPeriod.setTemplateId(generateRandomString(10));
                reviewPeriod.setCurrentPeriodId(generateRandomString(10));
                break;

            case INVALID_REVIEW_PERIOD_NAME_TOO_LONG:
                reviewPeriod.setName(generateRandomString(51));
                reviewPeriod.setFrequency(FREQUENCY_WEEK);
                reviewPeriod.setTemplateId(generateRandomString(10));
                reviewPeriod.setCurrentPeriodId(generateRandomString(10));
                break;

            case INVALID_REVIEW_PERIOD_FREQUENCY_NULL:
                reviewPeriod.setName(generateRandomString(50));
                reviewPeriod.setFrequency(null);
                reviewPeriod.setTemplateId(generateRandomString(10));
                reviewPeriod.setCurrentPeriodId(generateRandomString(10));
                break;

            case INVALID_REVIEW_PERIOD_TEMPLATE_ID_EMPTY:
                reviewPeriod.setName(generateRandomString(50));
                reviewPeriod.setFrequency(FREQUENCY_WEEK);
                reviewPeriod.setTemplateId(EMPTY_STRING);
                reviewPeriod.setCurrentPeriodId(generateRandomString(10));
                break;

            case INVALID_REVIEW_PERIOD_CURRENT_PERIOD_ID_EMPTY:
                reviewPeriod.setName(generateRandomString(50));
                reviewPeriod.setFrequency(FREQUENCY_WEEK);
                reviewPeriod.setTemplateId(generateRandomString(10));
                reviewPeriod.setCurrentPeriodId(EMPTY_STRING);
                break;

        }

        return reviewPeriod;
    }

}
