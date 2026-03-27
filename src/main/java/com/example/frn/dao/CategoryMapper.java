package com.example.frn.dao;

import com.example.frn.entity.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
//@Repository
public interface CategoryMapper {
    @Insert("INSERT INTO category(name) value(#{name})")
    int insert(Category category);
    //执行逻辑删除：更新对应记录的is_delete字段
    @Update("UPDATE category set is_delete=1 where ID=#{param}")
    int deleteById(Integer id);
    @Update("UPDATE category set name=#{name} where ID=#{id}")
    int updateById(Category category);

    @Select("select * from category where is_delete=0")
    List<Category> list();
    @Select("select *from category where is_delete=0 and ID=#{param}")
    Category selectById(Integer id);
}
