package assessment.entities.team;

import assessment.testbase.TestBaseConstants;
import assessment.utilities.RegexConstants;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Team {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotEmpty(message = "Team name is required.")
    @Length(max = 100, message = "Team name can be no longer than 100 characters.")
    @Pattern(regexp = RegexConstants.OBJECT_NAME, message = "Team name contains invalid characters.")
    private String name;

    @NotNull(message = "The team must be active or inactive")
    private Boolean isActive;

    private List<Member> memberList;

    private String avatar;

    @Length(max = 255, message = "Team description length must not exceed " +
            "255 characters.")
    private String description;

    private List<ReviewPeriod> reviewPeriods;

    @Range(min = 1, max = 5)
    private Double summaryScore;

    @NotNull(message = "Version is required")
    @Range(min = 1, message = "version of at least 1 is required")
    private Integer version;

    public Team() {
        this.version = TestBaseConstants.TEAM_CURRENT_VERSION;
    }

    public Team(String id, String name, Boolean isActive, List<Member> memberList, String avatar, String description, List<ReviewPeriod> reviewPeriods, Double summaryScore, Integer version) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.memberList = memberList;
        this.avatar = avatar;
        this.description = description;
        this.reviewPeriods = reviewPeriods;
        this.summaryScore = summaryScore;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ReviewPeriod> getReviewPeriods() {
        return reviewPeriods;
    }

    public void setReviewPeriods(List<ReviewPeriod> reviewPeriods) {
        this.reviewPeriods = reviewPeriods;
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

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", memberList=" + memberList +
                ", avatar='" + avatar + '\'' +
                ", description='" + description + '\'' +
                ", reviewPeriods=" + reviewPeriods +
                ", summaryScore=" + summaryScore +
                ", version=" + version +
                '}';
    }
}
