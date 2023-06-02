package com.city.smartcity.Etudiant;

import com.city.smartcity.Auth.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/etudiant")
@RequiredArgsConstructor
public class EtudiantController {
    private final UserService userService;
    private final CampusCatService campusCatService;
    private final CampusService campusService;
    @GetMapping
    public String etudiant(HttpSession session, Model model) throws Exception{
        if(model.getAttribute("user")==null){
            if(session.getAttribute("user")==null){
                session.setAttribute("user",userService.getPrincipalRecord());
            }
            model.addAttribute("user",session.getAttribute("user"));
        }
        List<CampusCat> campusCats =null;
        try {
            campusCats = campusCatService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        } model.addAttribute("campusCats",campusCats);
        return "etudiant/etudiant";
    }
    @GetMapping("/apropos")
    public String apropos(Model model){
        List<CampusCat> campusCats =null;
        try{
            campusCats = campusCatService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("campusCats",campusCats);
        return "apropos";
    }
    @GetMapping("/contact")
    public String contact(Model model){
        List<CampusCat> campusCats =null;
        try{
            campusCats = campusCatService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("campusCats",campusCats);
        return "contact";
    }
    @GetMapping("/{titleCmpCat}")
    public String tourismeItems(Model model, @PathVariable("titleCmpCat")String titleCmpCat, @RequestParam(value = "page",defaultValue = "0") int page, @RequestParam(value = "search", defaultValue = "") String search) throws Exception {
        Page<Campus> campuses = null;
        List<CampusCat> campusCats =null;
        try{
             campuses= campusService.search(campusCatService.findByTitle(titleCmpCat).get(),search, PageRequest.of(page,10));
            campusCats = campusCatService.findAll();
        }catch (Exception e){
            System.out.println("------------------------------campusCat error----------------------");
            e.printStackTrace();
        }
        model.addAttribute("campusCats",campusCats);
        model.addAttribute("campuses",campuses);
        model.addAttribute("search",search);
        return "etudiant/campuses";
    }
    @GetMapping("/{titleCmpCat}/{idCmp}")
    public String tourismeItem(Model model, @PathVariable("titleCmpCat")String titleCmpCat,@PathVariable("idCmp")Long idCmp) throws Exception {
        Campus campus = null;
        List<CampusCat> campusCats =null;
        try{
            campus = campusService.findCampusByIdT(idCmp);
            campusCats = campusCatService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("campusCats",campusCats);
        model.addAttribute("campus",campus);
        return "etudiant/campus";
    }
}
