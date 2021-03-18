package app.web;

import app.constants.Roles;
import app.dto.UserDTO;
import app.entities.User;
import app.repositories.RoleRepository;
import app.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Controller
public class AccountController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public AccountController(PasswordEncoder passwordEncoder,
                             UserRepository userRepository,
                             RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(UserDTO userDTO) {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserDTO userDTO, String confirmPassword,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        String pass1 = userDTO.getPassword();
        String pass2 = userDTO.getConfirmPassword();

        if (pass1.contains(pass2)) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
            try {
                Date date = formatter.parse(userDTO.getBirthday());
                User user1 = new User();
                user1.setFirstName(userDTO.getFirstName());
                user1.setLastName(userDTO.getLastName());
                user1.setPhone(userDTO.getPhone());
                user1.setAddress(userDTO.getAddress());
                user1.setEmail(userDTO.getEmail());
                user1.setBirthday(date);
                user1.setRoles(Arrays.asList(
                        roleRepository.findByName(Roles.User)));
                user1.setPassword(passwordEncoder.encode(userDTO.getPassword()));
                userRepository.save(user1);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return "redirect:/login";
        } else {
            return "register";
        }
    }
}
