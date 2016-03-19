package assessment.entities.Membership;

import java.util.Date;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Membership {

    private String userEmail;

    private String version;

    private Boolean isActive;

    private Date addedDate;

    private Date removedDate;

    public Membership() {}

    public Membership(String userEmail, String version, Boolean isActive, Date addedDate, Date removedDate) {
        this.userEmail = userEmail;
        this.version = version;
        this.isActive = isActive;
        this.addedDate = addedDate;
        this.removedDate = removedDate;
    }

    public String getUser() {
        return userEmail;
    }

    public void setUser(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getRemovedDate() {
        return removedDate;
    }

    public void setRemovedDate(Date removedDate) {
        this.removedDate = removedDate;
    }
}
