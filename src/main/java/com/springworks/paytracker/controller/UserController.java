package com.springworks.paytracker.controller;

import com.springworks.paytracker.dao.UserRepo;
import com.springworks.paytracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    UserRepo repo;

    @PostMapping(path="/setUser")
    public String setUser(@RequestBody User user, Model model) {
        String status;
        try {
            repo.save(user);
            System.out.println("saved into db");
            status = "Your account is created, you will be redirected to login page.";
            model.addAttribute(status);
            return "/login";
        }
        catch (IllegalArgumentException ie) {
            System.out.println("not saved");
            status = "Your account is not created, please re-enter the data";
            model.addAttribute(status);
            return "/signup";
        }

    }
    @GetMapping(path="/users")
    public List<User> users() {
        return repo.findAll();
    }
}
