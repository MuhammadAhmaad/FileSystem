package com.example.FileSystem.services;

import com.example.FileSystem.constants.FileSystemConstants;
import com.example.FileSystem.entity.Item;
import com.example.FileSystem.entity.PermissionGroup;
import com.example.FileSystem.enums.ItemType;
import com.example.FileSystem.exceptions.BusinessException;
import com.example.FileSystem.model.CreateFileRequestDTO;
import com.example.FileSystem.model.CreateFolderRequestDTO;
import com.example.FileSystem.model.CreateSpaceRequestDTO;
import com.example.FileSystem.model.FileRequestDTO;
import com.example.FileSystem.repoisotries.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private FileService fileService;

    @Override
    public String createSpace(CreateSpaceRequestDTO request) {
        Item item = createItem(request.getName(), ItemType.SPACE, request.getPermissionGroupId(), null);
        itemRepository.save(item);
        return FileSystemConstants.SUCCESS_RESPONSE_MESSAGE;
    }

    private Item createItem(String name, ItemType itemType, Long permissionGroupId, Item parent) {
        Item item = new Item();
        item.setName(name);
        item.setType(itemType);
        item.setPermissionGroup(new PermissionGroup(permissionGroupId));
        if (parent != null)
            item.setParent(parent);
        return item;
    }

    @Override
    public String createFolder(CreateFolderRequestDTO request) {
        permissionService.checkUserEditPermission(request.getUserEmail());
        Optional<Item> optionalParentItem = itemRepository.findById(request.getParentId());
        if (optionalParentItem.isEmpty()) {
            throw new BusinessException(FileSystemConstants.PARENT_NOT_FOUND_RESPONSE_CODE, FileSystemConstants.PARENT_NOT_FOUND_RESPONSE_MESSAGE);
        } else {
            if (!optionalParentItem.get().getType().equals(ItemType.SPACE))
                throw new BusinessException(FileSystemConstants.INVALID_PARENT_TYPE_RESPONSE_CODE, FileSystemConstants.INVALID_PARENT_TYPE_RESPONSE_MESSAGE);
            Item item = createItem(request.getName(), ItemType.FOLDER, request.getPermissionGroupId(), optionalParentItem.get());
            itemRepository.save(item);
            return FileSystemConstants.SUCCESS_RESPONSE_MESSAGE;
        }
    }

    @Override
    public String createFile(CreateFileRequestDTO request) throws IOException {
        permissionService.checkUserEditPermission(request.getUserEmail());
        Optional<Item> optionalParentItem = itemRepository.findById(request.getParentId());
        if (optionalParentItem.isEmpty()) {
            throw new BusinessException(FileSystemConstants.PARENT_NOT_FOUND_RESPONSE_CODE, FileSystemConstants.PARENT_NOT_FOUND_RESPONSE_MESSAGE);
        } else {
            if (!optionalParentItem.get().getType().equals(ItemType.FOLDER))
                throw new BusinessException(FileSystemConstants.INVALID_PARENT_TYPE_RESPONSE_CODE, FileSystemConstants.INVALID_PARENT_TYPE_RESPONSE_MESSAGE);
            Item item = createItem(request.getName(), ItemType.FILE, request.getPermissionGroupId(), optionalParentItem.get());
            item =itemRepository.save(item);
            saveFileToDB(request.getBinaryContent(),item.getId());
            return FileSystemConstants.SUCCESS_RESPONSE_MESSAGE;
        }
    }

    @Override
    public String getFileMetaData(String fileId, String userEmail) {
        return itemRepository.getFileMetaData(fileId,userEmail);
    }

    private void saveFileToDB(String binaryContent,Long itemId) throws IOException {
        FileRequestDTO fileRequestDTO = new FileRequestDTO();
        fileRequestDTO.setBinaryContent(binaryContent);
        fileRequestDTO.setItemId(itemId);
        fileService.createFile(fileRequestDTO);
    }
}
