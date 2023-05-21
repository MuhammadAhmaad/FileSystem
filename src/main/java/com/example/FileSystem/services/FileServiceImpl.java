package com.example.FileSystem.services;

import com.example.FileSystem.entity.File;
import com.example.FileSystem.entity.Item;
import com.example.FileSystem.model.FileRequestDTO;
import com.example.FileSystem.repoisotries.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileRepository fileRepository;
    @Override
    public File createFile(FileRequestDTO request) {
        File file = new File();
        file.setBinaryContent(request.getBinaryContent());
        file.setItem(new Item(request.getItemId()));
        return fileRepository.save(file);
    }
}
