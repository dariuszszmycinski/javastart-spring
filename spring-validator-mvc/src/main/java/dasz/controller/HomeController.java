package dasz.controller;

import dasz.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        Person person = new Person();
        model.addAttribute(person);
        return "home";
    }

    @PostMapping("/")
    public String consumeForm(@Valid @ModelAttribute Person person, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();
            errors.forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
        }
        return "home";
    }
}
