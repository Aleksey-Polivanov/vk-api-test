package alex.pol.service;

import alex.pol.domain.UserVK;

import java.sql.SQLException;

public interface UserVKService extends Service<UserVK> {

    UserVK findByVkID(String vkID);

    @Override
    UserVK insert(UserVK o) throws SQLException;
}
