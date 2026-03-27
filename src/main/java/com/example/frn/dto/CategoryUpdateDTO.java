package com.example.frn.dto;

import lombok.Data;

/**
 * Date Transfer Object
 * 数据传输对象，用于接收客户端发送来的参数
 */
@Data
public class CategoryUpdateDTO {
    private Integer id;
    private String name;
}
