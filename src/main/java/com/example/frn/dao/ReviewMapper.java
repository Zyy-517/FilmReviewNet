package com.example.frn.dao;

import com.example.frn.entity.Review;
import com.example.frn.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReviewMapper {
    @Insert("INSERT INTO review(content, user_id, film_id, review_id, status) " +
            "value (#{content}, #{userId}, #{filmId}, #{reviewId}, #{status})")
    int insert(Review review);

    @Update("UPDATE review set status=#{status} where id=#{id}")
    int updateStatus(@Param("id") Integer id, @Param("status") Integer status);

    @Update("UPDATE review set like_num=like_num+#{num} where id=#{id}")
    int updateLikeNum(@Param("id") Integer id, @Param("num") Integer num);

    @Update("UPDATE review set is_delete=1 where id=#{param}")
    int delete(Integer id);

    //在点赞表 like_table 中新增点赞记录
    @Insert("insert into like_table(user_id, review_id) value (#{param1},#{param2})")
    int insertLikeTable(int userId, int reviewId);

    //删除点赞表 like_table 中的点赞记录
    @Delete("delete from like_table where user_id=#{param1} and review_id=#{param2}")
    int deleteLikeTable(int userId ,int reviewId);

    //查询点赞记录
    @Select("select count(*) from like_table where user_id=#{param1} and review_id=#{param2} ")
    int countLikeTable(int userId ,int reviewId);

    @Select("select * from review where is_delete=0 and id=#{param}")
    @ResultMap("ReviewRM")
    Review selectById(Integer id);

    @Update("update review set view_times=view_times+1 where id=#{param}")
    int updateViewTimes(Integer id);

    /**
     * 查询某个评论下的回复
     * @param reviewId 评论ID
     * @return
     */
    @Select("select * from review where is_delete=0 and review_id=#{param} and status=1")
    //@ResultMap("ResultRM")
    @Results({
            @Result(
                    property = "user", column = "user_id", javaType = User.class,
                    one = @One(select = "com.example.frn.dao.UserMapper.selectById")
            )
    })
    List<Review> selectListByReviewId(Integer reviewId);

    List<Review> selectList(@Param("filmId") Integer filmId, @Param("userId") Integer userId, @Param("status") Integer status);
}
