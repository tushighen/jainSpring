package com.example.jain.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/upload")
@MultipartConfig(fileSizeThreshold = 20971520)
@CrossOrigin(origins = "*")
public class FileUploadController {

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile uploadedFileRef) {
        String fileName = uploadedFileRef.getOriginalFilename();

        String path = "/Users/tushighen/Desktop/JAIN PNG" + fileName;

        byte[] buffer = new byte[1000];

        File outputFile = new File(path);

        FileInputStream reader = null;
        FileOutputStream writer = null;
        int totalBytes = 0;

        try {
            outputFile.createNewFile();

            reader = (FileInputStream)uploadedFileRef.getInputStream();

            writer = new FileOutputStream(outputFile);

            int bytesRead = 0;
            while ((bytesRead = reader.read(buffer)) != -1) {
                writer.write(buffer);
                totalBytes += bytesRead;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "File uploaded successfully! Totatl Bytes Read =" + totalBytes;
    }
}
