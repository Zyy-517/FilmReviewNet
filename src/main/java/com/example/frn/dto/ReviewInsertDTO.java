package com.example.frn.dto;

import lombok.Data;

@Data
public class ReviewInsertDTO {
    private String content;
    private Integer userId;
    private Integer filmId;
    private Integer reviewId;
}
