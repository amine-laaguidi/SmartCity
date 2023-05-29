package com.city.smartcity.Admin;

import com.city.smartcity.Auth.UserService;
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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final ImageService imageService;
    private final TourismeCatService tourismeCatService;

    private final TourismeService tourismeService;
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
}
