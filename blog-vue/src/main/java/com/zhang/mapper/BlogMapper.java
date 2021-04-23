package com.zhang.mapper;

import com.zhang.pojo.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Blog)表数据库访问层
 *
 * @author Distance
 * @since 2020-09-20 20:32:32
 */
public interface BlogMapper {

    @Select("select * from blog limit #{startPage},5")
    List<Blog> selAllBlog(Integer startPage);

    @Select("select * from blog where id = #{id}")
    Blog selBlogById(Integer id);

    @Select("select * from blog where type = #{type}")
    List<Blog> selBlogByType(String type);

    @Select("select * from blog where label like CONCAT('%',#{label},'%')")
    List<Blog> selBlogByLabel(String label);


    @Insert("insert into blog values(default,#{title},#{content},#{charts},#{type},#{label},#{style},0,'°Distance',#{createtime})")
    void addBlog(Blog blog);

    @Select("select title from blog  ORDER BY views desc limit 0,5")
    List<String> selRecommendByViews();

    @Select("select count(*) from blog")
    int getLength();
}