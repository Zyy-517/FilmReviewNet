package com.example.frn.entity;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Admin {
    private Integer id;
    private String username;
    private String passwd;
    private String realName;
    private Integer isDelete;
    private LocalDateTime created;
    private LocalDateTime updated;
}
