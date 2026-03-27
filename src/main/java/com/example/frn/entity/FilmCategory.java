package com.example.frn.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FilmCategory{
    private Integer id;
    private Integer filmId;
    private Integer categoryId;
    private Integer isDelete;
    private LocalDateTime created;
    private LocalDateTime updated;

    public FilmCategory(Integer filmId, Integer categoryId) {
        this.filmId = filmId;
        this.categoryId = categoryId;
    }
}