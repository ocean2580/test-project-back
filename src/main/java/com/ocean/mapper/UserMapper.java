package com.ocean.mapper;

import com.ocean.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from sys_user")
    List<User> findAll();

    @Insert("insert into sys_user (username, password, nickname, email, phone, address) " +
            "VALUES (#{username},#{password},#{nickname},#{email},#{phone},#{address})")
    Integer insert(User user);


    int update(User user);

    @Delete("delete from sys_user where id = #{id}")
    int deleteById(@Param("id") Integer id);    // 指定参数

    @Select("select * from sys_user where username like concat('%', #{username}, '%') limit #{pageNum}, #{pageSize}")
    List<User> selectPage(@Param("pageNum") Integer num, @Param("pageSize") Integer size, @Param("username") String name);

    @Select("select count(*) from sys_user where username like concat('%', #{username}, '%')")
    Integer selectTotal(@Param("username")String name);
}
