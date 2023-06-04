package com.city.smartcity.Entrepreneur;

import com.city.smartcity.Auth.UserService;
import com.city.smartcity.Touriste.Tourisme;
import com.city.smartcity.Touriste.TourismeCat;
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
import java.util.Optional;

@Controller
@RequestMapping("/affaire")
@RequiredArgsConstructor
public class AffaireController {
    private final UserService userService;
    private final AffaireCatService affaireCatService;
    private final AffaireService affaireService;
    private final OrganisationService organisationService;
    private final EntrepriseService entrepriseService;
    @GetMapping
    public String affaire(HttpSession session, Model model) throws Exception {
        if(model.getAttribute("user")==null){
            if(session.getAttribute("user")==null){
                session.setAttribute("user",userService.getPrincipalRecord());
            }
            model.addAttribute("user",session.getAttribute("user"));
        }
        List<AffaireCat> affaireCats =null;
        try {
            affaireCats = affaireCatService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        } model.addAttribute("affaireCats",affaireCats);
        return "affaire/affaire";
    }
    @GetMapping("/apropos")
    public String apropos(Model model){
        List<AffaireCat> affaireCats =null;
        try{
            affaireCats = affaireCatService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("affaireCats",affaireCats);
        return "apropos";
    }
    @GetMapping("/contact")
    public String contact(Model model){
        List<AffaireCat> affaireCats =null;
        try{
            affaireCats = affaireCatService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("affaireCats",affaireCats);
        return "contact";
    }
    @GetMapping("/{titleAffCat}")
    public String affaireItems(Model model, @PathVariable("titleAffCat")String titleAffCat, @RequestParam(value = "page",defaultValue = "0") int page, @RequestParam(value = "search", defaultValue = "") String search) throws Exception {
        Page<Affaire> affaires = null;
        Page<Entreprise> affairesE = null;
        Page<Organisation> affairesOrg = null;
        List<AffaireCat> affaireCats =null;
        try{
            if(titleAffCat.equals("entreprise"))
                affairesE = entrepriseService.search(search,PageRequest.of(page,10));
            else if(titleAffCat.equals("organisation"))
                affairesOrg = organisationService.search(search,PageRequest.of(page,10));
            else{
                affaires = affaireService.search(affaireCatService.findByTitle(titleAffCat).get(),search, PageRequest.of(page,10));
            }
            affaireCats = affaireCatService.findAll();
        }catch (Exception e){
            System.out.println("------------------------------tourismesCat error----------------------");
            e.printStackTrace();
        }
        if(affaires!=null){
            model.addAttribute("affaires",affaires);
            model.addAttribute("pages",affaires.getTotalPages());
        }else if(affairesE!=null){
            model.addAttribute("affairesE",affairesE);
            model.addAttribute("pages",affairesE.getTotalPages());
        }else if(affairesOrg!=null){
            model.addAttribute("affairesOrg",affairesOrg);
            model.addAttribute("pages",affairesOrg.getTotalPages());
        }
        model.addAttribute("affaireCats",affaireCats);
        model.addAttribute("currentPage",page);
        model.addAttribute("search",search);
        return "affaire/affaireItems";
    }
    @GetMapping("/{titleAffCat}/{idAff}")
    public String affaireItem(Model model, @PathVariable("titleAffCat")String titleAffCat,@PathVariable("idAff")Long idAff) throws Exception {
        Optional<Affaire> affaire = null;
        Optional<Entreprise> entreprise = null;
        Optional<Organisation> organisation = null;
        List<AffaireCat> affaireCats =null;
        try{
            if(titleAffCat.equals("entreprise"))
                entreprise = entrepriseService.findEtrepriseByIdE(idAff);
            else if(titleAffCat.equals("organisation"))
                organisation = organisationService.findOrganisationByIdOrg(idAff);
            else{
                affaire = affaireService.findAffaireByIdAff(idAff);
            }
            affaireCats = affaireCatService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(affaire!=null){
            model.addAttribute("affaire",affaire.get());
        }else if(entreprise!=null){
            model.addAttribute("entreprise",entreprise.get());
        }else if(organisation!=null){
            model.addAttribute("organisation",organisation.get());
        }
        model.addAttribute("affaireCats",affaireCats);
        return "affaire/affaireItem";
    }
}
