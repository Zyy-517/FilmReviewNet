package com.example.frn.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Score {
    private Integer id;
    private Integer userId;
    private Integer filmId;
    private Integer score;
    private Integer isDelete;// is_delete
    private LocalDateTime created;
    private LocalDateTime updated;
}
