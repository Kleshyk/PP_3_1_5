package testgroup.BOOT_prilozhenie.service;

import testgroup.BOOT_prilozhenie.model.Role;

import java.util.Optional;
import java.util.Set;

public interface RoleService {
    void createRoles(Set<Role> roles);
    Set<Role> getAllRoles();
    Optional<Role> findByName(String name);
}