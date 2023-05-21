package com.example.FileSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PERMISSION_GROUP")
@SequenceGenerator(name = "PERMISSION_GROUP_SEQ", sequenceName = "PERMISSION_GROUP_SEQ", allocationSize = 1)
public class PermissionGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERMISSION_GROUP_SEQ")
    private Long id;
    private String groupName;
    public PermissionGroup(Long id){
        this.id =id;
    }
}
