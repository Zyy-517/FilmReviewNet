package com.example.frn.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.example.frn.dao.UserMapper;
import com.example.frn.dto.UserModifyPasswordDTO;
import com.example.frn.entity.User;
import com.example.frn.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean save(User user) {
        String password=user.getPasswd();
        String secretPasswd = SecureUtil.md5(password);
        user.setPasswd(secretPasswd);
        return userMapper.insert(user)>0;
    }

    @Override
    public boolean removeById(Integer id) {
        return userMapper.deleteById(id)>0;
    }


    @Override
    public boolean updateById(User user) {
        return userMapper.updateById(user)>0;
    }

    @Override
    public boolean modifyPassword(UserModifyPasswordDTO dto) {
        //1.先判断旧密码对不对
        //从数据库中查到的加密之后的旧密码
        String secretPassword = userMapper.selectById(dto.getId()).getPasswd();
        //用户填写的旧密码 123456
        String oldPassword = dto.getOldPassword();
        // 旧密码不正确
        if (!SecureUtil.md5(oldPassword).equals(secretPassword))
            return false;
        //2.对密码进行加密
        User user = new User();
        user.setId(dto.getId());
        user.setPasswd(SecureUtil.md5(dto.getNewPassword()));
        return userMapper.updatePassword(user)>0;
    }

    @Override
    public boolean modifyNospeakStatus(User user) {
        return userMapper.updateNpspeakStatus(user)>0;
    }

    @Override
    public User getById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public PageInfo<User> page(Integer pageNum, Integer pageSize, String username, String nickname) {
        PageHelper.startPage(pageNum,pageSize);
        if (username!=null){
            username=username.trim();
        }
        if (nickname!=null)
            nickname=nickname.trim();
        List<User> list=userMapper.selectList(username,nickname);
        return new PageInfo<>(list);
    }
}
