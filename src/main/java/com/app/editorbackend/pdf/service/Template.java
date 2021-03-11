package com.app.editorbackend.pdf.service;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column(columnDefinition = "TEXT")
    private String json;
    @Column
    private Integer rows;
    @Column
    private Integer columns;
    @Column
    private String height;
    @Column
    private String width;
    @Column
    private String format;
    @Column
    private String shape;
}