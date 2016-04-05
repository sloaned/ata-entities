package assessment.entities.review;

import assessment.entities.feedback.Feedback;
import assessment.entities.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import java.util.Date;
import java.util.List;

/**
 * Created by Alysha Recore on 3/28/2016.
 */
public class Review {

    @Id
    private String id;

    @DBRef
    @NotNull(message = "Reviewer must be defined.")
    private User reviewerId;

    @DBRef
    @NotNull(message = "Reviewee must be defined.")
    private User reviewedId;

    @NotEmpty(message = "Reviewee's associated team must be defined.")
    private String teamName;

    @JsonFormat(pattern = "MM/dd/yyyy", timezone="PST")
    @NotNull(message = "Submitted date is required")
    @Past(message = "Submitted date cannot be in the past")
    private Date submittedDate;

    @NotEmpty(message = "At least one Feedback object is required")
    private List<Feedback> feedback;

    @Range(min = 1, max = 5)
    private Double summaryScore;

    @NotNull(message = "Version is required")
    private Integer version;

    @AssertTrue(message = "Reviewer and reviewee cannot be the same user")
    private boolean isValid() {
        boolean result = true;

        if (reviewerId != null && reviewedId != null) {
            if (reviewerId.getId() != null && reviewedId.getId() != null) {
                result = !this.reviewerId.getId().equals(this.reviewedId.getId());
            }
        }

        return result;
    }

    /**
     * Default constructor
     */
    public Review() {}

    /**
     * Constructor with parameters
     * @param reviewerId
     * @param reviewedId
     * @param teamName
     * @param submittedDate
     * @param feedback
     * @param summaryScore
     * @param version
     */
    public Review(User reviewerId, User reviewedId, String teamName, Date submittedDate, List<Feedback> feedback,
                  Double summaryScore, Integer version){
        this.reviewerId = reviewerId;
        this.reviewedId = reviewedId;
        this.teamName = teamName;
        this.submittedDate = submittedDate;
        this.feedback = feedback;
        this.summaryScore = summaryScore;
        this.version = version;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", reviewerId=" + reviewerId +
                ", reviewedId=" + reviewedId +
                ", teamName='" + teamName + '\'' +
                ", submittedDate=" + submittedDate +
                ", feedback=" + feedback +
                ", summaryScore=" + summaryScore +
                ", version=" + version +
                '}';
    }

    /**
     * Getters and Setters
     */
    public User getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(User reviewerId) {
        this.reviewerId = reviewerId;
    }

    public User getReviewedId() {
        return reviewedId;
    }

    public void setReviewedId(User reviewedId) {
        this.reviewedId = reviewedId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
