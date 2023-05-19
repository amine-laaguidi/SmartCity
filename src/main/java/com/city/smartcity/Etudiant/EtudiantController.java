package com.city.smartcity.Etudiant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/etudiant")
public class EtudiantController {

    @GetMapping
    public String etudiant(){
        return "etudiant/etudiant";
    }
}
