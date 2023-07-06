package pl.umk.mat.jakuburb.Instagraaam.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.umk.mat.jakuburb.Instagraaam.encje.Poost;
import pl.umk.mat.jakuburb.Instagraaam.encje.User;
import pl.umk.mat.jakuburb.Instagraaam.repository.PostRepo;
import pl.umk.mat.jakuburb.Instagraaam.repository.UserRepo;

import java.util.List;

@Controller
public class OsobaController {

    private final UserRepo userRepo;
    private final PostRepo postRepo;

    @Autowired
    public OsobaController(UserRepo userRepo, PostRepo postRepo){
        this.userRepo = userRepo;
        this.postRepo = postRepo;
    }

    @GetMapping("/osoba/{$name}")
    public String osobaHome(@PathVariable("$name") String name, Model model, HttpSession session){

        User user  = (User)session.getAttribute("User");

        if(user != null){
            if(user.getLogin().equals("-1")){
                return "error";
            }
        }else{
            System.err.println("wrrrr2");
            return "error";
        }

        List<User> u = userRepo.findByLogin(name);


        long ilosc = u.stream().count();

        if(ilosc == 0){
            return "error";
        }

        List<Poost> poosts = postRepo.findByUser(u.get(0));

        model.addAttribute("osobaa", u.get(0));
        model.addAttribute("post", poosts);
        model.addAttribute("user", user);

        return "osoba";
    }
}
