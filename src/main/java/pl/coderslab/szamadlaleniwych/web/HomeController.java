package pl.coderslab.szamadlaleniwych.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.szamadlaleniwych.service.UserService;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @GetMapping("/HomePage")
    public String homePageWithoutUser() {
        return "HomePage";
    }

    @GetMapping("/UserHomePage")
    public String homePageWithUser(Model model,
                                   Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "UserHomePage";
    }
}
