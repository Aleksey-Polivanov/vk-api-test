package alex.pol.service;

import alex.pol.domain.RegisteredUser;

import java.io.IOException;
import java.sql.SQLException;

public interface RegisteredUserService extends Service<RegisteredUser> {

    void sendEmail(RegisteredUser user, String msg);

    void sendEmailWithAttachment(RegisteredUser user, String msg);



}
