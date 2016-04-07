package assessment.entities.feedback;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Feedback {

    @NotNull(message = "question type is required")
    @Enumerated(EnumType.STRING)
    private FeedbackType type;

    @Length(max = 255, message = "question label length must not exceed 255 " +
            "characters")
    @NotEmpty(message = "question label is required")
    private String label;

    @Range(min = 1, max = 5)
    private Integer score;

    @Length(max = 1500, message = "Comment length must not exceed 1,500 " +
            "characters")
    private String comment;

    @NotNull(message = "Version is required")
    private Integer version;

    public Feedback() {}

    public Feedback(FeedbackType type, String label, Integer score, String
            comment, Integer version) {
        this.type = type;
        this.label = label;
        this.score = score;
        this.comment = comment;
        this.version = version;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "type=" + type +
                ", label='" + label + '\'' +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", version=" + version +
                '}';
    }

    public FeedbackType getType() {
        return type;
    }

    public void setType(FeedbackType type) {
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
