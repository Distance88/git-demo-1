package com.zhang.mapper;

import com.zhang.pojo.Blog;
import com.zhang.pojo.Type;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * (Type)表数据库访问层
 *
 * @author Distance
 * @since 2020-11-07 09:52:29
 */
public interface TypeMapper {


    @Select("select id,name,count from type")
    List<Type> selAllType();


    @Select("select id,name,count from type where name =#{name}")
    Type selTypeByName(String name);

    @Insert("insert into type(id,name,count) values(default,#{name},1)")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void insertType(Type type);

    @Update("update type set count = count + 1 where name = #{name}")
    void addTypeCount(String name);
}