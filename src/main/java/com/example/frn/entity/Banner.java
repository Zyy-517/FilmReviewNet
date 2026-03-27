package com.example.frn.entity;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Banner {//轮播图
    private Integer id;
    private String title;
    private String content;
    private String post;
    private Integer sort;
    private Integer isDelete;
    private LocalDateTime created;
    private LocalDateTime updated;
}