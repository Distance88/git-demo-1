package com.zhang.mapper;

import com.zhang.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * (User)表数据库访问层
 *
 * @author Distance
 * @since 2020-10-08 20:52:46
 */
public interface UserMapper {


    @Select("select * from user where username=#{username}")
    User selUserByUserName(String username);
}