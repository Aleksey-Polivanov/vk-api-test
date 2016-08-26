package alex.pol.domain;

import alex.pol.domain.BaseModel;

import javax.persistence.Entity;

@Entity(name = "vk_users")
public class UserVK extends BaseModel {

        private String vkID;
        private String firstName;
        private String secondName;
        private Boolean sendMail = false;

    public UserVK(String vkID, String firstName, String secondName) {
        this.vkID = vkID;
        this.firstName = firstName;
        this.secondName = secondName;
        getSendMail();

    }

    public UserVK(String vkID, String firstName, String secondName, Boolean sendMail) {
        this.vkID = vkID;
        this.firstName = firstName;
        this.secondName = secondName;
        this.sendMail = sendMail;
    }

    public UserVK() {
    }

    public String getVkID() {
        return vkID;
    }

    public void setVkID(String vkID) {
        this.vkID = vkID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Boolean getSendMail() {
        return sendMail;
    }

    public void setSendMail(Boolean sendMail) {
        this.sendMail = sendMail;
    }

    @Override
    public String toString() {
        return "UserVK{" +
                "vkID='" + vkID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", sendMail=" + sendMail +
                '}';
    }
}

