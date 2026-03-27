package com.example.frn.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserUpdateNospeakStstusDTO {
    private Integer id;
    private Integer nospeakStatus;//状态
    private LocalDateTime nospeakTime;//用户禁言时间
}
