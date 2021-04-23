package com.zhang.mapper;

import com.zhang.pojo.Menu;
import com.zhang.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author Distance
 * @since 2020-10-26 16:21:40
 */
public interface UserMapper {

    @Select("select user.*,role.name as role from user " +
            "left join (user_role,role) on user_role.user_id = user.id and user_role.role_id = role.id " +
            "where username = #{username}")
    User selUserByUserName(String username);

    @Select("select menu.id,menu.name,menu.path,menu.icon,menu.title,menu.pid from menu " +
            "left JOIN role_menu on menu.id = role_menu.menu_id " +
            "where role_menu.role_id in (select role_id from user " +
            "left join user_role on user.id = user_role.user_id " +
            "where username = #{username} ) and menu.pid = 0")
    List<Menu> findMenuByUserName(String username);


    @Update("update user set phone = #{phone},email = #{email},birthday=#{birthday},skill=#{skill},evaluate=#{evaluate} " +
            "where id = #{id}")
    void updateUserInfoByUserId(User user);

    @Update("update user set photo =#{photo} where id = #{id}")
    void changePhoto(String photo,Integer id);
}