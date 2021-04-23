package com.zhang.service;

import com.zhang.pojo.Blog;
import com.zhang.pojo.Label;
import com.zhang.pojo.Type;

import java.util.List;

/**
 * (Blog)表服务接口
 *
 * @author Distance
 * @since 2020-09-20 20:32:32
 */
public interface BlogService {

    Blog findBlogById(Integer id);

    List<Blog> findAllBlog(Integer startPage);

    List<Blog> findBlogByType(String type);

    List<Blog> findBlogByLabel(String label);

    void insertBlog(Blog blog);

    List<String> findRecommendByViews();

    List<Type> findAllType();

    List<Label> findAllLabel();
}