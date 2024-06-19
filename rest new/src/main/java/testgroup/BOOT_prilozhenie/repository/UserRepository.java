package testgroup.BOOT_prilozhenie.repository;

import org.springframework.data.repository.CrudRepository;
import testgroup.BOOT_prilozhenie.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String userName);
    void deleteById(int id);
}
