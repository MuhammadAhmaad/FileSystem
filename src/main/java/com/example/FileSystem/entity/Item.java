package com.example.FileSystem.entity;

import com.example.FileSystem.enums.ItemType;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ITEM")
@SequenceGenerator(name = "ITEM_SEQ", sequenceName = "ITEM_SEQ", allocationSize = 1)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_SEQ")
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private ItemType type;
    @ManyToOne
    @JoinColumn(name = "PERMISSION_GROUP_ID",referencedColumnName = "ID")
    private PermissionGroup permissionGroup;
    @ManyToOne(optional = true)
    @JoinColumn(name = "PARENT_ID",referencedColumnName = "ID")
    private Item parent;

    public Item(Long id){
        this.id=id;
    }
}
