package com.zhang.mapper;

import com.zhang.pojo.Type;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Type)表数据库访问层
 *
 * @author Distance
 * @since 2020-09-24 09:16:54
 */
public interface TypeMapper {

    @Select("select * from type")
    List<Type> findAllType();
}