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

    public Question assembleBaseQuestion() {

		Question baseQuestion = new Question();

		baseQuestion.setType(QUESTION_TYPE_BOOLEAN);
		baseQuestion.setLabel(VALID_QUESTION_LABEL_QUANTITATIVE);
		baseQuestion.setVersion(QUESTION_CURRENT_VERSION);

		return baseQuestion;

    }

    public Question assembleQuestion(QuestionOption questionOption) {

        Question question = assembleBaseQuestion();

        switch(questionOption){

            case VALID_BOOLEAN_QUESTION:
                break;

            case VALID_MULTIPLE_CHOICE_QUESTION:
                question.setType(QUESTION_TYPE_MULTIPLE_CHOICE);
                break;

            case VALID_COMPETENCY_QUESTION:
                question.setType(QUESTION_TYPE_COMPETENCY);
                break;

            case INVALID_QUESTION_TYPE_NULL:
				question.setType(null);
                break;

            case INVALID_QUESTION_LABEL_LONG:
                question.setLabel(generateRandomString(256));
                break;

            case INVALID_QUESTION_LABEL_EMPTY:
                question.setLabel("");
                break;

            case INVALID_QUESTION_LABEL_NULL:
				question.setLabel(null);
                break;

            case INVALID_QUESTION_VERSION_NULL:
                question.setVersion(null);
                break;

            case INVALID_QUESTION_VERSION_ZERO:
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
