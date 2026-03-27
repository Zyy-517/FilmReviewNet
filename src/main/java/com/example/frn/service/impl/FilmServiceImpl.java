package com.example.frn.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.example.frn.dao.FilmMapper;
import com.example.frn.dto.FilmInsertDTO;
import com.example.frn.dto.FilmUpdateDTO;
import com.example.frn.entity.Film;
import com.example.frn.entity.FilmCategory;
import com.example.frn.service.FilmService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmMapper filmMapper;
    @Transactional//保证save方法下的所以操作在同一个事务下进行
    @Override
    public boolean save(FilmInsertDTO dto) {
        Film film = BeanUtil.copyProperties(dto,Film.class);
        filmMapper.insert(film);
        //批量添加影片-类别
        List<FilmCategory> filmCategoryList = new LinkedList<>();
        dto.getCategoryIds().forEach(item ->{
            filmCategoryList.add(new FilmCategory(film.getId(),item));
        });
        //执行批量插入
        filmMapper.insertBatchFilmCategory(filmCategoryList);
        //批量添加影片-影人
        film.getMakerList().forEach(item ->{
            //设置 film_id
            item.setFilmId(film.getId());
        });
        filmMapper.insertBatchFilmMaker(film.getMakerList());
        return true;
    }

    @Transactional
    @Override
    public boolean updateById(FilmUpdateDTO dto) {
        Film film = BeanUtil.copyProperties(dto,Film.class);
        //更新电影表
        filmMapper.updateById(film);
        //更新电影类别
        filmMapper.deleteFilmCategory(film.getId());
        List<FilmCategory> filmCategoryList = new LinkedList<>();
        dto.getCategoryIds().forEach(item ->{
            filmCategoryList.add(new FilmCategory(film.getId(),item));
        });
        //执行批量插入
        filmMapper.insertBatchFilmCategory(filmCategoryList);
        //更新电影影人
        filmMapper.deleteFilmMaker(film.getId());
        film.getMakerList().forEach(item ->{
            //设置 film_id
            item.setFilmId(film.getId());
        });
        filmMapper.insertBatchFilmMaker(film.getMakerList());
        return true;
    }

    @Override
    public boolean removeById(Integer id) {
        return filmMapper.deleteById(id)>0;
    }

    @Override
    public Film getById(Integer id) {
        Film film = filmMapper.selectById(id);
        //查询打出1~5星的人数
        List<HashMap<String,Object>> scoreStatistics = filmMapper.selectScoreAndStatistics(id);
        int total = 0;
        for (HashMap<String,Object> item : scoreStatistics){
            int star = Integer.valueOf(item.get("star").toString());
            int count = Integer.valueOf(item.get("count").toString());
            total += count;
            // 对应的打分人数保存到数组对应的下标处
            film.getStatistics()[star] = count;
        }
        film.getStatistics()[0] = total;
        return film;
    }

    @Override
    public List<Film> list(String name, Integer id) {
        return filmMapper.list(name,id);
    }

    @Override
    public PageInfo<Film> page(Integer pageNum, Integer pageSize, String name, Integer cid) {
        PageHelper.startPage(pageNum,pageSize);
        List<Film> list=this.list(name,cid);
        return new PageInfo<>(list);
    }
}
