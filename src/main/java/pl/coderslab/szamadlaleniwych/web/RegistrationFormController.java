package pl.coderslab.szamadlaleniwych.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.szamadlaleniwych.domain.User;
import pl.coderslab.szamadlaleniwych.dto.UserDto;
import pl.coderslab.szamadlaleniwych.service.UserService;

@Controller
public class RegistrationFormController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @GetMapping("/RegistrationForm")
    public String showRegistrationForm(Model model,
                                       UserDto userDto) {
        model.addAttribute("user", userDto);
        return "RegistrationForm";
    }

    @PostMapping("/RegistrationForm")
    public String saveUser(@ModelAttribute("user") UserDto userDto,
                           Model model) {
        User user = userService.findByEmail(userDto.getEmail());
        if (user != null) {
            model.addAttribute("user", userDto);
            return "redirect:RegistrationForm?error";
        }
        userService.saveUser(userDto);
        model.addAttribute("regsuc", "Rejestracja przebiegła prawidłowo");
        return "redirect:LoginFormAfterRegistration?success";
    }
}
