package com.example.FileSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileRequestDTO {
    private Long itemId;
    private String binaryContent;
}
