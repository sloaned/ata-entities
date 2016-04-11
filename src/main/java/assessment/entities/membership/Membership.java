package assessment.entities.membership;

import assessment.testbase.TestBaseConstants;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Membership {

    @NotEmpty(message = "user ID is required")
    private String userId;

    @NotNull(message = "The membership must be active or inactive")
    private Boolean isActive;

    @NotNull(message = "A user on a team must have a date they were added to that team")
    private Date addedOn;

    private Date removedOn;

    @NotNull
    @Range(min = 1, message = "version of at least 1 is required")
    private Integer version;

    public Membership(){
        this.version = TestBaseConstants.MEMBERSHIP_CURRENT_VERSION;
    }

    public Membership(String userId, Boolean isActive, Date addedOn, Date
            removedOn) {
        this.userId = userId;
        this.isActive = isActive;
        this.addedOn = addedOn;
        this.removedOn = removedOn;
        this.version = TestBaseConstants.MEMBERSHIP_CURRENT_VERSION;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "userId='" + userId + '\'' +
                ", isActive=" + isActive +
                ", addedOn=" + addedOn +
                ", removedOn=" + removedOn +
                ", version=" + version +
                '}';
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
