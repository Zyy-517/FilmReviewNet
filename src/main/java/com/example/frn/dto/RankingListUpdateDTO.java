package com.example.frn.dto;

import lombok.Data;

@Data
public class RankingListUpdateDTO {
    private Integer id;
    private Integer year;
    private String categoryName;
    private String filmIdList;
}
