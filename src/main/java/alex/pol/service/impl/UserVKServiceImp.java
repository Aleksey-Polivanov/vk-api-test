package alex.pol.service.impl;

import alex.pol.dao.UserVKDao;
import alex.pol.domain.UserVK;
import alex.pol.service.UserVKService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserVKServiceImp extends BaseService<UserVK, UserVKDao> implements UserVKService {

    @Override
    public UserVK insert(UserVK o) throws SQLException {
        dao.save(o);
        return o;
    }

    @Override
    public UserVK findByVkID(String vkID) {
        return dao.findByVkID(vkID);
    }
}
