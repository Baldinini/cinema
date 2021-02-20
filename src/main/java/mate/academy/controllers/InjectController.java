package mate.academy.controllers;

import java.util.Set;
import javax.annotation.PostConstruct;
import mate.academy.model.Role;
import mate.academy.model.User;
import mate.academy.service.service.RoleService;
import mate.academy.service.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
public class InjectController {
    private final RoleService roleService;
    private final UserService userService;
    private final PasswordEncoder encoder;

    public InjectController(RoleService roleService,
                            UserService userService, PasswordEncoder encoder) {
        this.roleService = roleService;
        this.userService = userService;
        this.encoder = encoder;
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
        admin.setPassword(encoder.encode("1234"));
        admin.setRoles(Set.of(roleAdmin));
        userService.add(admin);
    }
}
