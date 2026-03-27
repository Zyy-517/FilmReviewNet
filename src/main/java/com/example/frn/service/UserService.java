package com.example.frn.service;

import com.example.frn.dto.UserModifyPasswordDTO;
import com.example.frn.entity.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
    boolean save(User user);
    boolean removeById(Integer id);
    boolean updateById(User user);
    boolean modifyPassword(UserModifyPasswordDTO dto);
    boolean modifyNospeakStatus(User user);
    User getById(Integer id);
    PageInfo<User> page(Integer pageNum,Integer pageSize,String username,String nickname);
}
