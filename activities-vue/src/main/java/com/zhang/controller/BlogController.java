package com.zhang.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhang.mapper.BlogMapper;
import com.zhang.mapper.TypeMapper;
import com.zhang.pojo.Blog;
import com.zhang.service.BlogService;
import com.zhang.service.OssService;
import com.zhang.service.impl.BlogServiceImpl;
import com.zhang.utils.CommonmarkUtil;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * (Blog)表控制层
 *
 * @author Distance
 * @since 2020-11-06 10:21:20
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
    private OssService ossService;

    @RequestMapping("getHomeList")
    public JSONObject getHomeList(){

        JSONObject object = new JSONObject();
        List<Blog> blogList = blogService.findAllBlog(1);
        int total = blogMapper.getBlogLength();
        object.put("code",200);
        object.put("msg","获取成功!");
        object.put("blogList",blogList);
        object.put("total",total);
        object.put("totalPage",total % 5 == 0 ?total / 5 : total / 5 + 1);
        object.put("typeList",blogService.findAllType());
        object.put("labelList",blogService.findAllLabel());
        object.put("recommendList",blogService.findRecommendBlog());
        return object;
    }

    @RequestMapping("getBlogList")
    public JSONObject getBlogList(Integer startPage){
        JSONObject object = new JSONObject();
        List<Blog> blogList = blogService.findAllBlog(startPage);
        object.put("code",200);
        object.put("msg","获取成功!");
        object.put("blogList",blogList);
        object.put("total",blogMapper.getBlogLength());
        return object;
    }
    @RequestMapping("addBlog")
    public JSONObject addBlog(@Param("blog") Blog blog, @Param("user_id") Integer user_id){
        CommonmarkUtil commonmarkUtil = new CommonmarkUtil();

        blog.setContent(commonmarkUtil.transferMarkDownToHtml(blog.getContent()));
        JSONObject object = new JSONObject();
        blogService.addBlog(blog,user_id);
        object.put("code",200);
        object.put("msg","添加成功!");
        return object;
    }

    @RequestMapping("uploadCharts")
    public JSONObject uploadCharts(MultipartFile multipartFile){
        JSONObject object = new JSONObject();
        String charts = ossService.uploadFile(multipartFile);
        object.put("code",200);
        object.put("charts",charts);
        return object;
    }
    @RequestMapping("getType")
    public JSONObject getType(){
        JSONObject object = new JSONObject();
        object.put("code",200);
        object.put("typeList",blogService.findAllType());
        return object;
    }

    @RequestMapping("getBlogById")
    public JSONObject getBlogById(Integer id){
        JSONObject object = new JSONObject();
        object.put("code",200);
        object.put("blog",blogService.findBlogById(id));
        return object;
    }

    @RequestMapping("getBlogListByCondition")
    public JSONObject getBlogListByCondition(Blog blog,String starTime,String endTime,Integer pageNumber,String keywords,Integer userId){

        JSONObject object = new JSONObject();
        List<Blog> blogList = blogService.findBlogByCondition(blog, starTime, endTime, pageNumber, keywords,userId);
        object.put("code",200);
        object.put("msg","”获取成功!");
        object.put("blogList",blogList);
        object.put("total",blogList.size());
        return object;
    }


    @RequestMapping("getBlogListByUserId")
    public JSONObject getBlogListByUserId(Integer userId,Integer pageNumber){
        JSONObject object = new JSONObject();
        List<Blog> blogList = blogService.findAllBlogByUserId(userId, pageNumber);
        object.put("code",200);
        object.put("blogList",blogList);
        object.put("total",blogMapper.getBlogLengthByUserId(userId));
        return object;
    }


    @RequestMapping("uploadImage")
    public JSONObject uploadImage(@Param("multipartFile")MultipartFile multipartFile, HttpServletRequest request){

        JSONObject object = new JSONObject();
        String url = ossService.uploadFile(multipartFile);
        object.put("code",200);
        object.put("url",url);
        return object;
    }

    @RequestMapping("deleteImage")
    public JSONObject deleteImage(String fileName){
        JSONObject object = new JSONObject();
        ossService.deleteFile(fileName);
        object.put("code",200);
        return object;
    }
}