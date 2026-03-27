package com.example.frn.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.frn.dto.BannerInsertDTO;
import com.example.frn.dto.BannerUpdateDTO;
import com.example.frn.dto.PageDTO;
import com.example.frn.entity.Banner;
import com.example.frn.service.BannerService;
import com.example.frn.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @PostMapping("save")
    public R save(@RequestBody BannerInsertDTO dto){
        Banner banner = BeanUtil.copyProperties(dto,Banner.class);
        if (bannerService.save(banner))
            return R.ok(true);
        else
            return R.error(false);
    }
    @PostMapping("update")
    public R update(@RequestBody BannerUpdateDTO dto){
        Banner banner = BeanUtil.copyProperties(dto,Banner.class);
        if (bannerService.updateById(banner))
            return R.ok(true);
        else
            return R.error(false);
    }
    @PostMapping("remove/{id}")
    public R remove(@PathVariable("id") Integer id){
        if (bannerService.removeById(id))
            return R.ok(true);
        else
            return R.error(false);
    }
    @GetMapping("detail/{id}")
    public R detail(@PathVariable("id") Integer id){
        return R.ok(bannerService.getById(id));
    }
    @PostMapping("page")
    public R page(@RequestBody PageDTO dto){
        return R.ok(bannerService.page(dto.getPageNum(),dto.getPageSize()));
    }
}
