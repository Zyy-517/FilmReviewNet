package com.example.frn.service.impl;

import com.example.frn.dao.BannerMapper;
import com.example.frn.entity.Banner;
import com.example.frn.service.BannerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;
    @Override
    public boolean save(Banner banner) {
        return bannerMapper.insert(banner)>0;
    }

    @Override
    public boolean updateById(Banner banner) {
        return bannerMapper.updateById(banner)>0;
    }

    @Override
    public boolean removeById(Integer id) {
        return bannerMapper.deleteById(id)>0;
    }

    @Override
    public Banner getById(Integer id) {
        return bannerMapper.selectById(id);
    }

    @Override
    public PageInfo<Banner> page(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        return new PageInfo<>(bannerMapper.selectList());
    }


}
