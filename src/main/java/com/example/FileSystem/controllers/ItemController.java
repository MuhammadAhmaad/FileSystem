package com.example.FileSystem.controllers;

import com.example.FileSystem.model.CreateFileRequestDTO;
import com.example.FileSystem.model.CreateFolderRequestDTO;
import com.example.FileSystem.model.CreateSpaceRequestDTO;
import com.example.FileSystem.services.ItemService;
import com.example.FileSystem.utils.FileSystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.FileSystem;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/space")
    public ResponseEntity<?> createSpace(@RequestBody CreateSpaceRequestDTO request) throws Exception{
        String response=itemService.createSpace(request);
        return ok(FileSystemUtil.prepeareAPIResponse(response));
    }


    @PostMapping("/folder")
    public ResponseEntity<?> createFolder(@RequestBody CreateFolderRequestDTO request) throws Exception{
        String response=itemService.createFolder(request);
        return ok(FileSystemUtil.prepeareAPIResponse(response));
    }

    @PostMapping("/file")
    public ResponseEntity<?> createFile(@RequestBody CreateFileRequestDTO request) throws Exception{
        String response=itemService.createFile(request);
        return ok(FileSystemUtil.prepeareAPIResponse(response));
    }

    @GetMapping("/fileMetaData")
    public ResponseEntity<?> getFileMetaData(@RequestParam("fileID") String fileId,@RequestParam("userEmail") String userEmail) throws Exception{
        String response=itemService.getFileMetaData(fileId,userEmail);
        return ok(FileSystemUtil.prepeareAPIResponse(response));
    }
}
