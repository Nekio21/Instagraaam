package pl.umk.mat.jakuburb.Instagraaam.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.umk.mat.jakuburb.Instagraaam.encje.User;
import pl.umk.mat.jakuburb.Instagraaam.repository.UserRepo;

import java.util.List;

@Controller
public class BananController {


    private final UserRepo userRepo;


    @Autowired
    public BananController(UserRepo userRepo){
        this.userRepo = userRepo;
    }


    @PostMapping("/banan")
    public String home2(String login, String password, HttpSession session){

        System.err.println(login);
        System.err.println(password);

        if(login.equals("") || password.equals("")){
            session.setAttribute("User", new User("-1", "-1", ""));

            return "nie";
        }

        List<User> a = userRepo.findByLogin(login);



        System.err.print("Size" + a.size());

        if(a.size() != 0){
            String loginU =  a.get(0).getLogin();
            String passU = a.get(0).getPassword();

            if(passU.equals(password)){
                session.setAttribute("User", a.get(0));
                return "tak";
            }

            System.out.println(loginU + " - " + passU);
        }

        session.setAttribute("User", new User("-1", "-1", ""));

        return "nie";
    }
}
