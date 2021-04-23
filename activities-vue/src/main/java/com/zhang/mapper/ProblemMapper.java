package com.zhang.mapper;

import com.zhang.pojo.ProAnswer;
import com.zhang.pojo.Problem;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Problem)表数据库访问层
 *
 * @author Distance
 * @since 2020-10-15 20:40:06
 */
public interface ProblemMapper {


    @Select("select * from problem")
    List<Problem> selAllProblem();

    @Select("select count(id) from problem")
    int selCount();

    @Select("select id,title from problem")
    List<ProAnswer> selAllProAnswer();
}