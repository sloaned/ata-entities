package assessment.entities.feedback;

import assessment.entities.question.QuestionType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Feedback {

    @NotNull(message = "Question type is required")
    private QuestionType type;

    @Length(max = 255, message = "Question label length must not exceed 255 " +
            "characters")
    @NotEmpty(message = "Question label is required")
    private String label;

    @Range(min = 1, max = 5)
    private Integer score;

    @Length(max = 1500, message = "Comment length must not exceed 1,500 " +
            "characters")
    private String comment;

    @NotNull(message = "Version is required")
    private Integer version;

    public Feedback(QuestionType type, String label, Integer score, String
            comment, Integer version) {
        this.type = type;
        this.label = label;
        this.score = score;
        this.comment = comment;
        this.version = version;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}