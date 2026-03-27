package com.example.frn.service.impl;

import com.example.frn.dao.CategoryMapper;
import com.example.frn.entity.Category;
import com.example.frn.service.CategoryService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper mapper;//展示注释
    @Override
    public boolean save(Category category) {
        return mapper.insert(category) > 0;
    }

    @Override
    public boolean removeById(Integer id) {
        return mapper.deleteById(id) > 0;
    }

    @Override
    public boolean updateById(Category category) {
        return mapper.updateById(category) > 0;
    }

    @Override
    public Category getById(Integer id) {
        return mapper.selectById(id);
    }

    @Override
    public List<Category> list() {
        return mapper.list();
    }

    @Override
    public PageInfo<Category> page(int pageNum, int pageSize) {
        //Page<Category> page = new Page<>(pageNum,pageSize);
        //先分页
        PageHelper.startPage(pageNum,pageSize);
        List<Category> list = mapper.list();
        return new PageInfo<>(list);
    }
}
