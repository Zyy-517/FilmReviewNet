package com.example.frn.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LikeMapper {
    @Insert("insert into like_table(user_id, review_id, created) value (#{param1}, #{param2}, now())")
    int insert(Integer userId, Integer reviewId);

    @Delete("delete from like_table where user_id=#{param1} and review_id=#{param2}")
    int delete(Integer userId, Integer reviewId);

    @Select("select count(0) from like_table where user_id=#{param1} and review_id=#{param2}")
    int count(Integer userId, Integer reviewId);
}
