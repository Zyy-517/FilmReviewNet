package com.example.frn.dto;

import lombok.Data;

@Data
public class AdminUpdateDTO {
    private Integer id;
    private String username;
    private String passwd;
    private String realName;
}
