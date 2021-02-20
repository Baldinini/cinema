package mate.academy.security;

import java.util.Set;
import mate.academy.model.Role;
import mate.academy.model.User;
import mate.academy.service.service.RoleService;
import mate.academy.service.service.ShoppingCartService;
import mate.academy.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final PasswordEncoder encoder;
    private final RoleService roleService;

    @Autowired
    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     PasswordEncoder encoder,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.encoder = encoder;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setPassword(encoder.encode(password));
        user.setEmail(email);
        Role role = roleService.getRoleByName("USER");
        user.setRoles(Set.of(role));
        User addUser = userService.add(user);
        shoppingCartService.registerNewShoppingCart(addUser);
        return addUser;
    }
}
