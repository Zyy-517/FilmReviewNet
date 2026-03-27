package com.example.frn.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Film {
    private Integer id;
    private String name;
    private LocalDate releaseDate;
    private String country;
    private String language;
    private Integer length;
    private Float boxOffice;
    private  String info;
    private Integer status;
    private String ticketLink;
    private String cover;
    private String post;
    private String playLink;
    private String version;
    private Integer isDelete;
    private LocalDateTime created;
    private LocalDateTime updated;

    //新增影片类别和综合评分属性
    private List<Category> categoryList;
    private List<FilmMaker> makerList;
    private float score;
    //定义一个长度为6的数组，用来保存打分的总人数以及每颗星的人数
    private long[] statistics = new long[6];
}
