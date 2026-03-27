package com.example.frn.service;

import com.example.frn.entity.Admin;
import com.example.frn.entity.Category;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AdminService {
    /**
     * 保存管理员对象
     * @param admin 管理员实体对象
     * @return 成功返回ture，失败返回flase
     */
    boolean save(Admin admin);
    boolean removeById(Integer id);
    boolean updateById(Admin admin);
    //查询
    Admin getById(Integer id);
    List<Admin> list();
    PageInfo<Admin> page(int pageNum, int pageSize);
}
