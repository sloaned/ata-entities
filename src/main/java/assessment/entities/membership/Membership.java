package assessment.entities.membership;

import assessment.entities.user.User;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Membership {

    @DBRef
    @NotEmpty(message = "User ID is required")
    private User userId;

    @NotEmpty(message = "The membership must be active or inactive")
    private Boolean isActive;

    private Date addedOn;

    private Date removedOn;

    @NotEmpty(message = "Version is required")
    private Integer version;

    public Membership(){

    }

    public Membership(User userId, Boolean isActive, Date addedOn, Date
            removedOn, Integer version) {
        this.userId = userId;
        this.isActive = isActive;
        this.addedOn = addedOn;
        this.removedOn = removedOn;
        this.version = version;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}