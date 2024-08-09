package com.ziedgach.book.file;

import com.ziedgach.book.book.Book;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.io.File.separator;
import static java.lang.System.currentTimeMillis;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileStorageService {

    @Value("${application.file.upload.photos-output-path}")
    private String fileUploadPath;
    public String saveFile(
           @NotNull MultipartFile sourceFile,

           @NotNull Integer userId) {
        final  String fileUploadSubPath = "user" + separator + userId;
        return uploadFile(sourceFile,fileUploadSubPath);
    }

    private String uploadFile(
            @NotNull MultipartFile sourceFile,
            @NotNull String fileUploadSubPath) {
         final String finalUploadPath = fileUploadPath + separator + fileUploadSubPath;

         File targetFolder =  new File(finalUploadPath);
         if (!targetFolder.exists())
         {
             boolean folderCreated = targetFolder.mkdirs();
             if (!folderCreated)
             {
                 log.warn("failed to create the target folder");
                 return null;
             }
         }
         final String fileExtension = getFileExtension(sourceFile.getOriginalFilename());
         // ./uploads/user/1/1645562165465.jpg
         String targetFilePath = fileUploadPath + separator + currentTimeMillis() + "." +fileExtension;
        Path targetPath = Paths.get(targetFilePath);
        try {
            Files.write(targetPath,sourceFile.getBytes());
            log.info("file saved to " + targetFilePath);
            return targetFilePath;
        }catch (IOException e)
        {
            log.error("file was not saved ", e);

        }
        return null;
    }

    private String getFileExtension(String fileName) {
      if (fileName == null || fileName.isEmpty())
      {
          return "";
      }
      // something jpg
      int lastDotIndex = fileName.lastIndexOf(".");
      if (lastDotIndex == -1)
      {
          return "";
      }

        return fileName.substring(lastDotIndex + 1).toLowerCase();
    }
}
