package com.example.frn.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class News {
    private Integer id;
    private String title;
    private String content;
    private String source;
    private String post;
    private LocalDate releaseDate;
    private Integer isDelete;
    private LocalDateTime created;
    private LocalDateTime updated;
}