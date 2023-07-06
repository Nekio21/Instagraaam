package pl.umk.mat.jakuburb.Instagraaam.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.umk.mat.jakuburb.Instagraaam.encje.Comments;
import pl.umk.mat.jakuburb.Instagraaam.encje.Poost;
import pl.umk.mat.jakuburb.Instagraaam.encje.User;
import pl.umk.mat.jakuburb.Instagraaam.repository.CommentsRepo;
import pl.umk.mat.jakuburb.Instagraaam.repository.PostRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class PostContoller {

    private final PostRepo postRepo;
    private final CommentsRepo cRepo;

    private User user;

    @Autowired
    public PostContoller(PostRepo postRepo, CommentsRepo cRepo){
        this.postRepo = postRepo;
        this.cRepo = cRepo;
    }

    @GetMapping("/post/{$id}")
    public String postHome(@PathVariable("$id") Long id, Model model, HttpSession session){

        user  = (User)session.getAttribute("User");

        if(user != null){
            if(user.getLogin().equals("-1")){
                return "error";
            }
        }else{
            System.err.println("wrrrr2");
            return "error";
        }

        Optional<Poost> post = postRepo.findById(id);

        if(post.isEmpty() == true){
            return "error";
        }

        model.addAttribute("post", post.orElseThrow());

        List<Comments> commentsList = cRepo.findByPost(post.orElseThrow());


        commentsList = commentsList.stream().map(e-> {
            e.setOpis(": " + e.getOpis());
            return e;
        }).toList();



        model.addAttribute("comlist", commentsList);

        return "post";
    }

    @PostMapping("/post/post/{$id}")
    public String addComment(@PathVariable("$id") Long id, String text, HttpSession session){
        user  = (User)session.getAttribute("User");

        if(user != null){
            if(user.getLogin().equals("-1")){
                return "error";
            }
        }else{
            System.err.println("wrrrr2");
            return "error";
        }

        Comments com = new Comments(postRepo.findById(id).orElseThrow(), user, text);

        cRepo.save(com);

        return "";
    }
}
