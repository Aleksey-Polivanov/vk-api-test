package alex.pol.dao;

import alex.pol.domain.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by agios on 22.02.17.
 */
public interface RegisteredUserDao extends JpaRepository<RegisteredUser, Integer> {
}
