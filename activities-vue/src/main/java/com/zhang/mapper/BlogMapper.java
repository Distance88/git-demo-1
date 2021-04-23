package com.zhang.mapper;

import com.zhang.pojo.Blog;
import com.zhang.pojo.Recommend;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (Blog)表数据库访问层
 *
 * @author Distance
 * @since 2020-11-06 10:21:20
 */
public interface BlogMapper {

    @Select("select blog.id,title,content,digest,charts,type,label,style,views,author,createtime,user.photo from (blog,user) " +
            "left join user_blog on user_blog.blog_id = blog.id " +
            "where user_blog.user_id = user.id")
    List<Blog> selAllBlog();


    @Select("select blog.id,title,content,digest,charts,type,label,style,views,author,createtime " +
            "from blog " +
            "left join user_blog on user_blog.blog_id = blog.id " +
            "where user_blog.user_id = #{user_id}")
    List<Blog> selAllBlogByUserId(Integer user_id);


    @Insert("insert into blog(id,title,digest,content,charts,type,label,style,views,author,createtime) " +
            "values(default,#{title},#{digest},#{content},#{charts},#{type},#{label},#{style},0,#{author},#{createtime})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void insertBlog(Blog blog);

    @Insert("insert into user_blog values(default,#{user_id},#{blog_id})")
    void insertUser_Blog(Integer user_id,Integer blog_id);


    @Select("select count(id) from blog")
    int getBlogLength();

    @Select("select count(blog.id) from blog " +
            "left join user_blog on user_blog.blog_id = blog.id " +
            "where user_blog.user_id = #{user_id}")
    int getBlogLengthByUserId(Integer user_id);

    @Select("select id,title from blog ORDER BY views desc limit 0,5")
    List<Recommend> selRecommendBlog();

    @Select("select id,title,content,digest,charts,type,label,style,views,author,createtime from blog where id = #{id}")
    Blog selBlogById(Integer id);

    @Update("update blog")
    void updateViews(Integer id);

    @Select("select title,createtime from blog " +
            "order by id desc limit 0,3")
    List<Blog> selRecentBlog();

    @Select("<script>" +
            "select blog.id,title,content,digest,charts,type,label,style,views,author,createtime " +
            "from blog "+
            "left join user_blog on user_blog.blog_id = blog.id " +
            "where " +
            "<if test=\"blog.label != null and blog.label !=''\">label like concat('%',#{blog.label},'%') </if>" +
            "<if test=\"blog.label != null and blog.label !=''\">or </if>" +
            "<if test=\"blog.type!=null and blog.type!=''\">type = #{blog.type} </if>" +
            "<if test=\"blog.type!=null and blog.type!=''\">or </if>" +
            "<if test=\"blog.style!=null and blog.style!=''\">style = #{blog.style} </if>" +
            "<if test=\"blog.style!=null and blog.style!=''\">or </if>" +
            "<if test=\"keywords!=null and keywords!=''\">title like concat('%',#{keywords},'%') </if>" +
            "<if test=\"keywords!=null and keywords!=''\">or </if>" +
            "<if test=\"starTime!=null and starTime!=''\" >createtime BETWEEN (#{starTime}) and (#{endTime}) </if>" +
            "and user_blog.user_id = #{user_id} limit #{pageNumber},5" +
            "</script>")
    List<Blog> selBlogByCondition(@Param("blog") Blog blog, @Param("starTime") String starTime,
                                  @Param("endTime") String endTime,@Param("pageNumber")Integer pageNumber,@Param("keywords") String keywords,
                                  @Param("user_id")Integer user_id);
}