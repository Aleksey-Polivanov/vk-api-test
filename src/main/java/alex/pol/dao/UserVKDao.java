package alex.pol.dao;

import alex.pol.domain.UserVK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVKDao extends JpaRepository<UserVK, Integer> {

    UserVK findByVkID(String VkID);

}
