package com.zhang.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhang.mapper.BlogMapper;
import com.zhang.mapper.CommentMapper;
import com.zhang.mapper.LabelMapper;
import com.zhang.mapper.TypeMapper;
import com.zhang.pojo.Blog;
import com.zhang.pojo.Comment;
import com.zhang.pojo.Label;
import com.zhang.pojo.Type;
import com.zhang.service.BlogService;
import com.zhang.utils.RedisUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * (Blog)表服务接口
 *
 * @author Distance
 * @since 2020-09-20 20:32:32
 */
@Service
public class BlogServiceImpl implements BlogService {


    @Resource
    private BlogMapper blogMapper;

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private TypeMapper typeMapper;

    @Resource
    private LabelMapper labelMapper;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Blog findBlogById(Integer id) {
        String key = "blog_" + id;
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            Object blogsByType = redisUtil.get(key);

            return objectMapper.convertValue(blogsByType,Blog.class);
        }else {
            Blog blog = blogMapper.selBlogById(id);
            List<Comment> commentList = new LinkedList<>();
            List<Comment> comments = commentMapper.findCommentByBlogId(id);
            for(Comment comment:comments){
                List<Comment> childComment = commentMapper.findChildComment(comment.getId());
                comment.setChilds(childComment);
                commentList.add(comment);
            }
            blog.setCommentList(commentList);
            redisUtil.set(key,blog,15);
            return blog;
        }
    }
    @Override
    public List<Blog> findAllBlog(Integer startPage) {


        List<Blog> blogList = new LinkedList<>();

        List<Blog> blogs = blogMapper.selAllBlog(startPage);
        for (Blog blog : blogs){
            String[] strings = blog.getLabel().split(",");
            List<String> labelList = new LinkedList<>();
            for(String label:strings){
                labelList.add(label);
            }
            blog.setLabelList(labelList);

            blogList.add(blog);
        }
        return blogList;
    }

    @Override
    public List<Blog> findBlogByType(String type) {

        String key = "blog_" + type;
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            Object blogsByType = redisUtil.get(key);

            return objectMapper.convertValue(blogsByType,new TypeReference<List<Blog>>(){});
        }else {
            List<Blog> blogList = new LinkedList<>();

            List<Blog> blogs = blogMapper.selBlogByType(type);
            for (Blog blog : blogs){
                String[] strings = blog.getLabel().split(",");
                List<String> labelList = new LinkedList<>();
                for(String label:strings){
                    labelList.add(label);
                }
                blog.setLabelList(labelList);

                blogList.add(blog);
            }
            redisUtil.set(key,blogList,15);
            return blogList;
        }

    }

    @Override
    public List<Blog> findBlogByLabel(String label) {

        String key = "blog_" + label;
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            Object blogsByType = redisUtil.get(key);

            return objectMapper.convertValue(blogsByType,new TypeReference<List<Blog>>(){});
        }else {
            List<Blog> blogList = new LinkedList<>();

            List<Blog> blogs = blogMapper.selBlogByLabel(label);
            for (Blog blog : blogs){
                String[] strings = blog.getLabel().split(",");
                List<String> labelList = new LinkedList<>();
                for(String label1:strings){
                    labelList.add(label1);
                }
                blog.setLabelList(labelList);

                blogList.add(blog);
            }
            redisUtil.set(key,blogList,15);
            return blogList;
        }

    }

    @Override
    public void insertBlog(Blog blog) {
        blogMapper.addBlog(blog);
    }

    @Override
    public List<String> findRecommendByViews() {
        String key = "recommendList";
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            Object recommendList = redisUtil.get(key);
            return objectMapper.convertValue(recommendList, new TypeReference<List<String>>() {});
        }else {
            List<String> recommendList = blogMapper.selRecommendByViews();
            redisUtil.set(key,recommendList);
            return recommendList;
        }

    }

    @Override
    public List<Type> findAllType() {

        String key = "typeList";
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            Object typeList = redisUtil.get(key);
            return objectMapper.convertValue(typeList, new TypeReference<List<Type>>() {});
        }else {
            List<Type> typeList = typeMapper.findAllType();
            redisUtil.set(key,typeList);
            return typeList;
        }
    }

    @Override
    public List<Label> findAllLabel() {
        String key = "labelList";
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            Object labelList = redisUtil.get(key);
            return objectMapper.convertValue(labelList, new TypeReference<List<Label>>() {});
        }else {
            List<Label> labelList = labelMapper.findAllLabel();
            redisUtil.set(key,labelList);
            return labelList;
        }
    }
}