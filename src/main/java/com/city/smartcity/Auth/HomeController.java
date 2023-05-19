package com.city.smartcity.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final UserRepository userRepository;
    @GetMapping
    public String index(Model model){
        if(model.getAttribute("user")==null && getPrincipal()!=null){
            Optional<User> user = userRepository.findById(getPrincipal().getUsername());
            if (user.isPresent()){
                UserRecord userRecord = new UserRecord(user.get().getNom() +" "+ user.get().getPrenom(),
                        user.get().getEmail(),
                        user.get().getRole().substring(5));
                model.addAttribute("user", userRecord);
            }

        }
        return "index";
    }
    @GetMapping("login")
    public String login(){
        if( getPrincipal() !=null)
            return "index";
        return "auth/login";
    }
//    public String role(){
//        getPrincipal().getAuthorities().stream().findFirst().get().getAuthority();
//    }
    private ApplicationUserDetails getPrincipal(){
        ApplicationUserDetails user = null;
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof ApplicationUserDetails){
            user =(ApplicationUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        return user;
    }
}
