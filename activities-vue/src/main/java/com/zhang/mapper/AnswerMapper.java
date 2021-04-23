package com.zhang.mapper;

import com.zhang.pojo.Answer;
import com.zhang.pojo.ProAnswer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Answer)表数据库访问层
 *
 * @author Distance
 * @since 2020-10-23 18:11:16
 */
public interface AnswerMapper {


    @Select("select * from answer where pid = #{pid}")
    List<Answer> selAnswerByPid(Integer pid);

    @Insert("insert into answer values(default,#{pid},#{answer},#{author},#{time})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void insertAnswer(Answer answer);


    @Select("select p.title,a.author,a.answer,a.time " +
            "from problem p,answer a " +
            "where p.id = a.pid")
    List<ProAnswer> selAllAnswer();


}