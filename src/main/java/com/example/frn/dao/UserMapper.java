package com.example.frn.dao;

import com.example.frn.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into User(username, passwd, nick_name, phone, email, avatar) VALUE(#{username},#{password},#{nickName},#{phone},#{email},#{avatar}) ")
    int insert(User user);

    int updateById(User user);
    @Update("update user set is_delete=1 where id=#{param}")
    int deleteById(Integer id);
    @Update("update user set passwd=#{password} where id=#{id}")
    int updatePassword(User user);
    @Update("update user set nospeak_status=#{npspeakStatus},nospeak_time=#{nospeakTime} where id=#{id}")
    int updateNpspeakStatus(User user);
    @Select("select * from user where id=#{param} and is_delete=0")
    User selectById(Integer id);
    List<User> selectList(@Param("username") String username,@Param("nickname") String nickname);
}
