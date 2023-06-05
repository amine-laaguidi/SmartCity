package com.city.smartcity.DemadeurEmploi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/emploi")
public class DemandeurController {
    @GetMapping
    public String emploi(){
        return "emploi/emploi";
    }
}
