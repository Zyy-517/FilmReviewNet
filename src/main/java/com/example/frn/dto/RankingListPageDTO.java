package com.example.frn.dto;

import lombok.Data;

@Data
public class RankingListPageDTO extends PageDTO{
    private Integer year;
    private String categoryName;
}
