package com.example.FileSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFileRequestDTO {
    private String name;
    private Long parentId;
    private String userEmail;
    private Long permissionGroupId;
    private String binaryContent;
}
