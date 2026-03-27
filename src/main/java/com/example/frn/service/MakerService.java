package com.example.frn.service;

import com.example.frn.entity.Maker;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MakerService {
    /**
     * 添加影人信息
     * @param maker
     * @return
     */
    boolean save(Maker maker);

    /**
     * 更改影人信息
     * @param maker
     * @return
     */
    boolean updateById(Maker maker);

    /**
     * 移除影人信息
     * @param id
     * @return
     */
    boolean removeById(Integer id);

    /**
     * 查询信息
     * @param id
     * @return
     */
    Maker getById(Integer id);

    /**
     * 查询全部影人信息
     * @param name
     * @return
     */
    List<Maker> list(String name);

    /**
     * 分页操作
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    PageInfo<Maker> page(Integer pageNum,Integer pageSize,String name);
}
