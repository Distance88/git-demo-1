package com.zhang.service;

import com.zhang.pojo.Blog;
import com.zhang.pojo.Label;
import com.zhang.pojo.Recommend;
import com.zhang.pojo.Type;

import java.util.List;

/**
 * (Blog)表服务接口
 *
 * @author Distance
 * @since 2020-11-06 10:21:20
 */
public interface BlogService {


    List<Blog> findAllBlog(Integer startPage);

    List<Blog> findAllBlogByUserId(Integer user_id,Integer pageNumber);

    void addBlog(Blog blog,Integer user_id);

    List<Type> findAllType();

    List<Label> findAllLabel();

    List<Recommend> findRecommendBlog();

    Blog findBlogById(Integer id);

    List<Blog> findRecentBlog();

    List<Blog> findBlogByCondition(Blog blog,String starTime,String endTime,Integer pageNumber,String keywords,Integer user_id);
}