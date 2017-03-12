package alex.pol.domain;

import javax.persistence.Entity;

@Entity(name = "registered_users")
public class RegisteredUser extends BaseModel {

        private String UserName;
        private String Email;
        private Boolean sendMail = false;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Boolean getSendMail() {
        return sendMail;
    }

    public void setSendMail(Boolean sendMail) {
        this.sendMail = sendMail;
    }

    @Override
    public String toString() {
        return "RegisteredUser{" +
                "UserName='" + UserName + '\'' +
                ", Email='" + Email + '\'' +
                ", sendMail=" + sendMail +
                '}';
    }
}

