package james.mosley.com.pillar.Shared;

/**
 * Created by mosleyj on 2017-11-21.
 */

public class LoginObject {
    String error;
    String userID;
    String loginToken;
    String loginTokenExpires;
    String accountType;

    public LoginObject(String error, String userID, String loginToken, String loginTokenExpires,
                       String accountType) {
        this.error = error;
        this.userID = userID;
        this.loginToken = loginToken;
        this.loginTokenExpires = loginTokenExpires;
        this.accountType = accountType;
    }

    public Boolean isValid () {
        return error == null;
    }
}
