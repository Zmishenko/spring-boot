package com.example.demo;

import com.example.domain.User;
import com.example.repository.UserRepository;
import com.example.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiteController {
    private final UserService userService;

    @Autowired
    public SiteController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/main")
    public String getNames(Model model){
        Iterable<User> users = userService.findAll();
        model.addAttribute("title", "Главная страница");
        model.addAttribute("name", users);
        return "main";
    }

    @GetMapping("/main/add")
    public String setName(Model model){
        return "add";
    }

    @PostMapping("/main/add")
    public String postName(@RequestParam String name, Model model){
        User user = new User(name);
        userService.save(user);
        return "redirect:/main";
    }
}
