package com.example.FileSystem.services;

import com.example.FileSystem.constants.FileSystemConstants;
import com.example.FileSystem.entity.Permission;
import com.example.FileSystem.enums.PermissionLevel;
import com.example.FileSystem.exceptions.BusinessException;
import com.example.FileSystem.exceptions.ForbiddenException;
import com.example.FileSystem.repoisotries.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public void checkUserEditPermission(String userEmail) {
        Optional<Permission> optionalPermission = permissionRepository.findByUserEmail(userEmail);
        if(optionalPermission.isPresent()){
            if(!optionalPermission.get().getPermissionLevel().equals(PermissionLevel.EDIT))
                throw new ForbiddenException(FileSystemConstants.FORBIDDEN_ERROR_RESPONSE_CODE,FileSystemConstants.FORBIDDEN_ERROR_RESPONSE_MESSAGE);
        }else{
            throw new BusinessException(FileSystemConstants.USER_NOT_FOUND_RESPONSE_CODE,FileSystemConstants.USER_NOT_FOUND_RESPONSE_MESSAGE);
        }
    }
}
