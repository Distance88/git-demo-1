package com.zhang.mapper;

import com.zhang.pojo.Blank;
import com.zhang.pojo.Choise;
import com.zhang.pojo.Exam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Exam)表数据库访问层
 *
 * @author Distance
 * @since 2021-01-24 18:46:28
 */
public interface ExamMapper {

    void insertExam(@Param("exam")Exam exam);

    List<Choise> selChoiseByType(@Param("ids") Integer ids[],@Param("type")Integer type);

    List<Blank> selBlankByType(@Param("ids") Integer ids[],@Param("type")Integer type);


}