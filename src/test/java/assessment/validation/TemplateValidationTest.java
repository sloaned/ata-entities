package assessment.validation;

import assessment.factories.template.TemplateFactory;
import assessment.factories.template.TemplateOption;
import assessment.entities.template.Template;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.text.ParseException;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alysha Recore on 4/1/2016.
 */
public class TemplateValidationTest {

    private static Validator validator;
    private Template testTemplate;
    TemplateFactory templateFactory = new TemplateFactory();

    private void assertThereIsExactlyOneViolation(Validator validator, Template template) {
        Set<ConstraintViolation<Template>> violations = validator.validate(template);
        assertFalse("VALID Template: the template factory assembled an template that passes entity validation", violations.isEmpty());
        assertFalse("INVALID Template: the template factory assembled an template that failed multiple validations", violations.size() > 1);
    }

    @BeforeClass
    public static void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void HappyPathTemplateValidation() {
        testTemplate = templateFactory.assembleTemplate(TemplateOption.VALID_TEMPLATE);
        Set<ConstraintViolation<Template>> violations = validator.validate(testTemplate);
        assertTrue("INVALID Template: the template factory assembled an template that doesn't " +
                "pass entity validation", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfTemplateFactoryBadTemplateLongName() {
        testTemplate = templateFactory.assembleTemplate(TemplateOption.INVALID_TEMPLATE_NAME_TOO_LONG);
        assertThereIsExactlyOneViolation(validator, testTemplate);
    }

    @Test
    public void SadPathValidationOfTemplateFactoryBadTemplateBadName() {
        testTemplate = templateFactory.assembleTemplate(TemplateOption.INVALID_TEMPLATE_NAME_SPECIAL_CHARACTERS);
        assertThereIsExactlyOneViolation(validator, testTemplate);
    }

    @Test
    public void SadPathValidationOfTemplateFactoryBadTemplateNullName() {
        testTemplate = templateFactory.assembleTemplate(TemplateOption.INVALID_TEMPLATE_NULL_NAME);
        assertThereIsExactlyOneViolation(validator, testTemplate);
    }

    @Test
    public void SadPathValidationOfTemplateFactoryVersionZero() throws ParseException {
        testTemplate = templateFactory.assembleTemplate(TemplateOption.INVALID_TEMPLATE_VERSION_ZERO);
        Set<ConstraintViolation<Template>> violations = validator.validate(testTemplate);
        assertFalse("expected version 0", violations.isEmpty());
    }

    @Test
    public void SadPathValidationOfTemplateFactoryNullVersion() throws ParseException{
        testTemplate = templateFactory.assembleTemplate(TemplateOption.INVALID_TEMPLATE_VERSION_NULL);
        Set<ConstraintViolation<Template>> violations = validator.validate(testTemplate);
        assertFalse("expected version null", violations.isEmpty());
    }


}
