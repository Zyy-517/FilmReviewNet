package com.example.frn.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.example.frn.dao.FilmMapper;
import com.example.frn.dao.RankingListMapper;
import com.example.frn.dto.RankingListPageDTO;
import com.example.frn.entity.Film;
import com.example.frn.entity.RankingList;
import com.example.frn.service.RankingListService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class RankingListServiceImpl implements RankingListService {
    @Autowired
    private RankingListMapper rankingListMapper;
    @Autowired
    private FilmMapper filmMapper;
    @Override
    public boolean save(RankingList rankingList) {
        return rankingListMapper.insert(rankingList)>0;
    }

    @Override
    public boolean updateById(RankingList rankingList) {
        return rankingListMapper.updateById(rankingList)>0;
    }

    @Override
    public boolean removeById(Integer id) {
        return rankingListMapper.deleteById(id)>0;
    }

    @Override
    public RankingList getById(Integer id) {
        RankingList rankingList = rankingListMapper.selectById(id);
        rankingList.setFilmList(filmMapper.selectListInIds(rankingList.getFilmIdList()));
        return rankingList;
    }

    @Override
    public PageInfo<RankingList> page(RankingListPageDTO dto) {
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize());
        List<RankingList> list=this.rankingListMapper.selectList(dto.getYear(), dto.getCategoryName());
        //每个榜单中都会保存完整的电影信息
        for (RankingList r : list) {
            r.setFilmList(filmMapper.selectListInIds(r.getFilmIdList()));
        }
        return new PageInfo<>(list);
    }


    @Override
    public List<Film> listFilm(Integer year, String categoryName) {
        List<RankingList> list = rankingListMapper.selectList(year,categoryName);
        //if (list!=null && list.size()>0)
        if (CollUtil.isNotEmpty(list)){
            RankingList rankingList = list.get(0);
            //找到电影ID列表：1.2.3.4
            //select * from film where id in (1,2,3) and is_delete=0
            String filmIdList = rankingList.getFilmIdList();
            if (StrUtil.isNotBlank(filmIdList))
                return filmMapper.selectListInIds(filmIdList);
        }
        //如果未找到该榜单电影信息，则返回空的电影列表
        return new LinkedList<>();
    }
}
