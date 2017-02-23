package webobjects;

/**
 * Created by root on 22.02.17.
 * Builder for login data
 */
public class LoginData {

    private String email;
    private String password;
    private boolean saveCredentials;

    private LoginData() {

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean getSaveCredentials() {
        return saveCredentials;
    }


    public static Builder builder(String email, String password) {
        return new LoginData().new Builder(email, password);
    }

    public class Builder {

        private Builder(String email, String password) {
            LoginData.this.email = email;
            LoginData.this.password = password;
            LoginData.this.saveCredentials = false;
        }

        public Builder saveCredentials() {
            LoginData.this.saveCredentials = true;
            return this;
        }

        public LoginData build() {
            return LoginData.this;
        }
    }

}
