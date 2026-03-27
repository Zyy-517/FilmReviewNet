package com.example.frn.dto;

import lombok.Data;

//用于接收分页参数的DTO
@Data
public class PageDTO {
    private Integer pageNum;
    private Integer pageSize;

    public PageDTO(){
        this.pageNum = 1;
        this.pageSize = 5;
    }
}
