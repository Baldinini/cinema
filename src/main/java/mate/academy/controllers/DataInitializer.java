package mate.academy.controllers;

import java.util.Set;
import javax.annotation.PostConstruct;
import mate.academy.model.Role;
import mate.academy.model.User;
import mate.academy.service.service.RoleService;
import mate.academy.service.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void addRoles() {
        Role roleAdmin = new Role();
        roleAdmin.setRoleName(Role.RoleName.ADMIN);
        roleService.add(roleAdmin);
        Role roleUser = new Role();
        roleUser.setRoleName(Role.RoleName.USER);
        roleService.add(roleUser);
        User admin = new User();
        admin.setEmail("Admin");
        admin.setPassword("1234");
        admin.setRoles(Set.of(roleAdmin));
        userService.add(admin);
    }
}
