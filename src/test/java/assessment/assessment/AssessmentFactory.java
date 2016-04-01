package assessment.assessment;

import assessment.entities.assessment.Assessment;
import assessment.testbase.TestBase;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alysha Recore on 4/1/2016.
 */
public class AssessmentFactory extends TestBase {

    public Assessment assembleAssessment(AssessmentOption assessmentOption) {

        Assessment assessment = new Assessment();

        switch(assessmentOption){

            case VALID_ASSESSMENT:
                assessment.setName(VALID_OBJECT_NAME);
                assessment.setQuestionList(QUESTION_LIST);
                assessment.setVersion(VALID_ENTITY_VERSION);
                break;

            case BAD_ASSESSMENT_LONG_NAME:
                assessment.setName(generateRandomString(102));
                assessment.setVersion(VALID_ENTITY_VERSION);
                break;

            case BAD_ASSESSMENT_BAD_NAME:
                assessment.setName(BAD_OBJECT_NAME);
                assessment.setVersion(VALID_ENTITY_VERSION);
                break;

            case BAD_ASSESSMENT_NULL_NAME:
                assessment.setVersion(VALID_ENTITY_VERSION);
                break;

            case BAD_ASSESSMENT_NULL_VERSION:
                assessment.setName(VALID_OBJECT_NAME);
                break;
        }

        return assessment;
    }

    public List<Assessment> assembleAssessmentsAsList(AssessmentOption option, int count) throws ParseException {

        List<Assessment> result = new ArrayList<Assessment>();

        for (int i = 0; i < count; i++) {
            result.add(assembleAssessment(option));
        }

        return result;
    }
}
