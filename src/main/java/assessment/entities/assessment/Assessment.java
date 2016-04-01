package assessment.entities.assessment;

import assessment.entities.question.Question;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import java.util.List;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Assessment {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotEmpty(message = "assessment name is required")
    private String name;

    private List<Question> questionList;

    @NotEmpty(message = "Version is required")
    private Integer version;

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
