package com.example.frn.dto;

import lombok.Data;

@Data
public class UserModifyPasswordDTO {
    private Integer id;
    private String oldPassword;
    private String newPassword;
}
