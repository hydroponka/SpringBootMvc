package by.ageenko.SpringBootMvc.controller.user;

import by.ageenko.SpringBootMvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserPageController {
    private final UserService userService;
    @Autowired
    public UserPageController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/user_page/{id}")
    public String page(@PathVariable("id") int id, Model model){
        model.addAttribute("name", userService.findById(id).getName());
        return "/user_page";
    }
}
