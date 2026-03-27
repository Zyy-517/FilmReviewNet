package com.example.frn.service;

import com.example.frn.entity.Category;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 影片类别业务接口
 * @author ZhangYingYing
 * @date 2024/10/13
 */
public interface CategoryService {
    /**
     * 保存影片类别
     * @param category 类别实体对象
     * @return 成功返回ture，失败返回false
     */
    boolean save(Category category);

    /**
     * 根据ID删除类别
     * @param id 类别ID
     * @return 成功返回ture，失败返回false
     */
    boolean removeById(Integer id);

    /**
     * 根据ID更新类别
     * @param category 类别实体对象
     * @return 成功返回ture，失败返回false
     */
    boolean updateById(Category category);

    /**
     * 根据ID查询单个类别
     * @param id 类别ID
     * @return 未查询到返回null
     */
    Category getById(Integer id);

    /**
     * 查询全部的类型
     * @return
     */
    List<Category> list();

    /**
     * 分页查询类别
     * @param pageNum 当前页号
     * @param pageSize 每页显示条数
     * @return
     */
    PageInfo<Category> page(int pageNum, int pageSize);
}
