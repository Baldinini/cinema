package mate.academy.service.service;

import mate.academy.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
