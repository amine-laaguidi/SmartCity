package com.city.smartcity.Touriste;

import com.city.smartcity.Auth.UserService;
import com.city.smartcity.image.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/tourisme")
@RequiredArgsConstructor
public class TourismeController {
    @Value("${image.upload.path}")
    private String imageUploadPath;

    private final TourismeService tourismeService;
    private final TourismeCatService tourismeCatService;
    private final UserService userService;
    @GetMapping
    public String tourisme(HttpSession session, Model model) throws Exception {
        if(model.getAttribute("user")==null){
            if(session.getAttribute("user")==null){
                session.setAttribute("user",userService.getPrincipalRecord());
            }
            model.addAttribute("user",session.getAttribute("user"));
        }
        List<TourismeCat> tourismeCats =null;
        try {
            tourismeCats = tourismeCatService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        } model.addAttribute("tourismeCats",tourismeCats);
        return "tourisme/tourismev1";
    }
    @GetMapping("/apropos")
    public String apropos(Model model){
        List<TourismeCat> tourismeCats =null;
        try{
            tourismeCats = tourismeCatService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("tourismeCats",tourismeCats);
        return "apropos";
    }
    @GetMapping("/contact")
    public String contact(Model model){
        List<TourismeCat> tourismeCats =null;
        try{
            tourismeCats = tourismeCatService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("tourismeCats",tourismeCats);
        return "contact";
    }
    @GetMapping("/{titleTC}")
    public String tourismeItems(Model model, @PathVariable("titleTC")String titleTC,@RequestParam(value = "page",defaultValue = "0") int page,@RequestParam(value = "search", defaultValue = "") String search) throws Exception {
        Page<Tourisme> tourismes = null;
        List<TourismeCat> tourismeCats =null;
        try{
            tourismes = tourismeService.search(tourismeCatService.findByTitle(titleTC).get(),search, PageRequest.of(page,10));
            tourismeCats = tourismeCatService.findAll();
        }catch (Exception e){
            System.out.println("------------------------------tourismesCat error----------------------");
            e.printStackTrace();
        }
        if(tourismes!=null)
            model.addAttribute("pages",new int[tourismes.getTotalPages()]);
        model.addAttribute("tourismeCats",tourismeCats);
        model.addAttribute("tourismes",tourismes);
        model.addAttribute("currentPage",page);
        model.addAttribute("search",search);
        return "tourisme/tourismeItemsv1";
    }
    @GetMapping("/{titleTC}/{idT}")
    public String tourismeItem(Model model, @PathVariable("titleTC")String titleTC,@PathVariable("idT")Long idT) throws Exception {
        Tourisme tourisme = null;
        List<TourismeCat> tourismeCats =null;
        try{
            tourisme = tourismeService.findTourismeByIdT(idT);
            tourismeCats = tourismeCatService.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("tourismeCats",tourismeCats);
        model.addAttribute("tourisme",tourisme);
        return "tourisme/tourismeItem";
    }
}
