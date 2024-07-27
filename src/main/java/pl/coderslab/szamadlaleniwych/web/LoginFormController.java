package pl.coderslab.szamadlaleniwych.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.szamadlaleniwych.domain.User;
import pl.coderslab.szamadlaleniwych.dto.UserDto;
import pl.coderslab.szamadlaleniwych.service.UserService;

@Controller
public class LoginFormController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @GetMapping("/LoginFormAfterRegistration")
    public String loginFormAfterRegistration(@ModelAttribute("user")
                                                 UserDto userDto,
                                             Model model) {
        User user = userService.findByEmail(userDto.getEmail());
        if (user != null) {
            model.addAttribute("user", userDto);
            return "LoginFormAfterRegistration";
        } return "LoginFormAfterRegistration";
    }
}
