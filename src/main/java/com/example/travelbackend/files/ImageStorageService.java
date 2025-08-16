package com.example.travelbackend.files;

// ImageStorageService.java


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Service
public class ImageStorageService {
    private final Path root = Paths.get("uploads/news");

    public ImageStorageService() throws IOException {
        Files.createDirectories(root);
    }

    public String saveNewsImage(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) return null;
        String original = file.getOriginalFilename();
        String ext = (original != null && original.contains(".")) ? original.substring(original.lastIndexOf('.')) : "";
        String name = UUID.randomUUID() + ext.toLowerCase();
        Files.copy(file.getInputStream(), root.resolve(name), StandardCopyOption.REPLACE_EXISTING);
        return "/files/news/" + name; // public URL
    }
}

