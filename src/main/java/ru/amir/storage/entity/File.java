package ru.amir.storage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author Amir Khusnutdinov
 */
@Data
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;

    @Column(name = "content")
    private byte[] file;

    @Column(name = "title")
    private String title;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "description")
    private String description;
}
