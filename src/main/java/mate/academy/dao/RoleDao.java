package mate.academy.dao;

import java.util.Optional;
import mate.academy.model.Role;

public interface RoleDao {
    void add(Role role);

    Optional<Role> getRoleByName(String roleName);
}
