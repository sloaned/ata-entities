package assessment.entities.Token;

import java.util.Date;

/**
 * Created by gfisher on 3/16/2016.
 */
public class Token {

    private String firstName;

    private String lastName;

    private String email;

    private Date expirationDate;

    public Token() {}

    public Token(String firstName, String lastName, String email, Date expirationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.expirationDate = expirationDate;
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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
