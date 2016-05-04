package assessment.entities.feedback;

import assessment.utilities.Constants;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Feedback {

    @NotEmpty(message = "question label is required")
    @Length(max = 255, message = "question label length must not exceed 255 " +
            "characters")
    private String label;

    @Range(min = 1, max = 5)
    private Integer score;

    @Length(max = 1500, message = "Comment length must not exceed 1,500 " +
            "characters")
    private String comment;

    @NotNull(message = "Version is required")
    @Range(min = 1, message = "version of at least 1 is required")
    private Integer version;

    public Feedback() {
        this.version = Constants.FEEDBACK_CURRENT_VERSION;
    }

    public Feedback(String label, Integer score, String
            comment) {
        this.label = label;
        this.score = score;
        this.comment = comment;
        this.version = Constants.FEEDBACK_CURRENT_VERSION;
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

    @Override
    public String toString() {
        return "Feedback{" +
                "label='" + label + '\'' +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", version=" + version +
                '}';
    }
}
