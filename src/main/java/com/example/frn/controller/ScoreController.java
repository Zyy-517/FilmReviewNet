package com.example.frn.controller;

import cn.hutool.core.bean.BeanUtil;
import com.example.frn.dto.ScoreDTO;
import com.example.frn.entity.Score;
import com.example.frn.service.ScoreService;
import com.example.frn.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    @PostMapping("save")
    public R save (@RequestBody ScoreDTO dto){
        Score score = BeanUtil.copyProperties(dto,Score.class);
        if (scoreService.saveOrUpdate(score))
            return R.ok("成功");
        else
            return R.error("失败");
    }
}
