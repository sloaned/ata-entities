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

    private Template assembleBaseTemplate() {

		Template baseTemplate = new Template();

		baseTemplate.setName(VALID_OBJECT_NAME);
		baseTemplate.setQuestionList(QUESTION_LIST);
		baseTemplate.setVersion(TEMPLATE_CURRENT_VERSION);

		return baseTemplate;

    }

    public Template assembleTemplate(TemplateOption templateOption) {

        Template template = assembleBaseTemplate();
        Template template2 = new Template();

        switch(templateOption){

            case VALID_TEMPLATE:
                break;

            case INVALID_TEMPLATE_DUPLICATE:
                template.setName(TEMPLATE_NAME1);
                template2.setName(TEMPLATE_NAME2);
                break;

            case INVALID_TEMPLATE_NAME_TOO_LONG:
                template.setName(generateRandomString(102));
                break;

            case INVALID_TEMPLATE_NAME_SPECIAL_CHARACTERS:
                template.setName(INVALID_OBJECT_NAME_SPECIAL_CHARACTERS);
                break;

            case INVALID_TEMPLATE_NULL_NAME:
                template.setName(null);
                break;

            case INVALID_TEMPLATE_VERSION_ZERO:
                template.setVersion(0);
                break;

            case INVALID_TEMPLATE_VERSION_NULL:
                template.setVersion(null);
                break;
        }

        return template;
    }

    public List<Template> assembleTemplatesAsList(TemplateOption option, int count) throws ParseException {

        List<Template> result = new ArrayList<Template>();

        for (int i = 0; i < count; i++) {
            result.add(assembleTemplate(option));
        }

        return result;
    }
}
