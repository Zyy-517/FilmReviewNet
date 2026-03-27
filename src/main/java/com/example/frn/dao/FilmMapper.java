package com.example.frn.dao;

import com.example.frn.entity.Film;
import com.example.frn.entity.FilmCategory;
import com.example.frn.entity.FilmMaker;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface FilmMapper {
    //将数据库生成的代理主键值重新注入到插入的电影对象里
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @Insert("insert into film(name, release_date, country, language, length, box_office, info, status, ticket_link, cover, post, play_link, version) " +
            "value(#{name},#{releaseDate},#{country},#{language},#{length},#{boxOffice},#{info},#{status},#{ticketLink},#{cover},#{post},#{playLink},#{version}) ")
    int insert(Film film);

    @Update("update film set name=#{name},release_date=#{releaseDate},country=#{country},language=#{language},length=#{length}," +
            "box_office=#{boxOffice},info=#{info},status=#{status},ticket_link=#{ticketLink}," +
            "cover=#{cover},post=#{post},play_link=#{playLink},version=#{version} where id=#{id}")
    int updateById(Film film);

    @Update("update film set is_delete=1 where id=#{param}")
    int deleteById(Integer id);

    @ResultMap("RMFilm2")
    @Select("select *from film where id=#{param} and is_delete=0")
    Film selectById(Integer id);

    /**
     * 根据条件查询影片列表
     *
     * @param name       电影名称
     * @param categoryId 电影类别ID
     * @return
     */
    List<Film> list(@Param("name") String name, @Param("cid") Integer categoryId);

    @Select("select * from film where id in (${ids}) and is_delete=0")
    List<Film> selectListInIds(@Param("ids") String filmIdList);

    int insertBatchFilmCategory(List<FilmCategory> filmCategoryList);

    int insertBatchFilmMaker(List<FilmMaker> filmMakerList);

    //根据电影ID删除影片-类别表
    @Delete("delete from film_category where film_id=#{param}")
    int deleteFilmCategory(int filmId);
    //根据电影ID删除影片-影人表
    @Delete("delete from film_maker where film_id=#{param}")
    int deleteFilmMaker(int filmId);

    //定义一个分组查询的一个sql
        /*
    [
        {'star':1, 'count':7},
        {'star':2, 'count':3},
        {'star':3, 'count':2},
        {'star':4, 'count':3},
        {'star':5, 'count':4}
    ]
     */
    @Select("""
        select CONCAT(ROUND(score/2),'') as 'star', count(score) as 'count'
        from score where film_id=#{param} group by score order by star
    """)
    List<HashMap<String,Object>> selectScoreAndStatistics(int filmId);
}
