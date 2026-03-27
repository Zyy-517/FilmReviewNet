package com.example.frn.dao;

import com.example.frn.entity.Maker;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MakerMapper {
    @Insert("insert into maker(name, avatar, info, occupation, sex, nationality, award_record)"+
    "value (#{name},#{avatar},#{info},#{occupation},#{sex},#{nationality},#{awardRecord})")
    int insert(Maker maker);
    @Update("update maker set name=#{name},avatar=#{avatar},info=#{info},occupation=#{occupation},sex=#{sex},nationality=#{nationality},award_record=#{awardRecord} where id=#{id}")
    int updateById(Maker maker);
    @Update("update maker set is_delete=1 where id=#{param}")
    int deleteById(Integer id);
    @Select("select *from maker where id=#{param} and is_delete=0")
    Maker selectById(Integer id);
    List<Maker> selectListByName(@Param("name") String name);

    /**
     * 根据id列表查询多个影人信息
     * @param ids 影人ID列表
     * @return
     */
    List<Maker> selectListInIds(List<Integer> ids);
}
