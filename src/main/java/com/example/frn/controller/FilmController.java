package com.example.frn.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.frn.dto.FilmInsertDTO;
import com.example.frn.dto.FilmPageDTO;
import com.example.frn.dto.FilmUpdateDTO;
import com.example.frn.entity.Film;
import com.example.frn.service.FilmService;
import com.example.frn.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/film")
public class FilmController {
    @Autowired
    private FilmService filmService;
    @PostMapping("save")
    public R save(@RequestBody FilmInsertDTO dto){
//        Film film = BeanUtil.copyProperties(dto,Film.class);
        if (filmService.save(dto))
            return R.ok(true);
        else
            return R.ok(false);
    }
    @PostMapping("update")
    public R update(@RequestBody FilmUpdateDTO dto){
//        Film film = BeanUtil.copyProperties(dto,Film.class);
        if (filmService.updateById(dto))
            return R.ok(true);
        else
            return R.ok(false);
    }
    @PostMapping("remove/{id}")
    public R remove(@PathVariable Integer id){
        if (filmService.removeById(id))
            return R.ok(true);
        else
            return R.ok(false);
    }
    @GetMapping("detail/{id}")
    public R detail(@PathVariable Integer id){
        return R.ok(filmService.getById(id));
    }
    @PostMapping("page")
    public R page(@RequestBody FilmPageDTO dto){
        return R.ok(filmService.page(dto.getPageNum(),dto.getPageSize(),dto.getName(),dto.getCid()));
    }
}
