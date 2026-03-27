package com.example.frn.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.frn.dto.CategoryInsertDTO;
import com.example.frn.dto.CategoryUpdateDTO;
import com.example.frn.dto.PageDTO;
import com.example.frn.entity.Category;
import com.example.frn.service.CategoryService;
import com.example.frn.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("save")
    public R save(@RequestBody CategoryInsertDTO dto){
        //使用hutool包下的工具类将 dto=> entity
        Category category = BeanUtil.copyProperties(dto,Category.class);
        if (categoryService.save(category)){
            return R.ok(true);
        }else {
            return R.error(false);
        }
    }

    @PostMapping("remove/{cid}")
    public R remove(@PathVariable("cid") Integer cid){
        if (categoryService.removeById(cid))
            return R.ok(true);
        else
            return R.error(false);
    }

    @PostMapping("update")
    public R update(@RequestBody CategoryUpdateDTO dto){
        Category category = BeanUtil.copyProperties(dto, Category.class);
        if (categoryService.updateById(category))
            return R.ok(true);
        else
            return R.error(false);
    }

    @GetMapping("list")
    public R list(){
        return R.ok(categoryService.list());
    }
    @GetMapping("detail/{cid}")
    public R detail(@PathVariable Integer cid){
        Category category = categoryService.getById(cid);
        return R.ok(category);
    }

    @PostMapping("page")
    public R page(@RequestBody PageDTO dto){
        return R.ok(categoryService.page(dto.getPageNum(),dto.getPageSize()));
    }
}
