package com.city.smartcity.Auth;

import com.city.smartcity.Etudiant.CampusCatService;
import com.city.smartcity.Touriste.TourismeCatService;
import com.city.smartcity.Touriste.TourismeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;
    private final TourismeCatService tourismeCatService;
    private final CampusCatService campusCatService;
    @GetMapping
    public ModelAndView index(HttpSession session) throws Exception {
        ModelAndView modelAndView = new ModelAndView("index");
        if(session.getAttribute("user")==null && userService.getPrincipal()!=null){
            UserRecord userRecord = userService.getPrincipalRecord();
            session.setAttribute("user", userRecord);
            modelAndView.addObject("user", userRecord);
        }
        UserRecord userRecord = (UserRecord)session.getAttribute("user");
        if(userRecord!=null && userRecord.getRole().equals("TOURISTE"))
            modelAndView.addObject("tourismeCats",tourismeCatService.findAll());
        else if(userRecord!=null && userRecord.getRole().equals("ETUDIANT"))
            modelAndView.addObject("campusCats",campusCatService.findAll());
        return modelAndView;
    }
    @GetMapping("login")
    public String login(){
        if( userService.getPrincipal() !=null)
            return "redirect:/";
        return "auth/login";
    }
    @GetMapping("register")
    public String register(){
        if( userService.getPrincipal() !=null)
            return "redirect:/";
        return "auth/register";
    }
    @GetMapping("apropos")
    public String apropos(HttpSession session){
        UserRecord user = (UserRecord) session.getAttribute("user");
        if(user==null)
            return "apropos";
        if(user.getRole().equals("TOURISTE"))
            return "redirect:/tourisme/apropos";
        else if(user.getRole().equals("ETUDIANT"))
            return "redirect:/etudiant/apropos";
        return "index";
    }
    @GetMapping("contact")
    public String contact(HttpSession session){
        UserRecord user = (UserRecord) session.getAttribute("user");
        if(user==null)
            return "contact";
        if(user.getRole().equals("TOURISTE"))
            return "redirect:/tourisme/contact";
        else if(user.getRole().equals("ETUDIANT"))
            return "redirect:/etudiant/contact";
        return "index";
    }
//    public String role(){
//        getPrincipal().getAuthorities().stream().findFirst().get().getAuthority();
//    }

}
