package assessment.entities.template;

import assessment.entities.question.Question;
import assessment.testbase.TestBaseConstants;
import assessment.utilities.RegexConstants;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Template {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotEmpty(message = "Template name is required")
    @Length(max = 100, message = "Template name can be no longer than 100 characters.")
    @Pattern(regexp = RegexConstants.OBJECT_NAME, message = "Template name contains invalid characters.")
    private String name;

    private List<Question> questionList;

    @NotNull(message = "Version is required")
    @Range(min = 1, message = "version of at least 1 is required")
    private Integer version;

    public Template() { this.version = TestBaseConstants.TEMPLATE_CURRENT_VERSION; }

    public Template(String name, List<Question> questionList) {
        this.name = name;
        this.questionList = questionList;
    }

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Template{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", questionList=" + questionList +
                ", version=" + version +
                '}';
    }
}
