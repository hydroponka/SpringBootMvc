package by.ageenko.SpringBootMvc.controller.admin;

import by.ageenko.SpringBootMvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPageController {
    private final UserService userService;
    @Autowired
    public AdminPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin_page")
    public String findAll(Model model){
        model.addAttribute("users", userService.findAll());
        return "admin_page";
    }
}
