package app.seeder;

import app.constants.Roles;
import app.entities.Role;
import app.entities.User;
import app.repositories.RoleRepository;
import app.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Calendar;

@Service
public class UserSeeder {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

@Autowired
    public UserSeeder(UserRepository userRepository,
                      RoleRepository roleRepository,
                      PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void Seeder() {
        SeedRole();
        SeedUser();
    }

    public void SeedRole() {
        if(roleRepository.count()==0) {
            Role role = new Role();
            role.setName(Roles.Admin);
            roleRepository.save(role);
            role = new Role();
            role.setName(Roles.User);
            roleRepository.save(role);
            role = new Role();
            role.setName(Roles.Employee);
            roleRepository.save(role);
        }
    }

    public void SeedUser() {
        Calendar birth = Calendar.getInstance();
        int month = 3;
        birth.set(2004, month-1, 10);
        if(userRepository.count()==0) {
            User user = new User();
            user.setFirstName("Admin");
            user.setLastName("Iryna");
            user.setEmail("admin@gmail.com");
            user.setBirthday(birth.getTime());
            user.setAddress("address");
            user.setPhone("+380678597324");
            user.setPassword(passwordEncoder.encode("123456"));
            user.setRoles(Arrays.asList(
                    roleRepository.findByName(Roles.Admin)));
            userRepository.save(user);
        }
    }
}
