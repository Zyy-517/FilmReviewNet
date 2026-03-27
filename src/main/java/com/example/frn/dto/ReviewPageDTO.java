package com.example.frn.dto;

import lombok.Data;

@Data
public class ReviewPageDTO extends PageDTO {
    private Integer filmId;
    private Integer userId;
    private Integer status;
}
