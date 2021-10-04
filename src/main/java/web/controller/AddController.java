package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.model.User;
import web.service.UserService;

@Controller
public class AddController {
    private UserService service;
    public AddController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/addUser")
    String addPage(ModelMap model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping(value = "/addUser")
    public String addUser(@ModelAttribute("user") User user, ModelMap model) {

       service.add(user);

        return "redirect:/";
    }

}
