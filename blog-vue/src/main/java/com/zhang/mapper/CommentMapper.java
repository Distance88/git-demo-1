package com.zhang.mapper;

import com.zhang.pojo.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Comment)表数据库访问层
 *
 * @author Distance
 * @since 2020-10-06 13:12:16
 */
public interface CommentMapper {

    @Select("select * from comment where blogid = #{blogId} and pid = 0")
    List<Comment> findCommentByBlogId(Integer blogId);

    @Select("select * from comment where pid = #{id}")
    List<Comment> findChildComment(Integer id);

    @Insert("insert into comment values(default,#{pid},#{blogid},#{author},#{replyname},#{content},#{medate})")
    void insertComment(Comment comment);
}