package com.example.frn.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.frn.dto.RankingListInsertDTO;
import com.example.frn.dto.RankingListPageDTO;
import com.example.frn.dto.RankingListUpdateDTO;
import com.example.frn.entity.RankingList;
import com.example.frn.service.RankingListService;
import com.example.frn.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ranking")
public class RankListController {
    @Autowired
    private RankingListService rankingListService;
    @PostMapping("save")
    public R save(@RequestBody RankingListInsertDTO dto){
        RankingList rankingList= BeanUtil.copyProperties(dto,RankingList.class);
        if (rankingListService.save(rankingList))
            return R.ok(true);
        else
            return R.error(false);
    }
    @PostMapping("update")
    public R update(@RequestBody RankingListUpdateDTO dto){
        RankingList rankingList= BeanUtil.copyProperties(dto,RankingList.class);
        if (rankingListService.updateById(rankingList))
            return R.ok(true);
        else
            return R.error(false);
    }
    @PostMapping("remove/{id}")
    public R remove(@PathVariable Integer id){
        if (rankingListService.removeById(id))
            return R.ok(true);
        else
            return R.error(false);
    }
    @GetMapping("detail/{id}")
    public R detail(@PathVariable Integer id){
        return R.ok(rankingListService.getById(id));
    }
    @PostMapping("page")
    public R page(@RequestBody RankingListPageDTO dto){
        return R.ok(rankingListService.page(dto));
    }
    @GetMapping("listFilm/{year}/{categoryName}")
    public R listFilm(@PathVariable Integer year,@PathVariable String categoryName){
        return R.ok(rankingListService.listFilm(year,categoryName));
    }
}
