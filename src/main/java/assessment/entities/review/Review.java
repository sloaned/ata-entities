package assessment.entities.review;

import assessment.entities.feedback.Feedback;
import assessment.utilities.Constants;
import assessment.utilities.RegexConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

/**
 * Created by Alysha Recore on 3/28/2016.
 */
public class Review {

    @Id
    private String id;

    @NotEmpty(message = "Reviewer must be defined.")
    private String reviewerId;

    @NotEmpty(message = "Reviewee must be defined.")
    private String reviewedId;

    @JsonFormat(pattern = "MM/dd/yyyy", timezone = "PST")
    @NotNull(message = "Submitted date is required")
    @Future(message = "Submitted date cannot be in the past")
    private Date submittedDate;

    @NotEmpty(message = "At least one Feedback object is required")
    private List<Feedback> feedback;

    @Range(min = 1, max = 5)
    private Double summaryScore;

    @NotEmpty(message = "Team name is required.")
    @Length(max = 100, message = "Team name can be no longer than 100 characters.")
    @Pattern(regexp = RegexConstants.OBJECT_NAME, message = "Team name contains invalid characters.")
    private String teamName;

    @NotNull(message = "Version is required")
    @Range(min = 1, message = "version of at least 1 is required")
    private Integer version;

    @AssertTrue(message = "Reviewer and reviewee cannot be the same user")
    private boolean isValid() {
        boolean result = true;

        /**
         * User ids cannot be checked if Users are empty; if either id is empty
         * there is no need to validate
         */
        if (reviewerId != null && reviewedId != null) {
            if (reviewerId != null && reviewedId != null) {
                result = !this.reviewerId.equals(this.reviewedId);
            }
        }

        return result;
    }

    /**
     * Default constructor
     */
    public Review() {
        this.version = Constants.REVIEW_CURRENT_VERSION;
    }

    /**
     * Constructor with parameters
     *
     * @param reviewerId
     * @param reviewedId
     * @param submittedDate
     * @param feedback
     * @param summaryScore
     */
    public Review(String reviewerId, String reviewedId, Date submittedDate, List<Feedback> feedback,
                  Double summaryScore, String teamName) {
        this.reviewerId = reviewerId;
        this.reviewedId = reviewedId;
        this.submittedDate = submittedDate;
        this.feedback = feedback;
        this.summaryScore = summaryScore;
        this.teamName = teamName;
        this.version = Constants.REVIEW_CURRENT_VERSION;
    }

    /**
     * Getters and Setters
     */
    public String getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId;
    }

    public String getReviewedId() {
        return reviewedId;
    }

    public void setReviewedId(String reviewedId) {
        this.reviewedId = reviewedId;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public List<Feedback> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<Feedback> feedback) {
        this.feedback = feedback;
    }

    public Double getSummaryScore() {
        return summaryScore;
    }

    public void setSummaryScore(Double summaryScore) {
        this.summaryScore = summaryScore;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", reviewerId=" + reviewerId +
                ", reviewedId=" + reviewedId +
                ", submittedDate=" + submittedDate +
                ", feedback=" + feedback +
                ", summaryScore=" + summaryScore +
                ", teamName=" + teamName +
                ", version=" + version +
                '}';
    }
}
