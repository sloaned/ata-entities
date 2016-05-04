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

    public Kudo assembleBaseKudo() {

		Kudo baseKudo = new Kudo();

		baseKudo.setReviewedId(VALID_REVIEWED_HASH);
		baseKudo.setReviewerId(VALID_REVIEWER_HASH);
		baseKudo.setComment(VALID_FEEDBACK_COMMENT);
		baseKudo.setSubmittedDate(new Date(System.currentTimeMillis() + DATE_OFFSET));
		baseKudo.setVersion(KUDO_CURRENT_VERSION);

		return baseKudo;

    }

    public Kudo assembleKudo(KudoOption kudoOption) {

        Kudo kudo = assembleBaseKudo();
		final String INVALID_COMMENT_LONG = generateRandomString(1501);

        switch (kudoOption) {

            case VALID_KUDO:
                break;

            case INVALID_KUDO_REVIEWER_NULL:
                kudo.setReviewerId(null);
                break;

            case INVALID_KUDO_REVIEWED_NULL:
                kudo.setReviewedId(null);
                break;

            case INVALID_KUDO_SELF_REVIEW:
                kudo.setReviewedId(VALID_REVIEWER_HASH);
                break;

            case INVALID_KUDO_COMMENT_LONG:
                kudo.setComment(INVALID_COMMENT_LONG);
                break;

            case INVALID_KUDO_DATE_NULL:
                kudo.setSubmittedDate(null);
                break;

            case INVALID_KUDO_DATE_PAST:
                kudo.setSubmittedDate(getDate(PAST_DATE));

            case INVALID_KUDO_VERSION_NULL:
                kudo.setVersion(null);
                break;

            case INVALID_KUDO_VERSION_0:
                kudo.setVersion(0);
                break;
        }

        return kudo;
    }
}
