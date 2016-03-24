package assessment.entities.User;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

/**
 * Created by gfisher on 3/14/2016.
 */
public class User {

    @Id
    private String id;

    @NotEmpty(message = "First Name is required")
    private String firstName;

    @NotEmpty(message = "Last Name is required")
    private String lastName;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotEmpty(message = "Role is required")
    private Role role;

    /**
     * User avatars are requested via Gravatar; the userAvatar field stores a
     * hash that must be calculated using the user's email address
     */
    private String userAvatar;

    @Length(max = 255)
    private String profileDescription;

    @NotEmpty(message = "The user must be active or inactive")
    private Boolean isActive;

    @NotEmpty(message = "Version is required")
    private Integer version;

    public User(){
        this.firstName = "Joe";
        this.lastName = "Shmoe";
        this.email = "jschmoe@normal.com";
        this.role = Role.DEVELOPER;
        this.isActive = true;
        this.version = 1;
    }

    public User(String firstName, String lastName, String email, Role role,
                String userAvatar, String profileDescription, Boolean isActive,
                Integer version) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.userAvatar = userAvatar;
        this.profileDescription = profileDescription;
        this.isActive = isActive;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
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
