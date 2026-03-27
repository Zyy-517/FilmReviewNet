package com.example.frn.dto;

import com.example.frn.entity.FilmMaker;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class FilmInsertDTO {
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

    //保存影片对应的类别ID
    private List<Integer> categoryIds;
    //保存影片对应的影人信息
    private List<FilmMaker> makerList;
}
