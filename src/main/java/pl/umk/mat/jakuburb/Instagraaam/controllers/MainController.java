package pl.umk.mat.jakuburb.Instagraaam.controllers;

import com.sun.tools.javac.Main;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.umk.mat.jakuburb.Instagraaam.encje.Poost;
import pl.umk.mat.jakuburb.Instagraaam.encje.User;
import pl.umk.mat.jakuburb.Instagraaam.repository.PostRepo;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private final PostRepo postRepo;

    @Autowired
    public MainController(PostRepo postRepo){
        this.postRepo = postRepo;
    }

    @GetMapping("/portal")
    public String stronaGlowna(Model model, HttpSession session){

        User user  = (User)session.getAttribute("User");

        if(user != null){
            if(user.getLogin().equals("-1")){
                System.err.println("wrrrr");
                return "error";
            }else{
                model.addAttribute("lists", postRepo.findAll());
                model.addAttribute("name", user.getLogin());
                model.addAttribute("image", user.getUrlImage());

                return "portal";
            }
        }else{
            System.err.println("wrrrr2");
            return "error";
        }

    }
}
