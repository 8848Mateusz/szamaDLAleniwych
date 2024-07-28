package pl.coderslab.szamadlaleniwych.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.szamadlaleniwych.domain.Role;
import pl.coderslab.szamadlaleniwych.domain.User;
import pl.coderslab.szamadlaleniwych.dto.UserDto;
import pl.coderslab.szamadlaleniwych.repository.RoleRepository;
import pl.coderslab.szamadlaleniwych.repository.UserRepository;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        Role role = roleRepository.findRoleById(1);
        user.setRole(role);
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(Long id,
                           UserDto userDto) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setEmail(userDto.getEmail());
            user.setName(userDto.getName());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            if (!userDto.getPassword().isEmpty()){
                user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            }
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean isEmailAlreadyInUse(String email) {
        Optional <User> userOptional = Optional.ofNullable(userRepository.findByEmail(email));
        return userOptional.isPresent();
    }
}
