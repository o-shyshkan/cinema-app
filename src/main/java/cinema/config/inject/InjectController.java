package cinema.config.inject;

import cinema.model.Role;
import cinema.service.AuthenticationService;
import cinema.service.RoleService;
import cinema.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class InjectController {
    private static final String ADMIN_EMAIL = "admin@gmail.com";
    private static final String USER_EMAIL = "bob32@gmail.com";
    private final RoleService roleService;
    private final AuthenticationService authenticationService;
    private final UserService userService;

    public InjectController(RoleService roleService, AuthenticationService authenticationService,
                            UserService userService) {
        this.roleService = roleService;
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @GetMapping
    public String injectUser() {
        Role roleAdmin = new Role(Role.RoleName.ADMIN);
        Role roleUser = new Role(Role.RoleName.USER);
        if (!roleService.isExistRoleByName(Role.RoleName.ADMIN.name())) {
            roleService.add(roleAdmin);
        }
        if (!roleService.isExistRoleByName(Role.RoleName.USER.name())) {
            roleService.add(roleUser);
        }
        if (userService.findByEmail(USER_EMAIL).isEmpty()) {
            authenticationService.register(USER_EMAIL, "1234");
        }
        if (userService.findByEmail(ADMIN_EMAIL).isEmpty()) {
            authenticationService.register(ADMIN_EMAIL, "1234",
                    new Role.RoleName[]{Role.RoleName.ADMIN, Role.RoleName.USER});
        }
        return "Done!";
    }
}
