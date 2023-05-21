package com.example.FileSystem.services;

import com.example.FileSystem.entity.File;
import com.example.FileSystem.model.FileRequestDTO;

public interface FileService {
    File createFile(FileRequestDTO request);
}
