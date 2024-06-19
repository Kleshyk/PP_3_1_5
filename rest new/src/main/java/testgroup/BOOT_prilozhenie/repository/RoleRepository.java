package testgroup.BOOT_prilozhenie.repository;

import org.springframework.data.repository.CrudRepository;
import testgroup.BOOT_prilozhenie.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}