package com.zhang.mapper;

import com.zhang.pojo.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Message)表数据库访问层
 *
 * @author Distance
 * @since 2020-09-22 20:58:48
 */
public interface MessageMapper {

    @Select("select * from message where pid = 0")
    List<Message> selAllMessage();

    @Select("select * from message where pid = #{id}")
    List<Message> selChildMessage(Integer id);

    @Insert("insert into message values(default,#{pid},#{author},#{email},#{content},#{medate},#{replyname})")
    void insertMessage(Message message);

}