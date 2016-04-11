package assessment.entities.question;

import assessment.testbase.TestBaseConstants;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Question {

    @Id
    private String id;

    @NotNull(message = "Question type is required")
    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @Length(max = 255, message = "Question label length must not exceed 255 " +
            "characters")
    @NotEmpty(message = "Question label is required")
    private String label;

    @NotNull(message = "Version is required")
    @Range(min = 1, message = "version of at least 1 is required")
    private Integer version;

    public Question() {
        this.version = TestBaseConstants.QUESTION_CURRENT_VERSION;
    }

    public Question(String id, QuestionType type, String
            label) {
        this.id = id;
        this.type = type;
        this.label = label;
        this.version = TestBaseConstants.QUESTION_CURRENT_VERSION;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", label='" + label + '\'' +
                ", version=" + version +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
