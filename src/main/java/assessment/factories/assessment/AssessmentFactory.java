package assessment.factories.assessment;

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
                assessment.setVersion(ASSESSMENT_CURRENT_VERSION);
                break;

            case INVALID_ASSESSMENT_NAME_LONG:
                assessment.setName(generateRandomString(102));
                assessment.setQuestionList(QUESTION_LIST);
                assessment.setVersion(ASSESSMENT_CURRENT_VERSION);
                break;

            case INVALID_ASSESSMENT_NAME_SPECIAL_CHARACTERS:
                assessment.setName(INVALID_OBJECT_NAME_SPECIAL_CHARACTERS);
                assessment.setQuestionList(QUESTION_LIST);
                assessment.setVersion(ASSESSMENT_CURRENT_VERSION);
                break;

            case INVALID_ASSESSMENT_NULL_NAME:
                assessment.setName(null);
                assessment.setQuestionList(QUESTION_LIST);
                assessment.setVersion(ASSESSMENT_CURRENT_VERSION);
                break;

            case INVALID_ASSESSMENT_VERSION_ZERO:
                assessment.setName(VALID_OBJECT_NAME);
                assessment.setQuestionList(QUESTION_LIST);
                assessment.setVersion(0);
                break;

            case INVALID_ASSESSMENT_VERSION_NULL:
                assessment.setName(VALID_OBJECT_NAME);
                assessment.setQuestionList(QUESTION_LIST);
                assessment.setVersion(null);
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
