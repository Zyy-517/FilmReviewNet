package com.example.frn.dao;

import com.example.frn.entity.Banner;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BannerMapper {
    @Insert("insert into banner(title, content, post, sort) value(#{title},#{content},#{post},#{sort}) ")
    int insert(Banner banner);
    @Update("update banner set title=#{title},content=#{content},post=#{post},sort=#{sort} where id=#{id} ")
    int updateById(Banner banner);
    @Update("update banner set is_delete=1 where id=#{param}")
    int deleteById(Integer id);
    @Select("select * from banner where id=#{param} and is_delete=0")
    Banner selectById(Integer id);
    @Select("select * from banner where is_delete=0")
    List<Banner> selectList();
}
