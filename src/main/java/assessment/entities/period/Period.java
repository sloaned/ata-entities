package assessment.entities.period;

import assessment.entities.review.Review;
import assessment.entities.template.Template;
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

    @NotNull
    private Template template;

    @NotNull(message = "Series number cannot be null")
    @Range(min = 1, message = "Series number of at least 1 is required")
    private Integer seriesNumber;

    @NotEmpty(message = "Period name cannot be empty")
    @Length(max = 100, message = "Period name can be no longer than 100 characters.")
    @Pattern(regexp = RegexConstants.OBJECT_NAME, message = "Period name contains invalid characters.")
    private String name;

    @NotEmpty(message = "Team id cannot be empty")
    private String teamId;

    @NotNull(message = "Date triggered cannot be null")
    private Date dateTriggered;

    @Range(min = 1, max = 5)
    private Double summaryScore;

    private List<Review> reviews;

    @NotNull(message = "Version cannot be null")
    @Range(min = 1, message = "version of at least 1 is required")
    private Integer version;

    public Period() {
        version = TestBaseConstants.PERIOD_CURRENT_VERSION;
    }

    public Period(Template template, String name, Integer seriesNumber, String teamId, Date dateTriggered, Double summaryScore, List<Review> reviews, Integer version) {
        this.template = template;
        this.seriesNumber = seriesNumber;
        this.name = name;
        this.teamId = teamId;
        this.dateTriggered = dateTriggered;
        this.summaryScore = summaryScore;
        this.reviews = reviews;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
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

    public void setName(String name) { this.name = name; }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
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

    @Override
    public String toString() {
        return "Period{" +
                "id='" + id + '\'' +
                ", template=" + template +
                ", name='" + name + '\'' +
                ", seriesNumber=" + seriesNumber +
                ", teamId='" + teamId + '\'' +
                ", dateTriggered=" + dateTriggered +
                ", summaryScore=" + summaryScore +
                ", reviews=" + reviews +
                ", version=" + version +
                '}';
    }
}
