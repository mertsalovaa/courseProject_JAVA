package app.web;

import app.entities.User;
import app.repositories.RoleRepository;
import app.repositories.UserRepository;
import app.seeder.UserSeeder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    private final UserSeeder userSeeder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public HomeController(UserRepository userRepository,
                          RoleRepository roleRepository,
                          UserSeeder userSeeder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userSeeder = userSeeder;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (userRepository.findAll().size() <= 0) {
            userSeeder.Seeder();
        }
        return "index";
    }
}
