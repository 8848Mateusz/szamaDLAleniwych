package pl.coderslab.szamadlaleniwych.service;


import pl.coderslab.szamadlaleniwych.domain.User;
import pl.coderslab.szamadlaleniwych.dto.UserDto;
import java.util.Optional;

public interface UserService {


    User saveUser(UserDto userDto);

    Optional<User> getUserById(Long id);

    User updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);

    User findByEmail(String email);

    boolean isEmailAlreadyInUse (String email);
}
