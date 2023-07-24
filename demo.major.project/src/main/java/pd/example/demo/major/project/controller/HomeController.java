package pd.example.demo.major.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pd.example.demo.major.project.model.User;
import pd.example.demo.major.project.service.UserDetailsServiceImpl;

@Controller
public class HomeController {
    @Autowired
    private  UserDetailsServiceImpl userDetailsService;
    @GetMapping("/index")
    public String showHomePage () {
        return "index";
    }
    @GetMapping("/navigation")
    public String showNavigationPage () {
        return "navigation";
    }
    @GetMapping("/about")
    public String showAboutPage(){return "about";}
    @GetMapping("/login")
    public String showLoginPage () {
        return "login";
    }


    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/login";
    }
}
