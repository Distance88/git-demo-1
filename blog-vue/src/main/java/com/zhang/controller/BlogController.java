package com.zhang.controller;

import com.zhang.mapper.BlogMapper;
import com.zhang.mapper.CommentMapper;
import com.zhang.mapper.LabelMapper;
import com.zhang.mapper.TypeMapper;
import com.zhang.pojo.Blog;
import com.zhang.pojo.Comment;
import com.zhang.pojo.Label;
import com.zhang.pojo.Type;
import com.zhang.service.BlogService;
import com.zhang.service.impl.BlogServiceImpl;
import com.zhang.utils.CommonmarkUtil;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Blog)表控制层
 *
 * @author Distance
 * @since 2020-09-20 20:32:33
 */
@RestController
@RequestMapping("blog")
public class BlogController {
    /**
     * 服务对象
     */
    @Resource
    private BlogServiceImpl blogService;

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private TypeMapper typeMapper;

    @Resource
    private LabelMapper labelMapper;

    @Resource
    private CommentMapper commentMapper;


    public List<Type> getTypeList(){
        return blogService.findAllType();
    }
    public List<Label> getLabelList(){
        return blogService.findAllLabel();

    }public List<String> getRecommendList(){
        return blogService.findRecommendByViews();
    }
    @RequestMapping("getBlogList")
    public JSONObject getBlogList(Integer startPage){
        JSONObject object = new JSONObject();

        List<Blog> blogList = blogService.findAllBlog(startPage);
        object.put("code",200);
        object.put("msg","获取博客列表成功!");
        object.put("blogList",blogList);
        object.put("typeList",getTypeList());
        object.put("labelList",getLabelList());
        object.put("recommendList",getRecommendList());
        object.put("length",blogMapper.getLength());

        return object;
    }

    @RequestMapping("getBlogById")
    public JSONObject getBlogById(Integer id){
        JSONObject object = new JSONObject();
        Blog blog = blogService.findBlogById(id);
        object.put("code",200);
        object.put("msg","获取博客内容成功!");
        object.put("blog",blog);
        return object;
    }

    @RequestMapping("addComment")
    public JSONObject addComment(Comment comment){
        JSONObject object = new JSONObject();
        commentMapper.insertComment(comment);
        object.put("code",200);
        object.put("msg","添加评论成功!");
        return object;
    }

    @RequestMapping("getBlogByType")
    public JSONObject getBlogByType(String type){
        JSONObject object = new JSONObject();

        List<Blog> blogList = blogService.findBlogByType(type);
        if(blogList.size() != 0){
            object.put("code",200);
            object.put("msg","根据类型获取博客列表成功!");
            object.put("blogList",blogList);
            object.put("typeList",getTypeList());
            object.put("labelList",getLabelList());
            object.put("recommendList",getRecommendList());
            object.put("length",blogMapper.getLength());
            return object;
        }
        object.put("code",500);
        object.put("msg","没有数据!");
        object.put("blogList",blogList);
        object.put("typeList",getTypeList());
        object.put("labelList",getLabelList());
        object.put("recommendList",getRecommendList());
        return object;
    }

    @RequestMapping("getBlogByLabel")
    public JSONObject getBlogByLabel(String label){
        JSONObject object = new JSONObject();
        List<Blog> blogList = blogService.findBlogByLabel(label);
        if(blogList.size() != 0){
            object.put("code",200);
            object.put("msg","根据标签获取博客列表成功!");
            object.put("blogList",blogList);
            object.put("length",blogMapper.getLength());
            object.put("typeList",getTypeList());
            object.put("labelList",getLabelList());
            object.put("recommendList",getRecommendList());
            return object;
        }
        object.put("code",500);
        object.put("msg","没有数据!");
        object.put("typeList",getTypeList());
        object.put("labelList",getLabelList());
        object.put("recommendList",getRecommendList());
        return object;
    }

    @RequestMapping("addBlog")
    public JSONObject addBlog(Blog blog){
        JSONObject object = new JSONObject();
        CommonmarkUtil commonmarkUtil = new CommonmarkUtil();
        String markDownToHtml = commonmarkUtil.transferMarkDownToHtml(blog.getContent());
        blog.setContent(markDownToHtml);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        blog.setCreatetime(simpleDateFormat.format(new Date()));
        blogService.insertBlog(blog);
        object.put("code",200);
        object.put("msg","添加博客成功!");
        return object;
    }


}