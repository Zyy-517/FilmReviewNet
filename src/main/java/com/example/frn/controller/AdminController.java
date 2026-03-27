package com.example.frn.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.frn.dto.AdminInsertDTO;
import com.example.frn.dto.AdminUpdateDTO;
import com.example.frn.dto.PageDTO;
import com.example.frn.entity.Admin;
import com.example.frn.service.AdminService;
import com.example.frn.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 添加管理员信息
     * @param dto 管理员信息
     * @return
     */
    @PostMapping("save")
    public R save(@RequestBody AdminInsertDTO dto){
        Admin admin = BeanUtil.copyProperties(dto,Admin.class);
        if (adminService.save(admin))
            return R.ok(true);
        else
            return R.error(false);
    }
    @PostMapping("remove/{id}")
    public R remove(@PathVariable("id") Integer id){
        if (adminService.removeById(id))
            return R.ok(true);
        else
            return R.error(false);
    }
    @PostMapping("update")
    public R update(@RequestBody AdminUpdateDTO dto){
        Admin admin = BeanUtil.copyProperties(dto,Admin.class);
        if (adminService.updateById(admin))
            return R.ok(true);
        else
            return R.error(false);
    }
    @GetMapping("list")
    public R list(){
        return R.ok(adminService.list());
    }
    @GetMapping("detail/{id}")
    public R detail(@PathVariable("id") Integer cid){
        Admin admin = adminService.getById(cid);
        return R.ok(admin);
    }
    @PostMapping("page")
    public R page(@RequestBody PageDTO dto){
        return R.ok(adminService.page(dto.getPageNum(),dto.getPageSize()));
    }
}
