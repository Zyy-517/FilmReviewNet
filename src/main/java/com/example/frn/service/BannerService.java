package com.example.frn.service;

import com.example.frn.entity.Banner;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BannerService {
    boolean  save(Banner banner);
    boolean updateById(Banner banner);
    boolean removeById(Integer id);
    Banner getById(Integer id);
    PageInfo<Banner> page(Integer pageNum,Integer pageSize);
}
