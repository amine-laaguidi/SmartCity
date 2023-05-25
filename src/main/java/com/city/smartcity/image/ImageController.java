package com.city.smartcity.image;

import com.city.smartcity.Auth.UserRecord;
import com.city.smartcity.Auth.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class ImageController {
    private final UserService userService;
    @Value("${image.upload.path}")
    private String imageUploadPath;
    @GetMapping("/images/{imageName}")
    public ResponseEntity<Resource> getImage(HttpSession session, Model model, @PathVariable String imageName) throws Exception {
        if(model.getAttribute("user")==null){
            if(session.getAttribute("user")==null){
                session.setAttribute("user",userService.getPrincipalRecord());
            }
            model.addAttribute("user",session.getAttribute("user"));
        }
        UserRecord user = (UserRecord) model.getAttribute("user");
        // Load the image from the storage folder
        Resource imageResource;
        try {
            imageResource = new FileSystemResource(System.getProperty("user.dir")+imageUploadPath + imageName);
        } catch (Exception e) {
            throw e;
        }
        // Apply authorization logic here (e.g., check user roles)
        System.out.println(user.getRole());
        System.out.println(imageName.split("_")[0]);
        if (!user.getRole().equals(imageName.split("_")[0]) && !user.getRole().equals("ADMIN"))
            throw new Exception("not authorised");
        // Return the image as a response entity
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(imageResource);
    }
}
