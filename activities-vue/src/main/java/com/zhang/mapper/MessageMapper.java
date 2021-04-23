package com.zhang.mapper;

import com.zhang.pojo.Info;
import com.zhang.pojo.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Message)表数据库访问层
 *
 * @author Distance
 * @since 2020-10-20 10:39:17
 */
public interface MessageMapper {

    @Select("select * from message where pid = 0")
    List<Message> selAllMessage();

    @Select("select * from message where pid = #{id}")
    List<Message> selChildMessage(Integer id);

    @Insert("insert into message values(default,#{pid},#{author},#{email},#{content},#{medate},#{replyname})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void insertMessage(Message message);

    @Select("select author,content,medate from message " +
            "order by id desc limit 0,3")
    List<Message> selRecentMessage();
}