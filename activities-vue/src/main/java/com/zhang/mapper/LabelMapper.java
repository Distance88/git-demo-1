package com.zhang.mapper;

import com.zhang.pojo.Label;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * (Label)表数据库访问层
 *
 * @author Distance
 * @since 2020-11-07 13:27:02
 */
public interface LabelMapper {

    @Select("select id,name,count from label")
    List<Label> selAllLabel();

    @Select("select id,name,count from label where name=#{name}")
    Label selLabelByName(String name);

    @Insert("insert into label(id,name,count) values(default,#{name},1)")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void insertLabel(Label label);

    @Update("update label set count = count + 1 where name = #{name}")
    void addLabelCount(String name);
}