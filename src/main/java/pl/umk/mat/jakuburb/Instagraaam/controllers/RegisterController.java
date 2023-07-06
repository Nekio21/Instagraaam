package pl.umk.mat.jakuburb.Instagraaam.controllers;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.umk.mat.jakuburb.Instagraaam.encje.User;
import pl.umk.mat.jakuburb.Instagraaam.enums.RegisterStates;
import pl.umk.mat.jakuburb.Instagraaam.repository.UserRepo;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Controller
public class RegisterController {

    private final UserRepo userRepo;
    private RegisterStates state;

    @Autowired
    public RegisterController(UserRepo userRepo){
        this.userRepo = userRepo;
        state = RegisterStates.NOSEND;
    }

    @GetMapping("/register")
    public String registerSite(Model model, HttpSession session){
        System.err.println("wynik to: " + state);

        String odpowiedz = "";

        state = (RegisterStates) session.getAttribute("state");

        if(state == null){
            state = RegisterStates.NOSEND;
        }

        switch (state) {
            case ACCEPTED -> {
                state = RegisterStates.NOSEND;
                odpowiedz = "Udało sie utworzyc konto :)";
            }
            case NOTACCPETED -> {
                state = RegisterStates.NOSEND;
                odpowiedz = "Nie udało sie utworzyc konta";
            }
        }

        session.setAttribute("state", state);

        model.addAttribute("odpowiedz", odpowiedz);

        return "register";
    }

    @PostMapping("/register")
    public String getData(User user, HttpSession session){
        System.out.println(user);
        System.out.print(user.getLogin());
        System.out.print(user.getPassword());

        for(User u: userRepo.findAll()){
            if(user.getLogin().equals(u.getLogin())){
                state = RegisterStates.NOTACCPETED;
                session.setAttribute("state", state);
                System.err.println("bylo");
                return "nie";
            }
        }


        userRepo.save(user);
        state = RegisterStates.ACCEPTED;
        session.setAttribute("state", state);
        System.err.print("create :)");

        return "tak";
    }
}
