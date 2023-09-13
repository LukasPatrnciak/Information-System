package sk.lukaspatrnciak.informationsystem.data.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import sk.lukaspatrnciak.informationsystem.data.user.domain.User;
import sk.lukaspatrnciak.informationsystem.data.user.service.UserService;
import sk.lukaspatrnciak.informationsystem.data.web.request.UserRequest;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String all(Model model) {
        model.addAttribute("users", userService.listAllUsers());
        return "user/all";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new UserRequest()); // Posielanie vytvoreneho objektu naspat do  programu
        return "user/add";
    }

    @PostMapping("/add")
    public String regUser(@ModelAttribute UserRequest userRequest, Model model) {
        userService.registerRequest(userRequest);
        model.addAttribute("users", userService.listAllUsers());
        return "user/all";
    }

    @GetMapping("/id/{id}")
    public String byId(@PathVariable long id, Model model) {
        Optional<User> userById = Optional.ofNullable(userService.findByUserId(id));
        if (userById.isPresent()) {
            User user = userById.get();
            model.addAttribute("user", userService.findByUserId(user.getUserId()));
        }
        return "user/one";
    }

    @GetMapping("/edit/{id}")
    public String editById(@PathVariable long id, Model model) {
        Optional<User> userById = Optional.ofNullable(userService.findByUserId(id));
        if (userById.isPresent()) {
            User user = userById.get();
            model.addAttribute("user", userService.findByUserId(user.getUserId()));
        }
        return "/user/edit/one";
    }
}