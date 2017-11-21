package james.mosley.com.pillar.Shared;

/**
 * Created by mosleyj on 2017-11-21.
 */

public class SessionInformation {
    private String error;
    private String userID;
    private String loginToken;
    private String loginTokenExpires;
    private String accountType;

    public SessionInformation(String error, String userID, String loginToken, String loginTokenExpires,
                              String accountType) {
        this.error = error;
        this.userID = userID;
        this.loginToken = loginToken;
        this.loginTokenExpires = loginTokenExpires;
        this.accountType = accountType;
    }

    public Boolean isValidSession () {
        return error.equals("null");
    }

    @Override
    public String toString() {
        return "error = " + error
                + "userId = " + userID
                + "accountType = " + accountType
                + "loginToken = " + loginToken
                + "loginTokenExpires = " + loginTokenExpires;
    }
}
