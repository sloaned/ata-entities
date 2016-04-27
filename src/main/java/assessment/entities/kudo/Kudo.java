package assessment.entities.kudo;

import assessment.testbase.TestBaseConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Kudo {

    @Id
    private String id;

    @NotNull(message = "Reviewer must be defined.")
    private String reviewerId;

    @NotNull(message = "Reviewee must be defined.")
    private String reviewedId;

    @Length(max = 1500, message = "Comment length must not exceed 1,500 " +
            "characters")
    private String comment;

    @JsonFormat(pattern = "MM/dd/yyyy", timezone="PST")
    @NotNull(message = "Submitted date is required")
    @Future(message = "Submitted date cannot be in the past")
    private Date submittedDate;

    @NotNull(message = "Version is required")
    @Range(min = 1, message = "version of at least 1 is required")
    private Integer version;

    public Kudo() {
        this.version = TestBaseConstants.KUDO_CURRENT_VERSION;
    }

    public Kudo(Integer version, String reviewerId, String reviewedId, String comment, Date submittedDate) {
        this.version = version;
        this.reviewerId = reviewerId;
        this.reviewedId = reviewedId;
        this.comment = comment;
        this.submittedDate = submittedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId;
    }

    public void setReviewedId(String reviewedId) {
        this.reviewedId = reviewedId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getReviewerId() {
        return reviewerId;
    }

    public String getReviewedId() {
        return reviewedId;
    }

    public String getComment() {
        return comment;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public Integer getVersion() {
        return version;
    }

}
