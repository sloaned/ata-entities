package assessment.factories.kudo;

import assessment.entities.kudo.Kudo;
import assessment.entities.user.User;
import assessment.factories.user.UserFactory;
import assessment.factories.user.UserOption;
import assessment.testbase.TestBase;

import java.util.Date;

/**
 * Created by hmccardell on 4/27/2016.
 */
public class KudoFactory extends TestBase {

    public Kudo assembleKudo(KudoOption kudoOption) {

        Kudo kudo = new Kudo();
        UserFactory userFactory = new UserFactory();
        User validReviewer = userFactory.assembleUser(UserOption.VALID_ACTIVE_DEVELOPER);
        validReviewer.setId(VALID_REVIEWER_HASH);
        final String INVALID_COMMENT_LONG = generateRandomString(1501);

        switch (kudoOption) {

            case VALID_KUDO:
                kudo.setReviewedId(VALID_REVIEWED_HASH);
                kudo.setReviewerId(VALID_REVIEWER_HASH);
                kudo.setComment(VALID_FEEDBACK_COMMENT);
                kudo.setSubmittedDate(new Date(System.currentTimeMillis() + DATE_OFFSET));
                kudo.setVersion(KUDO_CURRENT_VERSION);
                break;

            case INVALID_KUDO_REVIEWER_NULL:
                kudo.setReviewedId(VALID_REVIEWED_HASH);
                kudo.setReviewerId(null);
                kudo.setComment(VALID_FEEDBACK_COMMENT);
                kudo.setSubmittedDate(new Date(System.currentTimeMillis() + DATE_OFFSET));
                kudo.setVersion(KUDO_CURRENT_VERSION);
                break;

            case INVALID_KUDO_REVIEWED_NULL:
                kudo.setReviewedId(null);
                kudo.setReviewerId(VALID_REVIEWER_HASH);
                kudo.setComment(VALID_FEEDBACK_COMMENT);
                kudo.setSubmittedDate(new Date(System.currentTimeMillis() + DATE_OFFSET));
                kudo.setVersion(KUDO_CURRENT_VERSION);
                break;

            case INVALID_KUDO_SELF_REVIEW:
                kudo.setReviewedId(VALID_REVIEWER_HASH);
                kudo.setReviewerId(VALID_REVIEWER_HASH);
                kudo.setComment(VALID_FEEDBACK_COMMENT);
                kudo.setSubmittedDate(new Date(System.currentTimeMillis() + DATE_OFFSET));
                break;

            case INVALID_KUDO_COMMENT_LONG:
                kudo.setReviewedId(VALID_REVIEWED_HASH);
                kudo.setReviewerId(VALID_REVIEWER_HASH);
                kudo.setComment(INVALID_COMMENT_LONG);
                kudo.setSubmittedDate(new Date(System.currentTimeMillis() + DATE_OFFSET));
                kudo.setVersion(KUDO_CURRENT_VERSION);
                break;

            case INVALID_KUDO_DATE_NULL:
                kudo.setReviewedId(VALID_REVIEWED_HASH);
                kudo.setReviewerId(VALID_REVIEWER_HASH);
                kudo.setComment(VALID_FEEDBACK_COMMENT);
                kudo.setSubmittedDate(null);
                kudo.setVersion(KUDO_CURRENT_VERSION);
                break;

            case INVALID_KUDO_DATE_PAST:
                kudo.setReviewedId(VALID_REVIEWED_HASH);
                kudo.setReviewerId(VALID_REVIEWER_HASH);
                kudo.setComment(VALID_FEEDBACK_COMMENT);
                kudo.setSubmittedDate(getDate(PAST_DATE));
                kudo.setVersion(KUDO_CURRENT_VERSION);

            case INVALID_KUDO_VERSION_NULL:
                kudo.setReviewedId(VALID_REVIEWED_HASH);
                kudo.setReviewerId(VALID_REVIEWER_HASH);
                kudo.setComment(VALID_FEEDBACK_COMMENT);
                kudo.setSubmittedDate(new Date(System.currentTimeMillis() + DATE_OFFSET));
                kudo.setVersion(null);
                break;

            case INVALID_KUDO_VERSION_0:
                kudo.setReviewedId(VALID_REVIEWED_HASH);
                kudo.setReviewerId(VALID_REVIEWER_HASH);
                kudo.setComment(VALID_FEEDBACK_COMMENT);
                kudo.setSubmittedDate(new Date(System.currentTimeMillis() + DATE_OFFSET));
                kudo.setVersion(0);
                break;
        }

        return kudo;
    }
}
