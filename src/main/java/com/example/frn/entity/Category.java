package com.example.frn.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Category {
    private Integer id;
    private String name;
    private Integer isDelete;
    private LocalDateTime created;
    private LocalDateTime updated;
}
