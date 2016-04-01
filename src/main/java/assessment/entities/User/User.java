package assessment.entities.user;

import assessment.utilities.RegexConstants;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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

    @NotNull(message = "Role is required")
    private Role role;

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

    @Range(min = 1, message = "version of at least 1 is required")
    private Integer version;

    public User(){}

    public User(String id, String firstName, String lastName, String email,
                Role role, String avatar, String profileDescription, Boolean
                isActive, Integer version) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.avatar = avatar;
        this.profileDescription = profileDescription;
        this.isActive = isActive;
        this.version = version;
    }

    @Override
    public String toString() {
        return "user{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", avatar='" + avatar + '\'' +
                ", profileDescription='" + profileDescription + '\'' +
                ", isActive=" + isActive +
                ", version=" + version +
                '}';
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
