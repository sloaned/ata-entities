package assessment.entities.team;

import assessment.entities.assessment.Assessment;
import assessment.entities.membership.Membership;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Team {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotEmpty(message = "team name is required")
    private String name;

    @NotEmpty(message = "The team must be active or inactive")
    private Boolean isActive;

    private Assessment assessment;

    private List<Membership> userList;

    private List<Membership> leaderList;

    private String avatar;

    @Length(max = 255, message = "team description length must not exceed " +
            "255 characters")
    private String description;

    @NotEmpty(message = "team type is required")
    private TeamType type;

    private Integer reviewFrequency;

    @NotEmpty(message = "Version is required")
    private Integer version;

    public Team(String id, String name, Boolean isActive, Assessment assessment,
                List<Membership> userList, List<Membership> leaderList, String
                avatar, String description, TeamType type, Integer
                reviewFrequency, Integer version) {
        this.id = id;
        this.version = version;
        this.name = name;
        this.isActive = isActive;
        this.assessment = assessment;
        this.userList = userList;
        this.leaderList = leaderList;
        this.description = description;
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

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public List<Membership> getUserList() {
        return userList;
    }

    public void setUserList(List<Membership> userList) {
        this.userList = userList;
    }

    public List<Membership> getLeaderList() {
        return leaderList;
    }

    public void setLeaderList(List<Membership> leaderList) {
        this.leaderList = leaderList;
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

    public TeamType getType() {
        return type;
    }

    public void setType(TeamType type) {
        this.type = type;
    }

    public Integer getReviewFrequency() {
        return reviewFrequency;
    }

    public void setReviewFrequency(Integer reviewFrequency) {
        this.reviewFrequency = reviewFrequency;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
