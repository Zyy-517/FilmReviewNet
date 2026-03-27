package com.example.frn.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.frn.dto.NewsInsertDTO;
import com.example.frn.dto.NewsPageDTO;
import com.example.frn.dto.NewsUpdateDTO;
import com.example.frn.entity.News;
import com.example.frn.service.NewsService;
import com.example.frn.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @PostMapping("save")
    public R save(@RequestBody NewsInsertDTO dto){
        News news = BeanUtil.copyProperties(dto,News.class);
        if (newsService.save(news))
            return R.ok(true);
        else
            return R.error(false);
    }
    @PostMapping("update")
    public R update(@RequestBody NewsUpdateDTO dto){
        News news = BeanUtil.copyProperties(dto,News.class);
        if (newsService.updateById(news))
            return R.ok(true);
        else
            return R.error(false);
    }
    @PostMapping("remove/{id}")
    public R remove(@PathVariable Integer id){
        if (newsService.removeById(id))
            return R.ok(true);
        else
            return R.error(false);
    }
    @GetMapping("detail/{id}")
    public R detail(@PathVariable Integer id){
        return R.ok(newsService.getById(id));
    }
    @PostMapping("page")
    public R page(@RequestBody NewsPageDTO dto){
        return R.ok(newsService.page(dto));
    }



}
