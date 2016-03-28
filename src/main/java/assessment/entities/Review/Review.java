package assessment.entities.Review;

import assessment.entities.Feedback.Feedback;
import assessment.entities.User.User;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
import java.util.List;

/**
 * Created by Alysha Recore on 3/28/2016.
 */
public class Review {

    //Verify that these are for sure refs instead of storing the whole object.
    @DBRef
    @NotEmpty(message = "Reviewer must be defined.")
    private User reviewerId;

    //Verify that these are for sure refs instead of storing the whole object.
    @DBRef
    @NotEmpty(message = "Reviewee must be defined.")
    private User reviewedId;

    @NotEmpty(message = "Reviewee's associated team must be defined.")
    private String teamName;

    @NotEmpty
    private Date submittedDate;

    @NotEmpty
    private List<Feedback> feedback;

    private Integer summaryScore;

    @NotEmpty(message = "Version is required")
    private Integer version;

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
                  Integer summaryScore, Integer version){
        this.reviewerId = reviewerId;
        this.reviewedId = reviewedId;
        this.teamName = teamName;
        this.submittedDate = submittedDate;
        this.feedback = feedback;
        this.summaryScore = summaryScore;
        this.version = version;
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

    public Integer getSummaryScore() {
        return summaryScore;
    }

    public void setSummaryScore(Integer summaryScore) {
        this.summaryScore = summaryScore;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
