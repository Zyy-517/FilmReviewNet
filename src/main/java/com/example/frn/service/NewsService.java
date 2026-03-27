package com.example.frn.service;

import com.example.frn.dto.NewsPageDTO;
import com.example.frn.entity.News;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface NewsService {
    boolean save(News news);
    boolean updateById(News news);
    boolean removeById(Integer id);
    News getById(Integer id);
    PageInfo<News> page(NewsPageDTO dto);
//    List<News> list(String title);


}
