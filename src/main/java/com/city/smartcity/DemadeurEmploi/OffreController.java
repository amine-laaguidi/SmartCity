package com.city.smartcity.DemadeurEmploi;

import com.city.smartcity.Auth.UserService;
import com.city.smartcity.Entrepreneur.*;
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
@RequestMapping("/emploi")
@RequiredArgsConstructor
public class OffreController {
    private final OrganisationService organisationService;
    private final EntrepriseService entrepriseService;
    private final DomaineService domaineService;
    private final OffreService offreService;
    private final UserService userService;

    @GetMapping
    public String emploi(HttpSession session, Model model) throws Exception {
        if (model.getAttribute("user") == null) {
            if (session.getAttribute("user") == null) {
                session.setAttribute("user", userService.getPrincipalRecord());
            }
            model.addAttribute("user", session.getAttribute("user"));
        }
        return "emploi/emploi";
    }

    @GetMapping("/offres")
    public String offres(Model model,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "titreOff", defaultValue = "") String titreOff,
                         @RequestParam(value = "titreDom", defaultValue = "") String titreDom,
                         @RequestParam(value = "titreE", defaultValue = "") String titreE,
                         @RequestParam(value = "titreOrg", defaultValue = "") String titreOrg
    ) throws Exception {
        Page<Offre> offres = null;
        List<Entreprise> entreprises = null;
        List<Organisation> organisations = null;
        List<Domaine> domaines = null;
        model.addAttribute("entreprises", entrepriseService.findAll());
        model.addAttribute("organisations", organisationService.findAll());
        model.addAttribute("domaines", domaineService.findAll());
        try {
            offres = offreService.search(titreDom, titreE, titreOrg, titreOff, PageRequest.of(page, 10));
        } catch (Exception e) {
            System.out.println("------------------------------tourismesCat error----------------------");
            e.printStackTrace();
        }
        if (offres != null) {
            model.addAttribute("offres", offres);
            model.addAttribute("pages", offres.getTotalPages());
        }
        model.addAttribute("currentPage", page);
        model.addAttribute("titreOff", titreOff);
        model.addAttribute("titreDom", titreDom);
        model.addAttribute("titreE", titreE);
        model.addAttribute("titreOrg", titreOrg);
        return "emploi/offres";
    }

    @GetMapping("/offres/{idOff}")
    public String offre(Model model, @PathVariable("idOff") Long idOff) throws Exception {
        Optional<Offre> offre = null;
        try {
            offre = offreService.getOffreById(idOff);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (offre != null) {
            model.addAttribute("offre", offre.get());
        }
        return "emploi/offre";
    }
    @GetMapping("/entreprise")
    public String entreprise(Model model,@RequestParam(value = "page",defaultValue = "0") int page, @RequestParam(value = "search", defaultValue = "") String search) throws Exception {
        Page<Entreprise> entreprises = null;
        try{
            entreprises = entrepriseService.search(search,PageRequest.of(page,10));
        }catch (Exception e){
            System.out.println("------------------------------tourismesCat error----------------------");
            e.printStackTrace();
        }
         if(entreprises!=null){
            model.addAttribute("entreprises",entreprises);
            model.addAttribute("pages",entreprises.getTotalPages());
        }
        model.addAttribute("currentPage",page);
        model.addAttribute("search",search);
        return "emploi/entreprise";
    }
//    @GetMapping("/{titleAffCat}/{idAff}")
//    public String affaireItem(Model model, @PathVariable("titleAffCat")String titleAffCat,@PathVariable("idAff")Long idAff) throws Exception {
//        Optional<Affaire> affaire = null;
//        Optional<Entreprise> entreprise = null;
//        Optional<Organisation> organisation = null;
//        List<AffaireCat> affaireCats =null;
//        try{
//            if(titleAffCat.equals("entreprise"))
//                entreprise = entrepriseService.findEtrepriseByIdE(idAff);
//            else if(titleAffCat.equals("organisation"))
//                organisation = organisationService.findOrganisationByIdOrg(idAff);
//            else{
//                affaire = affaireService.findAffaireByIdAff(idAff);
//            }
//            affaireCats = affaireCatService.findAll();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        if(affaire!=null){
//            model.addAttribute("affaire",affaire.get());
//        }else if(entreprise!=null){
//            model.addAttribute("entreprise",entreprise.get());
//        }else if(organisation!=null){
//            model.addAttribute("organisation",organisation.get());
//        }
//        model.addAttribute("affaireCats",affaireCats);
//        return "affaire/affaireItem";
//    }
}

