package com.example.frn.service.impl;

import com.example.frn.dao.ScoreMapper;
import com.example.frn.entity.Score;
import com.example.frn.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;
    @Override
    public boolean saveOrUpdate(Score score) {
        if (scoreMapper.selectCount(score) == 0){//先查询是否评分
            return scoreMapper.insert(score) >0;
        }
        else {
            return scoreMapper.update(score) >0;
        }
    }
}
