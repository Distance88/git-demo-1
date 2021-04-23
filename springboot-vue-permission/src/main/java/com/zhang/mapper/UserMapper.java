package com.zhang.mapper;

import com.zhang.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author Distance
 * @since 2020-09-16 19:32:02
 */
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User selUserByUserName(String username);

    @Select("select * from user")
    List<User> selAllUser();

    @Select("select * from user where username = #{username} and password=#{password}")
    User selUserByUserNameAndPwd(String name,String pwd);
}