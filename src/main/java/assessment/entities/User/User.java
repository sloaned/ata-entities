package assessment.entities.User;

import assessment.utilities.RegexConstants;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * Created by gfisher on 3/14/2016.
 */
public class User extends ResourceSupport {

    @Id
    private String id;

    private String version;

    @NotEmpty(message = "First Name is required")
    private String firstName;

    @NotEmpty(message = "Last Name is required")
    private String lastName;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotNull(message = "Username is required")
    @Pattern(regexp = RegexConstants.USERNAME)
    private String username;

    @NotNull(message = "Password is required")
    @Pattern(regexp = RegexConstants.PASSWORD)
    private String password;


//    TODO Add Image to User Entity
    private String profileDescription;

    private Boolean isActive;

    public User(){
        this.version = "default";
        this.firstName = "Joe";
        this.lastName = "Shmoe";
        this.email = "jschmoe@normal.com";
        this.username = "jshmoe";
        this.password = "Password1!";
        this.isActive = true;
    }

    public User(String version, String firstName, String lastName, String email, String username, String password, String profileDescription, Boolean isActive) {
        this.version = version;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.profileDescription = profileDescription;
        this.isActive = isActive;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
