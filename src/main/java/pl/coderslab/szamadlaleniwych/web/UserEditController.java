package pl.coderslab.szamadlaleniwych.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.szamadlaleniwych.domain.User;
import pl.coderslab.szamadlaleniwych.dto.UserDto;
import pl.coderslab.szamadlaleniwych.repository.UserRepository;
import pl.coderslab.szamadlaleniwych.service.UserService;
import java.util.Optional;

@Controller
public class UserEditController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/UserSettings{id}")
    public String showEditForm(@PathVariable Long id,
                               Model model) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "UserSettings";
        } else {
            return "redirect:UserSettings?error";
        }
    }

    @PostMapping("/UserSettings{id}")
    public String updateUser(@PathVariable Long id,
                             @ModelAttribute User user,
                             UserDto userDto,
                             Model model ) {
            userDto.setId(id);
        if (userService.isEmailAlreadyInUse(user.getEmail())) {
            return "redirect:/UserSettings{id}?EmailAddressInUse";
        } else
            userService.updateUser(id, userDto);
        return "redirect:/LoginFormAfterRegistration?UpdateSuccessful";
    }

    @GetMapping("/UserDell{id}")
    public String aboutDeleteUser(@PathVariable Long id, Model model) {

        return "redirect:/UserSettings{id}?ToBeSure";
    }

    @PostMapping("/UserDell{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        userService.deleteUser(id);

        return "redirect:/HomePage?AccountDelete";
    }
}
