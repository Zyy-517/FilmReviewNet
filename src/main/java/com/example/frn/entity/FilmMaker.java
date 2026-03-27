package com.example.frn.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FilmMaker {
    private Integer id;
    private Integer filmId;
    private Integer makerId;
    private String name;
    private String role;
    private Integer sort;
    private Integer isDelete;
    private LocalDateTime created;
    private LocalDateTime updated;
}
