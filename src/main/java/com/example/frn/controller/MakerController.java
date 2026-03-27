package com.example.frn.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.frn.dto.MakerInsertDTO;
import com.example.frn.dto.MakerPageDTO;
import com.example.frn.dto.MakerUpdateDTO;
import com.example.frn.entity.Maker;
import com.example.frn.service.MakerService;
import com.example.frn.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/maker")
public class MakerController {
    @Autowired
    private MakerService makerService;
    @PostMapping("save")
    public R save(@RequestBody MakerInsertDTO dto){
        Maker maker = BeanUtil.copyProperties(dto,Maker.class);
        if (makerService.save(maker)){
            return R.ok(true);
        }
        else
            return R.error(false);
    }
    @PostMapping("update")
    public R update(@RequestBody MakerUpdateDTO dto){
        Maker maker = BeanUtil.copyProperties(dto,Maker.class);
        if (makerService.updateById(maker))
            return R.ok(true);
        else
            return R.error(false);
    }
    @PostMapping("remove/{id}")
    public R remove(@PathVariable("id") Integer id){
        if (makerService.removeById(id))
            return R.ok(true);
        else
            return R.error(false);
    }
    @GetMapping("detail/{id}")
    public R detail(@PathVariable("id") Integer id){
        return R.ok(makerService.getById(id));
    }
    @GetMapping("list")
    public R list(String name){
        return R.ok(makerService.list(name));
    }
    @PostMapping("page")
    public R page(@RequestBody MakerPageDTO dto){
        return R.ok(makerService.page(dto.getPageNum(),dto.getPageSize(),dto.getName()));
    }
}
