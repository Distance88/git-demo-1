package com.zhang.mapper;

import com.zhang.pojo.Label;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Label)表数据库访问层
 *
 * @author Distance
 * @since 2020-09-25 13:48:55
 */
public interface LabelMapper {

    @Select("select * from label")
    List<Label> findAllLabel();

}