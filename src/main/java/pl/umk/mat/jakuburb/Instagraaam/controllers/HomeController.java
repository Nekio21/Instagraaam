package pl.umk.mat.jakuburb.Instagraaam.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.umk.mat.jakuburb.Instagraaam.encje.User;
import pl.umk.mat.jakuburb.Instagraaam.repository.UserRepo;

import java.util.List;

public class HomeController {

    private final UserRepo userRepo;


    @Autowired
    public HomeController(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @GetMapping("/")
    public String home(HttpSession session){

        User user = (User) session.getAttribute("User");

        return "index";
    }
}
