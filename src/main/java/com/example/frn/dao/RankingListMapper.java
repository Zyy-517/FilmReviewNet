package com.example.frn.dao;

import com.example.frn.entity.News;
import com.example.frn.entity.RankingList;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RankingListMapper {
    @Insert("insert into ranking_list(year, category_name, film_id_list) VALUE(#{year},#{categoryName},#{filmIdList})")
    int insert(RankingList rankingList);
    @Update("update ranking_list set year=#{year},category_name=#{categoryName},film_id_list=#{filmIdList}" +
            " where id=#{id}")
    int updateById(RankingList rankingList);
    @Update("update ranking_list set is_delete=1 and id=#{param}")
    int deleteById(Integer id);
    @Select("select * from ranking_list where is_delete=0 and id=#{param}")
    RankingList selectById(Integer id);
    List<RankingList> selectList(@Param("year") Integer year,@Param("categoryName") String categoryName);


}
