package com.example.frn.service.impl;

import com.example.frn.dao.NewsMapper;
import com.example.frn.dto.MakerPageDTO;
import com.example.frn.dto.NewsPageDTO;
import com.example.frn.entity.News;
import com.example.frn.service.NewsService;
import com.example.frn.vo.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public boolean save(News news) {
        return newsMapper.insert(news)>0;
    }

    @Override
    public boolean updateById(News news) {
        return newsMapper.updateById(news)>0;
    }

    @Override
    public boolean removeById(Integer id) {
        return newsMapper.deleteById(id)>0;
    }

    @Override
    public News getById(Integer id) {
        return newsMapper.selectById(id);
    }

    @Override
    public PageInfo<News> page(NewsPageDTO dto) {
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize());
        List<News> news=this.newsMapper.selectList(dto.getTitle());
        return new PageInfo<>(news);
    }

//    @Override
//    public List<News> list(String title) {
//        return null;
//    }
}
