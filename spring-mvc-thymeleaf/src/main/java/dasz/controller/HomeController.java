package dasz.controller;

import dasz.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("helloMessage", "Hello Thymeleaf!");
        model.addAttribute(
                "formArticle",
                new Article("Some title", "Content here...", "tag1, tag2...")
        );
        return "index";
    }
}
