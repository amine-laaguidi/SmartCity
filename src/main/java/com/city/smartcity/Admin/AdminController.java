package com.city.smartcity.Admin;

import com.city.smartcity.Auth.UserService;
import com.city.smartcity.DemadeurEmploi.Domaine;
import com.city.smartcity.DemadeurEmploi.DomaineService;
import com.city.smartcity.DemadeurEmploi.Offre;
import com.city.smartcity.DemadeurEmploi.OffreService;
import com.city.smartcity.Entrepreneur.*;
import com.city.smartcity.Etudiant.Campus;
import com.city.smartcity.Etudiant.CampusCat;
import com.city.smartcity.Etudiant.CampusCatService;
import com.city.smartcity.Etudiant.CampusService;
import com.city.smartcity.Touriste.Tourisme;
import com.city.smartcity.Touriste.TourismeCat;
import com.city.smartcity.Touriste.TourismeCatService;
import com.city.smartcity.Touriste.TourismeService;
import com.city.smartcity.image.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final ImageService imageService;
    private final TourismeCatService tourismeCatService;
    private final TourismeService tourismeService;
    private final CampusCatService campusCatService;
    private final CampusService campusService;
    private final OrganisationService organisationService;
    private final EntrepriseService entrepriseService;
    private final AffaireService affaireService;
    private final AffaireCatService affaireCatService;
    private final OffreService offreService;
    private final DomaineService domaineService;

    @GetMapping()
    public String admin(){
        return "admin/admin";
    }
    @GetMapping("/tourisme")
    public String tourisme(Model model) throws Exception {
        model.addAttribute("tourismeCat", new TourismeCat());
        model.addAttribute("tourisme", new Tourisme());
        model.addAttribute("tourismeCats",tourismeCatService.findAll());
        return "admin/tourisme";
    }
    @PostMapping("/tourismeCat")
    public String addTourismeCat(@ModelAttribute("tourismeCat") TourismeCat tourismeCat,
                                 @RequestParam("imageFile") MultipartFile imageFile)  {
        if (!imageFile.isEmpty()) {
            try {
                tourismeCat.setImgTC(imageService.saveImage(imageFile,"TOURISTE"));
                tourismeCatService.save(tourismeCat);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/admin/tourisme";
    }
    @PostMapping("/tourisme")
    public String addTourisme(@ModelAttribute("tourisme") Tourisme tourisme,
                              @RequestParam("images") List<MultipartFile> images,
                              @RequestParam("idTC") Long idTC)  {
        if (!images.isEmpty()) {
            try {
                tourisme.setTourismeCat(tourismeCatService.findById(idTC).get());
                tourisme.setImageUrls(new ArrayList<String>());
                for (MultipartFile image : images) {
                    tourisme.getImageUrls().add(imageService.saveImage(image,"TOURISTE"));
                }
                tourismeService.save(tourisme);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/admin/tourisme";
    }
    @GetMapping("/etudiant")
    public String etudiant(Model model) throws Exception {
        model.addAttribute("campusCat", new CampusCat());
        model.addAttribute("campus", new Campus());
        model.addAttribute("campusCats",campusCatService.findAll());
        return "admin/etudiant";
    }

    @PostMapping("/campusCat")
    public String addCampusCat(@ModelAttribute("campusCat") CampusCat campusCat,
                                 @RequestParam("imageFile") MultipartFile imageFile)  {
        if (!imageFile.isEmpty()) {
            try {
                campusCat.setImgCmpCat(imageService.saveImage(imageFile,"ETUDIANT"));
                campusCatService.save(campusCat);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/admin/etudiant";
    }

    @PostMapping("/campus")
    public String addCampus(@ModelAttribute("campus") Campus campus,
                              @RequestParam("images") List<MultipartFile> images,
                              @RequestParam("idTC") Long idTC)  {
        if (!images.isEmpty()) {
            try {
                campus.setCampusCat(campusCatService.findById(idTC).get());
                campus.setImageUrls(new ArrayList<String>());
                for (MultipartFile image : images) {
                    campus.getImageUrls().add(imageService.saveImage(image,"ETUDIANT"));
                }
                campusService.save(campus);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/admin/etudiant";
    }

    @GetMapping("/affaire")
    public String affaire(Model model) throws Exception {
        model.addAttribute("affaireCat", new AffaireCat());
        model.addAttribute("affaire", new Affaire());
        model.addAttribute("affaireCats",affaireCatService.findAll());
        return "admin/affaire";
    }
    @PostMapping("/affaireCat")
    public String addAffaireCat(@ModelAttribute("affaireCat") AffaireCat affaireCat,
                               @RequestParam("imageFile") MultipartFile imageFile)  {
        if (!imageFile.isEmpty()) {
            try {
                affaireCat.setImgAffCat(imageService.saveImage(imageFile,"AFFAIRE"));
                affaireCatService.save(affaireCat);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/admin/affaire";
    }

    @PostMapping("/affaire")
    public String addAffaire(@ModelAttribute("affaire") Affaire affaire,
                            @RequestParam("images") List<MultipartFile> images,
                            @RequestParam("idAffCat") Long idAffCat)  {
        Entreprise entreprise =null;
        Organisation organisation=null;
        if (!images.isEmpty()) {
            if(idAffCat==-1){
                try {
                    entreprise = new Entreprise();
                    entreprise.setTitreE(affaire.getTitreAff());
                    entreprise.setAdresseE(affaire.getAdresseAff());
                    entreprise.setDescriptionE(affaire.getDescriptionAff());
                    entreprise.setImageUrls(new ArrayList<String>());
                    for (MultipartFile image : images) {
                        entreprise.getImageUrls().add(imageService.saveImage(image,"AFFAIRE"));
                    }
                    entrepriseService.save(entreprise);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else if(idAffCat==-2){
                try {
                    organisation = new Organisation();
                    organisation.setTitreOrg(affaire.getTitreAff());
                    organisation.setAdresseOrg(affaire.getAdresseAff());
                    organisation.setDescriptionOrg(affaire.getDescriptionAff());
                    organisation.setImageUrls(new ArrayList<String>());
                    for (MultipartFile image : images) {
                        organisation.getImageUrls().add(imageService.saveImage(image,"AFFAIRE"));
                    }
                    organisationService.save(organisation);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else{
                try {
                    affaire.setAffaireCat(affaireCatService.findById(idAffCat).get());
                    affaire.setImageUrls(new ArrayList<String>());
                    for (MultipartFile image : images) {
                        affaire.getImageUrls().add(imageService.saveImage(image,"AFFAIRE"));
                    }
                    affaireService.save(affaire);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return "redirect:/admin/affaire";
    }
    @GetMapping("/offres")
    public String offres(Model model) throws Exception {
        model.addAttribute("domaine", new Domaine());
        model.addAttribute("offre", new Offre());
        model.addAttribute("domaines",domaineService.findAll());
        model.addAttribute("organisations",organisationService.findAll());
        model.addAttribute("entreprises",entrepriseService.findAll());
        return "admin/offres";
    }
    @PostMapping("/domaine")
    public String addDomaine(@ModelAttribute("domaine") Domaine domaine)  {
            try {
                domaineService.save(domaine);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return "redirect:/admin/offres";
    }

    @PostMapping("/offres")
    public String addOffres(@ModelAttribute("offre") Offre offre,
                             @RequestParam("images") List<MultipartFile> images,
                             @RequestParam(value="idE",defaultValue = "0") Long idE,
                             @RequestParam(value="idOrg",defaultValue = "0") Long idOrg,
                             @RequestParam(value = "idDom") Long idDom) {
        if (!images.isEmpty()) {
            if(idOrg!=0){
                try {
                    offre.setOrganisation(organisationService.findOrganisationByIdOrg(idOrg).get());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else if(idE!=0){
                try {
                    offre.setEntreprise(entrepriseService.findEtrepriseByIdE(idE).get());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            try {
                offre.setDomaine(domaineService.findByIdDom(idDom).get());
                offre.setImageUrls(new ArrayList<String>());
                for (MultipartFile image : images) {
                    offre.getImageUrls().add(imageService.saveImage(image,"EMPLOI"));
                }
                offreService.save(offre);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return "redirect:/admin/offres";
    }
}

