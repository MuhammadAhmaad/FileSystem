package com.example.FileSystem.repoisotries;

import com.example.FileSystem.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,Long> {
}
