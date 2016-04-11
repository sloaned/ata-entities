package assessment.factories.question;


import assessment.entities.question.Question;
import assessment.testbase.TestBase;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jtucker on 3/31/2016.
 */
public class QuestionFactory extends TestBase {

    public Question assembleQuestion(QuestionOption questionOption) {

        Question question = new Question();

        switch(questionOption){

            case VALID_BOOLEAN_QUESTION:
                question.setType(QUESTION_TYPE_BOOLEAN);
                question.setLabel(VALID_QUESTION_LABEL_QUANTITATIVE);
                question.setVersion(QUESTION_CURRENT_VERSION);
                break;

            case VALID_MULTIPLE_CHOICE_QUESTION:
                question.setType(QUESTION_TYPE_MULTIPLE_CHOICE);
                question.setLabel(VALID_QUESTION_LABEL_QUALITATIVE);
                question.setVersion(QUESTION_CURRENT_VERSION);
                break;

            case VALID_COMPETENCY_QUESTION:
                question.setType(QUESTION_TYPE_COMPETENCY);
                question.setLabel(VALID_QUESTION_LABEL_QUALITATIVE);
                question.setVersion(QUESTION_CURRENT_VERSION);
                break;

            case INVALID_QUESTION_TYPE_NULL:
                question.setLabel(VALID_QUESTION_LABEL_QUANTITATIVE);
                question.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_QUESTION_LABEL_LONG:
                question.setType(QUESTION_TYPE_BOOLEAN);
                question.setLabel(generateRandomString(256));
                question.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_QUESTION_LABEL_EMPTY:
                question.setType(QUESTION_TYPE_BOOLEAN);
                question.setLabel("");
                question.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_QUESTION_LABEL_NULL:
                question.setType(QUESTION_TYPE_BOOLEAN);
                question.setVersion(VALID_ENTITY_VERSION);
                break;

            case INVALID_QUESTION_VERSION_NULL:
                question.setType(QUESTION_TYPE_BOOLEAN);
                question.setLabel(VALID_QUESTION_LABEL_QUANTITATIVE);
                question.setVersion(null);
                break;

            case INVALID_QUESTION_VERSION_ZERO:
                question.setType(QUESTION_TYPE_BOOLEAN);
                question.setLabel(VALID_QUESTION_LABEL_QUANTITATIVE);
                question.setVersion(0);
                break;
        }

        return question;
    }

    public List<Question> assembleQuestionsAsList(QuestionOption option, int count) throws ParseException {

        List<Question> result = new ArrayList<Question>();

        for (int i = 0; i < count; i++) {
            result.add(assembleQuestion(option));
        }

        return result;
    }

}
