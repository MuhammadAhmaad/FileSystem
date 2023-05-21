package com.example.FileSystem.entity;

import com.example.FileSystem.enums.PermissionLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PERMISSION")
@SequenceGenerator(name = "PERMISSION_SEQ", sequenceName = "PERMISSION_SEQ", allocationSize = 1)
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERMISSION_SEQ")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "GROUP_ID",referencedColumnName = "ID")
    private PermissionGroup permissionGroup;
    private String userEmail;
    @Enumerated(EnumType.STRING)
    private PermissionLevel permissionLevel;
}
