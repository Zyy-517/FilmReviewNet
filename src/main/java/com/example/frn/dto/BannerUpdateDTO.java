package com.example.frn.dto;

import lombok.Data;

@Data
public class BannerUpdateDTO {
    private Integer id;
    private String title;
    private String content;
    private String post;
    private Integer sort;
}
