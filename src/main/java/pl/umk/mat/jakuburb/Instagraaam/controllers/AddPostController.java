package pl.umk.mat.jakuburb.Instagraaam.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.umk.mat.jakuburb.Instagraaam.encje.Poost;
import pl.umk.mat.jakuburb.Instagraaam.encje.User;
import pl.umk.mat.jakuburb.Instagraaam.enums.RegisterStates;
import pl.umk.mat.jakuburb.Instagraaam.repository.PostRepo;

@Controller
public class AddPostController {

    private final PostRepo postRepo;

    private User user;

    @Autowired
    public AddPostController(PostRepo postRepo){
        this.postRepo = postRepo;

    }

    @GetMapping("/add")
    public String addPostHome(HttpSession session, Model model){

        user  = (User)session.getAttribute("User");

        if(user != null){
            if(user.getLogin().equals("-1")){
                return "error";
            }else{
                return "postCreate";
            }
        }else{
            return "error";
        }

    }

    @PostMapping("/add")
    public String addPost(String url, String opis, HttpSession session){

        user  = (User)session.getAttribute("User");

        if(user != null){
            if(user.getLogin().equals("-1")){
                return "error";
            }
        }else{
            return "error";
        }

        Poost post = new Poost(url, opis, user);

        if(!post.getUrl().equals("") && !post.getOpis().equals("")) {
            System.err.println("zapisujem ....");
            postRepo.save(post);
        }

        return "";
    }

}
