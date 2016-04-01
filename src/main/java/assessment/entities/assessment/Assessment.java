package assessment.entities.assessment;

import assessment.entities.question.Question;
import assessment.utilities.RegexConstants;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Assessment {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotEmpty(message = "Assessment name is required")
    @Length(max = 100, message = "Assessment name can be no longer than 100 characters.")
    @Pattern(regexp = RegexConstants.OBJECT_NAME, message = "Assessment name contains invalid characters.")
    private String name;

    private List<Question> questionList;

    @NotNull(message = "Version is required")
    private Integer version;

    public Assessment(){};

    public Assessment(String id, String name, List<Question> questionList,
                      Integer version) {
        this.id = id;
        this.name = name;
        this.questionList = questionList;
        this.version = version;
    }

    public String getId() {
        return id;
    }

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
}