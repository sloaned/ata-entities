package assessment.entities.Team;

import assessment.entities.Membership.Membership;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Team {

    @Id
    private String id;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "The team must be active or inactive")
    private Boolean isActive;

    private String templateId;

    private List<Membership> userList;

    private List<Membership> leaderList;

    private String teamAvatar;

    @Length(max = 255)
    private String teamDescription;

    @NotEmpty(message = "Team type is required")
    private TeamType teamType;

    private Integer reviewFrequency;

    @NotEmpty(message = "Version is required")
    private Integer version;

    public Team(String id, String name, Boolean isActive, String templateId,
                List<Membership> userList, List<Membership> leaderList, String
                teamAvatar, String teamDescription, TeamType teamType, Integer
                reviewFrequency, Integer version) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.templateId = templateId;
        this.userList = userList;
        this.leaderList = leaderList;
        this.teamAvatar = teamAvatar;
        this.teamDescription = teamDescription;
        this.teamType = teamType;
        this.reviewFrequency = reviewFrequency;
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

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
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

    public String getTeamAvatar() {
        return teamAvatar;
    }

    public void setTeamAvatar(String teamAvatar) {
        this.teamAvatar = teamAvatar;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }

    public TeamType getTeamType() {
        return teamType;
    }

    public void setTeamType(TeamType teamType) {
        this.teamType = teamType;
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
