package assessment.entities.period;

import assessment.entities.review.Review;
import assessment.testbase.TestBaseConstants;
import assessment.utilities.RegexConstants;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

public class Period {

    @Id
    private String id;

    @NotEmpty(message = "Assessment ID cannot be empty")
    private String assessmentId;

    @NotNull(message = "Series number cannot be null")
    @Range(min = 1, message = "Series number of at least 1 is required")
    private Integer seriesNumber;

    @NotEmpty(message = "Period name cannot be empty")
    @Length(max = 100, message = "Period name can be no longer than 100 characters.")
    @Pattern(regexp = RegexConstants.OBJECT_NAME, message = "Period name contains invalid characters.")
    private String name;

    @NotEmpty(message = "Team name cannot be empty")
    @Length(max = 100, message = "Team name can be no longer than 100 characters.")
    @Pattern(regexp = RegexConstants.OBJECT_NAME, message = "Team name contains invalid characters.")
    private String teamName;

    @NotNull(message = "Date triggered cannot be null")
    private Date dateTriggered;

    private Double summaryScore;

    private List<Review> reviews;

    @NotNull(message = "Version cannot be null")
    @Range(min = 1, message = "version of at least 1 is required")
    private Integer version;

    public Period() {
        version = TestBaseConstants.PERIOD_CURRENT_VERSION;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
    }

    public Integer getSeriesNumber() {
        return seriesNumber;
    }

    public void setSeriesNumber(Integer seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Date getDateTriggered() {
        return dateTriggered;
    }

    public void setDateTriggered(Date dateTriggered) {
        this.dateTriggered = dateTriggered;
    }

    public Double getSummaryScore() {
        return summaryScore;
    }

    public void setSummaryScore(Double summaryScore) {
        this.summaryScore = summaryScore;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
