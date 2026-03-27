package com.example.frn.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.frn.dto.*;
import com.example.frn.entity.User;
import com.example.frn.service.UserService;
import com.example.frn.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("save")
    public R save(@RequestBody UserInsertDTO dto){
        User user = BeanUtil.copyProperties(dto, User.class);
        if (userService.save(user))
            return R.ok(true);
        else
            return R.error(false);
    }
    @PostMapping("update")
    public R update(@RequestBody UserUpdateDTO dto){
        User user = BeanUtil.copyProperties(dto, User.class);
        if (userService.updateById(user))
            return R.ok(true);
        else
            return R.error(false);
    }
    @PostMapping("modifyPassword")
    public R modifyPassword(@RequestBody UserModifyPasswordDTO dto){
        if (userService.modifyPassword(dto))
            return R.ok(true);
        else
            return R.error(false);
    }
    @PostMapping("modifyNospeakStatus")
    public R modifyNospeakStatus(@RequestBody UserUpdateNospeakStstusDTO dto){
        User user = BeanUtil.copyProperties(dto, User.class);
        if (userService.modifyNospeakStatus(user))
            return R.ok(true);
        else
            return R.error(false);
    }
    @PostMapping("remove/{id}")
    public R remove(@PathVariable("id") Integer id){
        if (userService.removeById(id))
            return R.ok(true);
        else
            return R.error(false);
    }
    @GetMapping("detail/{id}")
    public R detail(@PathVariable Integer id){
        return R.ok(userService.getById(id));
    }
    @PostMapping("page")
    public R page(@RequestBody UserPageDTO dto){
        return R.ok(userService.page(dto.getPageNum(),dto.getPageSize(),dto.getUsername(),dto.getNickName()));
    }
}
