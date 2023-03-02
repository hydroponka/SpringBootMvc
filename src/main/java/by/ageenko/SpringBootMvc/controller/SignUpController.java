package by.ageenko.SpringBootMvc.controller;

import by.ageenko.SpringBootMvc.model.RoleType;
import by.ageenko.SpringBootMvc.model.User;
import by.ageenko.SpringBootMvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignUpController {
    private final UserService userService;
    @Autowired
    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signupPage(Model model){
        model.addAttribute("new_user", new User());
        return "signup";
    }
    @PostMapping("/signup")
    public String signupAction(@ModelAttribute User user, Model model){
        model.addAttribute("new_user", user);
        user.setRoleType(RoleType.ROLE_USER);
        userService.save(user);
        return "user_page";
    }
}
