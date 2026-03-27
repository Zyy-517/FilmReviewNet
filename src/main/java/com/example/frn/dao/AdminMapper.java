package com.example.frn.dao;

import com.example.frn.entity.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Insert("insert into admin(username,passwd,real_name) value(#{username},#{passwd},#{realName})")
    int insert(Admin admin);
    @Update("update admin set is_delete=1 where id=#{param}")
    int deleteById(Integer id);
    @Update("update admin set username=#{username},passwd=#{passwd},real_name=#{realName} where id=#{id}")
    int UpdateById(Admin admin);
    @Select("select*from admin where id=#{param} and is_delete=0")
    Admin SelectById(Integer id);
    @Select("select*from admin where is_delete=0")
    List<Admin> list ();
}
