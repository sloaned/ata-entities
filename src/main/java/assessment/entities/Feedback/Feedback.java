package assessment.entities.Feedback;

import assessment.entities.Team.Team;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Feedback {

    @Id
    private String id;

    private String version;

    @Range(min=1,max=5)
    private Integer value;

    private String comment;

    @Email
    private String reviewedEmail;

    @Email
    private String reviewerEmail;

    private String label;

    @DBRef
    private Team teamId;

    public Feedback() {}

    public Feedback(String version, Integer value, String comment, String reviewedEmail, String reviewerEmail, String label, Team teamId) {
        this.version = version;
        this.value = value;
        this.comment = comment;
        this.reviewedEmail = reviewedEmail;
        this.reviewerEmail = reviewerEmail;
        this.label = label;
        this.teamId = teamId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getReviewed() {
        return reviewedEmail;
    }

    public void setReviewed(String reviewed) {
        this.reviewedEmail = reviewed;
    }

    public String getReviewer() {
        return reviewerEmail;
    }

    public void setReviewer(String reviewerEmail) {
        this.reviewerEmail = reviewerEmail;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }
}
