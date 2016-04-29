package assessment.entities.token;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Token object which will be used for OAuth
 * Doesn't worry about validation since it should only be passed and received, not manipulated
 */
public class Token {

    private String id;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("expires_in")
    private Long expiresIn; //can probably be a date object, just make sure to translate unix time properly

    private String scope; // might want to change to Enum

    //assuming the json object with be lowercase with _, specs aren't clear yet. Fix if needed
    @JsonProperty("user_details")
    private TokenUser userDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public TokenUser getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(TokenUser userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public String toString() {
        return "Token{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", expiresIn=" + expiresIn +
                ", scope='" + scope + '\'' +
                ", userDetails=" + userDetails +
                '}';
    }
}
