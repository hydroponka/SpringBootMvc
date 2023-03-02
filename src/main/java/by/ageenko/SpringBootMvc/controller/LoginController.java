package by.ageenko.SpringBootMvc.controller;

import by.ageenko.SpringBootMvc.model.User;
import by.ageenko.SpringBootMvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final UserService userService;
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginAction(@RequestParam User user, Model model){
        model.addAttribute("user", user);
        if (!userService.authorization(user.getName(), user.getPassword())) {
            return "login";
        } else {
            return "user_page";
        }
    }
}
