package com.city.smartcity.Touriste;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tourisme")
public class TouristeController {

    @GetMapping
    public String tourisme(){
        return "tourisme/tourisme";
    }
}
