package com.example.FileSystem.repoisotries;

import com.example.FileSystem.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item,Long> {
    @Query(value="select i.type from item i inner join permission_group pg on i.permission_group_id = pg.id inner join permission p on p.group_id = pg.id where i.id = :fileId and p.user_email = :userEmail",nativeQuery = true)
    String getFileMetaData(String fileId, String userEmail);
}
