package assessment.entities.user;

import assessment.testbase.TestBaseConstants;
import assessment.utilities.RegexConstants;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by gfisher on 3/14/2016.
 */
public class User {

    @Id
    private String id;

    @NotEmpty(message = "First Name is required")
    @Pattern(regexp = RegexConstants.PERSON_NAME, message = "First name doesn't meet requirements")
    @Length(max = 50, message = "First name can be no longer than 50 characters")
    private String firstName;

    @NotEmpty(message = "Last Name is required")
    @Pattern(regexp = RegexConstants.PERSON_NAME, message = "Last name doesn't meet requirements")
    @Length(max = 50, message = "Last name can be no longer than 50 characters")
    private String lastName;

    @NotEmpty(message = "Email is required")
    @Pattern(regexp = RegexConstants.EMAIL, message = "Email must be valid")
    private String email;

    @NotEmpty(message = "Title is required and can't be empty")
    private String title;

    /**
     * user avatars are requested via Gravatar; the userAvatar field stores a
     * hash that must be calculated using the user's email address
     */
    private String avatar;

    @Length(max = 255, message = "Profile description must be fewer than 255" +
            " characters")
    private String profileDescription;

    @NotNull(message = "The user must be active or inactive")
    private Boolean isActive;

    @NotNull(message = "Start date cannot be null")
    private Date startDate;

    private Date endDate;

    @NotNull(message = "Version is required")
    @Range(min = 1, message = "version of at least 1 is required")
    private Integer version;

    public User() {
        this.version = TestBaseConstants.USER_CURRENT_VERSION;
    }

    public User(String firstName, String lastName, String email, String title, String avatar, String profileDescription, Boolean isActive, Date startDate, Date endDate, Integer version) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.title = title;
        this.avatar = avatar;
        this.profileDescription = profileDescription;
        this.isActive = isActive;
        this.startDate = startDate;
        this.endDate = endDate;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                ", avatar='" + avatar + '\'' +
                ", profileDescription='" + profileDescription + '\'' +
                ", isActive=" + isActive +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", version=" + version +
                '}';
    }
}
