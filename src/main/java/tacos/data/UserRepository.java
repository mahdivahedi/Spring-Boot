package tacos.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import tacos.dto.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUsername(String userName);

}
