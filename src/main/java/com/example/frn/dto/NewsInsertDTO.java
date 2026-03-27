package com.example.frn.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NewsInsertDTO {
    private String title;
    private String content;
    private String source;
    private String post;
    private LocalDate releaseDate;
}
