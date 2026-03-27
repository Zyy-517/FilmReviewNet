package com.example.frn.dao;

import com.example.frn.entity.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NewsMapper {
    @Insert("insert into news(title, content, source, post, release_date) VALUE(#{title},#{content},#{source},#{post},#{releaseDate})")
    int insert(News news);
    @Update("update news set title=#{title},content=#{content},source=#{source},post=#{post},release_date=#{releaseDate} where id=#{id}")
    int updateById(News news);
    @Update("update news set is_delete=1 where id=#{param}")
    int deleteById(Integer id);
    @Select("select * from news where id=#{param} and is_delete=0")
    News selectById(Integer id);
    List<News> selectList(@Param("title") String title);
}
