package com.example.frn.dto;

import lombok.Data;

@Data
public class MakerInsertDTO {
    private String name;//姓名
    private String avatar;//头像
    private String info;//介绍
    private String occupation;//职业
    private Integer sex;//性别
    private String nationality;//国籍
    private String awardRecord;//获奖记录
}
