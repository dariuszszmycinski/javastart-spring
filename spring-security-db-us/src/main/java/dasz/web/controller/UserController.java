package dasz.web.controller;

import dasz.model.User;
import dasz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String addUser(@ModelAttribute @Valid User user,
                          BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "registerForm";
        else{
            userService.addWithDefaultRole(user);
            return "registerSuccess";
        }
    }
}
