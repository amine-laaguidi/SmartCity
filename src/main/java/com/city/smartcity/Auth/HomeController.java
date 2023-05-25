package com.city.smartcity.Auth;

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
    @GetMapping
    public ModelAndView index(HttpSession session) throws Exception {
        ModelAndView modelAndView = new ModelAndView("index");
        if(modelAndView.getModel().get("user")==null && userService.getPrincipal()!=null){
            UserRecord userRecord = userService.getPrincipalRecord();
            session.setAttribute("user", userRecord);
            modelAndView.addObject("user", userRecord);
        }
        return modelAndView;
    }
    @GetMapping("login")
    public String login(){
        if( userService.getPrincipal() !=null)
            return "redirect:/";
        return "auth/login";
    }
//    public String role(){
//        getPrincipal().getAuthorities().stream().findFirst().get().getAuthority();
//    }

}
