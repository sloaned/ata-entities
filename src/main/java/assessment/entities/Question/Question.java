package assessment.entities.Question;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Question {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private QuestionType type;


    @Length(max = 255, message = "Question label length must not exceed 255 " +
            "characters")
    @NotEmpty(message = "Question label is required")
    private String label;

    @NotEmpty(message = "Version is required")
    private Integer version;

    public Question(Integer version, String id, QuestionType type, String
            label) {
        this.version = version;
        this.id = id;
        this.type = type;
        this.label = label;
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
