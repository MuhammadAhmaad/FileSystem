package com.example.FileSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FILE")
@SequenceGenerator(name = "FILE_SEQ", sequenceName = "FILE_SEQ", allocationSize = 1)
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILE_SEQ")
    private Long id;
    @Lob
    @Column(columnDefinition = "CLOB")
    private String binaryContent;
    @OneToOne
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")
    private Item item;
}
