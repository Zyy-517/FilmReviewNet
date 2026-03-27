package com.example.frn.dao;

import com.example.frn.entity.Score;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ScoreMapper {
    @Insert("insert into score(user_id, film_id, score) value (#{userId},#{filmId},#{score})")
    int insert(Score score);
    @Update("update score set score=#{score} where user_id=#{userId} and film_id=#{filmId}")
    int update(Score score);

    @Select("select count(id) from score where user_id=#{userId} and film_id=#{filmId}")
    int selectCount(Score score);
}
