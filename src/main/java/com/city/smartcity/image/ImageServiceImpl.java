package com.city.smartcity.image;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
@Service
public class ImageServiceImpl implements ImageService{

    @Value("${image.upload.path}")
    private String imageUploadPath;
    @Override
    public String saveImage(MultipartFile file, String role) throws IOException {
        // Generate a unique filename for the image
        String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        // Define the storage location using the configured image upload path
        String storagePath = System.getProperty("user.dir")+imageUploadPath+role+"_"+filename;
        Path directoryPath = Paths.get(storagePath);
        System.out.println("--------------"+directoryPath+"--------------");
        if (!Files.exists(directoryPath)) {
            Files.createDirectories(directoryPath);
        }
        // Save the file to the storage location
        file.transferTo(new File(storagePath));

        // Return the URL for accessing the image
        return role+"_"+filename;
    }
    public void deleteImageFile(String imageUrl) {
        String storagePath = System.getProperty("user.dir") + imageUploadPath + imageUrl;
        Path imagePath = Paths.get(storagePath);

        try {
            Files.deleteIfExists(imagePath);
            System.out.println("Image file deleted successfully: " + imageUrl);
        } catch (IOException e) {
            System.out.println("Failed to delete image file: " + imageUrl);
            e.printStackTrace();
        }
    }
}
