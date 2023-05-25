package com.city.smartcity.Admin;

import com.city.smartcity.Auth.UserService;
import com.city.smartcity.Touriste.TourismeCat;
import com.city.smartcity.Touriste.TourismeCatService;
import com.city.smartcity.image.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final ImageService imageService;
    private final TourismeCatService tourismeCatService;
    @GetMapping()
    public String admin(){
        return "admin/admin";
    }
    @GetMapping("/tourisme")
    public String tourisme(Model model){
        model.addAttribute("tourismeCat", new TourismeCat());
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
}
