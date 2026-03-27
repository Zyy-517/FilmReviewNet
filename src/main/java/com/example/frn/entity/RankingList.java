package com.example.frn.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RankingList {
    private Integer id;
    private Integer year;
    private String categoryName;
    private String filmIdList;
    private List<Film> filmList;
    private Integer isDelete;
    private LocalDateTime created;
    private LocalDateTime updated;
}