package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

@Controller
public class AddController {
    private UserService service;
    public AddController(UserService service) {
        this.service = service;
    }

    @PostMapping(value = "/addUser")
    public String addUser(@ModelAttribute("user") User user, ModelMap model) {
                          // @ModelAttribute("lastName") String lastName,
                          //@ModelAttribute("input33") String input1,
//                          @RequestParam(name = "input1", defaultValue = "-1") String input1,
                          //@ModelAttribute("Raznoe") Raznoe rznAttr,

        String s1 = user.getFirstName();
        String s2 = user.getLastName();
        String s3 = user.getEmail();

       service.add(user);

//        return "redirect:cars?count=-1";
//        List<User> users = service.getUsers();
//        Raznoe rzn = (Raznoe) model.getAttribute("Raznoe");
//        String input01 = (String) model.getAttribute("input1");
//        model.addAttribute("result001", "input1: " + input1 + " input01 = " + input01);
        //"result001", user.getFirstName() + " " + user.getLastName()
        //+ " input1: " + input1 + " raznoe.getInput: " + rznAttr.getInput1());

//        model.addAttribute("AddUser", new User());
//        model.addAttribute("input1", new String("-==aaa=--"));
        model.addAttribute("user", new User() );
        model.addAttribute("result001", "User added: " +
                "first: " + s1 + " lastname: " + s2 + " email: " + s3);
        return "redirect:/";
    }

}
