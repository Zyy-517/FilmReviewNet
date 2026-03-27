package com.example.frn.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.example.frn.dao.AdminMapper;
import com.example.frn.entity.Admin;
import com.example.frn.entity.Category;
import com.example.frn.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.security.Security;
import java.util.List;

@Service
//对当前Service数据操作开启缓存
@Cacheable("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper mapper;
    @Override
    //让当前Service缓存块中的缓存数据都失效
    @CacheEvict(allEntries = true)
    public boolean save(Admin admin){
        //密钥明文 例如：123456
        String passwd = admin.getPasswd();
        //对密码进行加密 例如：76A7D777CF78
        String secretPasswd = SecureUtil.md5(passwd);
        admin.setPasswd(secretPasswd);
        return mapper.insert(admin) > 0;
    }

    @Override
    @CacheEvict(allEntries = true)
    public boolean removeById(Integer id) {
        return mapper.deleteById(id) > 0;
    }

    @Override
    //@CacheEvict(key = "#admin.id")
    @CacheEvict(allEntries = true)
    public boolean updateById(Admin admin) {
        admin.setPasswd(SecureUtil.md5(admin.getPasswd()));
        return mapper.UpdateById(admin) > 0;
    }

    @Override
    //将当前方法返回结果放入缓存块
    @CachePut(key = "#root.methodName")
    public Admin getById(Integer id) {
        return mapper.SelectById(id);
    }

    @Override
    @CachePut(key = "#root.methodName")
    public List<Admin> list() {
        return mapper.list();
    }

    @Override
    @CachePut(key = "#root.methodName + 'pn='+ pageNum+'ps='+pageSize")
    public PageInfo<Admin> page(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Admin> list = mapper.list();
        return new PageInfo<>(list);
    }
}
