package cinema.controller;

import cinema.model.Role;
import cinema.service.AuthenticationService;
import cinema.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class InjectController {
    private final RoleService roleService;
    private final AuthenticationService authenticationService;

    public InjectController(RoleService roleService, AuthenticationService authenticationService) {
        this.roleService = roleService;
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String injectData() {
        //roleService.add(new Role(Role.RoleName.ADMIN));
        //roleService.add(new Role(Role.RoleName.USER));
        authenticationService.register("bob32@gmail.com","1234");
        authenticationService.register("admin@gmail.com","1234",
                new Role.RoleName[]{Role.RoleName.ADMIN, Role.RoleName.USER});
        return "Done!";
    }
}
