package com.example.frn.service;

import com.example.frn.dto.FilmInsertDTO;
import com.example.frn.dto.FilmUpdateDTO;
import com.example.frn.entity.Film;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface FilmService {
    boolean save(FilmInsertDTO dto);
    boolean updateById(FilmUpdateDTO dto);
    boolean removeById(Integer id);
    Film getById(Integer id);
    List<Film> list(String name,Integer id);
    PageInfo<Film> page(Integer pageNum,Integer pageSize,String name,Integer cid);
}
