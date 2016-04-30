package assessment.entities.team;

import assessment.entities.user.Role;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Member {

    @NotEmpty(message = "user ID is required")
    private String userId;

    @NotNull(message = "The member must be active or inactive")
    private Boolean isActive;

    @NotNull(message = "A user on a team must have a date they were added to that team")
    private Date addedOn;

    private Date removedOn;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Role role;

    public Member() {
    }

    public Member(String userId, Boolean isActive, Date addedOn, Date removedOn, Role role) {
        this.userId = userId;
        this.isActive = isActive;
        this.addedOn = addedOn;
        this.removedOn = removedOn;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public Date getRemovedOn() {
        return removedOn;
    }

    public void setRemovedOn(Date removedOn) {
        this.removedOn = removedOn;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Member{" +
                "userId='" + userId + '\'' +
                ", isActive=" + isActive +
                ", addedOn=" + addedOn +
                ", removedOn=" + removedOn +
                ", role=" + role +
                '}';
    }
}
