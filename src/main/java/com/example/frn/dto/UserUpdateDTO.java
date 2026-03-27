package com.example.frn.dto;

import lombok.Data;

@Data
public class UserUpdateDTO {
    private Integer id;
    private String username;
    //private String passwd;
    private String nickName;
    private String phone;
    private String email;
    private String avatar;
}
