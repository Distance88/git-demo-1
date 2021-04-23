package com.zhang.mapper;

import com.zhang.pojo.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Menu)表数据库访问层
 *
 * @author Distance
 * @since 2020-11-05 13:58:03
 */
public interface MenuMapper {

    @Select("select * from menu where pid = 0")
    List<Menu> findAllMenu();

    @Select("select * from menu where pid = #{pid}")
    List<Menu> findChilds(Integer pid);
}