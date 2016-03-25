package assessment.entities.Team;

import assessment.entities.Assessment.Assessment;
import assessment.entities.User.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Team {

    @Id
    private String id;

    private String version;

    private String name;

    private Boolean isActive;

    private Assessment assessment;

    @DBRef
    private List<User> teamMembers;

    @DBRef
    private List<User> teamLeads;

// TODO: Add Image to Team Entity;

    private String teamDescription;

    private Team() {}

    public Team(String version, String name, Boolean isActive, Assessment assessment, List<User> teamMembers, List<User> teamLeads, String teamDescription) {
        this.version = version;
        this.name = name;
        this.isActive = isActive;
        this.assessment = assessment;
        this.teamMembers = teamMembers;
        this.teamLeads = teamLeads;
        this.teamDescription = teamDescription;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public List<User> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<User> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public List<User> getTeamLeads() {
        return teamLeads;
    }

    public void setTeamLeads(List<User> teamLeads) {
        this.teamLeads = teamLeads;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }
}
