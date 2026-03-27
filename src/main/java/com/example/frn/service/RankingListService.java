package com.example.frn.service;

import com.example.frn.dto.RankingListPageDTO;
import com.example.frn.entity.Film;
import com.example.frn.entity.RankingList;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RankingListService {
    boolean save(RankingList rankingList);
    boolean updateById(RankingList rankingList);
    boolean removeById(Integer id);
    RankingList getById(Integer id);
    PageInfo<RankingList> page(RankingListPageDTO dto);

    /**
     * 查询**年度**类榜单的影片列表
     * @param year 年份
     * @param categoryName 类别
     * @return
     */
    List<Film> listFilm(Integer year,String categoryName);
}
