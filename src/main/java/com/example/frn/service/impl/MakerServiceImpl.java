package com.example.frn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.example.frn.dao.MakerMapper;
import com.example.frn.entity.Maker;
import com.example.frn.service.MakerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MakerServiceImpl implements MakerService {
    @Autowired
    private MakerMapper makerMapper;
    @Override
    public boolean save(Maker maker) {
        return makerMapper.insert(maker) > 0;
    }

    @Override
    public boolean updateById(Maker maker) {
        return makerMapper.updateById(maker)>0;
    }

    @Override
    public boolean removeById(Integer id) {
        return makerMapper.deleteById(id)>0;
    }

    @Override
    public Maker getById(Integer id) {
        return makerMapper.selectById(id);
    }

    @Override
    public List<Maker> list(String name) {
        if (StrUtil.isBlank(name))
            return makerMapper.selectListByName(null);
        else
            return makerMapper.selectListByName(name);
    }

    @Override
    public PageInfo<Maker> page(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum,pageSize);
        List<Maker> makers = this.list(name);
        return new PageInfo<>(makers);
    }
}
