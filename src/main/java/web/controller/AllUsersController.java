package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AllUsersController {

    private UserService service;

    public AllUsersController(UserService service) {
        this.service = service;

    }

    @GetMapping(value = "/")
    public String getUsers(ModelMap model) {
//        return "redirect:cars?count=-1";
        List<User> users = service.getUsers();
        model.addAttribute("users", users);
        return "index";
    }



// url: http://localhost:8080/manager/html
//	Но перед этим пришлось в файле tomcat-users.xml вписать:
//<role rolename="manager-gui"/>
//<user username="tomcat" password="s3cret" roles="manager-gui"/>
// on site
// https://helpcontext.ru/questions/25999/intellij-tomcat-pokazyvaet-404-pri-zapuske

}
