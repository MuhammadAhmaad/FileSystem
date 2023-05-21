package com.example.FileSystem.services;

import com.example.FileSystem.model.CreateFileRequestDTO;
import com.example.FileSystem.model.CreateFolderRequestDTO;
import com.example.FileSystem.model.CreateSpaceRequestDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ItemService {
    String createSpace(CreateSpaceRequestDTO request);
    String createFolder(CreateFolderRequestDTO request);
    String createFile(CreateFileRequestDTO request) throws IOException;
    String getFileMetaData(String fileId,String userEmail);
}
