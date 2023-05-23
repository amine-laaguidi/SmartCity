package com.city.smartcity.Touriste;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/tourisme")
@RequiredArgsConstructor
public class TourismeController {
    private final TourismeService tourismeService;
    private final TourismeCatService tourismeCatService;
    @GetMapping
    public String tourisme(Model model) throws Exception {
            List<TourismeCat> tourismeCats =null;
            try {
                tourismeCats = tourismeCatService.findAll();
            }catch (Exception e){
                e.printStackTrace();
            }
            model.addAttribute("tourismeCats",tourismeCats);
        return "tourisme/tourisme";
    }
    @GetMapping("/{titleTC}")
    public String tourisme(Model model, @PathVariable("titleTC")String titleTC,@RequestParam(value = "page",defaultValue = "0") int page,@RequestParam(value = "search", defaultValue = "") String search) throws Exception {
        Page<Tourisme> tourismes = null;
        try{
            tourismes = tourismeService.findTourismesByTourismeCatIdTCAndTitreTContaining(tourismeCatService.findByTitle(titleTC).get().getIdTC(),search, PageRequest.of(page,10));
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("tourismes",tourismes);
        return "tourisme/tourismeItems";
    }

}
