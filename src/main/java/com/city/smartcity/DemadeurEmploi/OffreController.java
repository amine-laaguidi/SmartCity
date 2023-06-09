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
            if(!titreE.equals("") && !titreOrg.equals("")){
                offres = offreService.search(titreDom,titreE, titreOrg,titreOff, PageRequest.of(page, 10));
            }else if(!titreE.equals("")){
                offres = offreService.search(titreDom, titreE,titreOff, PageRequest.of(page, 10));
            }else if(!titreOrg.equals("")){
                offres = offreService.searchOrg(titreDom, titreOrg,titreOff, PageRequest.of(page, 10));
            }else{
                offres = offreService.search(titreDom,titreOff, PageRequest.of(page, 10));
            }
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
    @GetMapping("/entreprise/{idAff}")
    public String entrepriseItem(Model model,@PathVariable("idAff")Long idAff) throws Exception {
        Optional<Entreprise> entreprise = null;
        List<AffaireCat> affaireCats =null;
        try{
            entreprise = entrepriseService.findEtrepriseByIdE(idAff);
        }catch (Exception e){
            e.printStackTrace();
        }
         if(entreprise!=null)
            model.addAttribute("entreprise",entreprise.get());
        return "emploi/entrepriseItem";
    }
    @GetMapping("/organisation")
    public String organisation(Model model,@RequestParam(value = "page",defaultValue = "0") int page, @RequestParam(value = "search", defaultValue = "") String search) throws Exception {
        Page<Organisation> organisations = null;
        try{
            organisations = organisationService.search(search,PageRequest.of(page,10));
        }catch (Exception e){
            System.out.println("------------------------------tourismesCat error----------------------");
            e.printStackTrace();
        }
        if(organisations!=null){
            model.addAttribute("organisations",organisations);
            model.addAttribute("pages",organisations.getTotalPages());
        }
        model.addAttribute("currentPage",page);
        model.addAttribute("search",search);
        return "emploi/organisation";
    }
    @GetMapping("/organisation/{idAff}")
    public String organisationItem(Model model,@PathVariable("idAff")Long idAff) throws Exception {
        Optional<Organisation> organisation = null;
        List<AffaireCat> affaireCats =null;
        try{
            organisation = organisationService.findOrganisationByIdOrg(idAff);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(organisation!=null)
            model.addAttribute("organisation",organisation.get());
        return "emploi/organisationItem";
    }

}

