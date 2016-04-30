package assessment.factories.template;

import assessment.entities.template.Template;
import assessment.testbase.TestBase;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alysha Recore on 4/1/2016.
 */
public class TemplateFactory extends TestBase {

    public Template assembleAssessment(TemplateOption templateOption) {

        Template template = new Template();
        Template template2 = new Template();
        switch(templateOption){

            case VALID_TEMPLATE:
                template.setName(VALID_OBJECT_NAME);
                template.setQuestionList(QUESTION_LIST);
                template.setVersion(TEMPLATE_CURRENT_VERSION);
                break;

            case INVALID_TEMPLATE_DUPLICATE:
                template.setName(TEMPLATE_NAME1);
                template.setQuestionList(QUESTION_LIST);
                template.setVersion(TEMPLATE_CURRENT_VERSION);
                template2.setName(TEMPLATE_NAME2);
                break;

            case INVALID_TEMPLATE_NAME_TOO_LONG:
                template.setName(generateRandomString(102));
                template.setQuestionList(QUESTION_LIST);
                template.setVersion(TEMPLATE_CURRENT_VERSION);
                break;

            case INVALID_TEMPLATE_NAME_SPECIAL_CHARACTERS:
                template.setName(INVALID_OBJECT_NAME_SPECIAL_CHARACTERS);
                template.setQuestionList(QUESTION_LIST);
                template.setVersion(TEMPLATE_CURRENT_VERSION);
                break;

            case INVALID_TEMPLATE_NULL_NAME:
                template.setName(null);
                template.setQuestionList(QUESTION_LIST);
                template.setVersion(TEMPLATE_CURRENT_VERSION);
                break;

            case INVALID_TEMPLATE_VERSION_ZERO:
                template.setName(VALID_OBJECT_NAME);
                template.setQuestionList(QUESTION_LIST);
                template.setVersion(0);
                break;

            case INVALID_TEMPLATE_VERSION_NULL:
                template.setName(VALID_OBJECT_NAME);
                template.setQuestionList(QUESTION_LIST);
                template.setVersion(null);
                break;
        }

        return template;
    }

    public List<Template> assembleAssessmentsAsList(TemplateOption option, int count) throws ParseException {

        List<Template> result = new ArrayList<Template>();

        for (int i = 0; i < count; i++) {
            result.add(assembleAssessment(option));
        }

        return result;
    }
}
