package com.example.frn.dto;

import lombok.Data;

@Data
public class ReviewUpdateDTO {
    private Integer id;
    private String content;
    private Integer userId;
    private Integer filmId;
    private Integer reviewId;
    private Integer status;
    private Integer likeNum;
}
