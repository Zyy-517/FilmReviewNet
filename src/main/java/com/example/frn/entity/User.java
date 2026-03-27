package com.example.frn.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;
    private String username;
    private String passwd;
    private String nickName;
    private String phone;
    private String email;
    private String avatar;
    private Integer nospeakStatus;
    private LocalDateTime nospeakTime;
    private Integer isDelete;
    private LocalDateTime created;
    private LocalDateTime updated;
}