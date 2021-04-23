package com.zhang.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhang.mapper.BlogMapper;
import com.zhang.mapper.LabelMapper;
import com.zhang.mapper.TypeMapper;
import com.zhang.pojo.Blog;
import com.zhang.pojo.Label;
import com.zhang.pojo.Recommend;
import com.zhang.pojo.Type;
import com.zhang.service.BlogService;
import com.zhang.utils.RedisUtil;
import com.zhang.utils.TimeUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * (Blog)表服务接口
 *
 * @author Distance
 * @since 2020-11-06 10:21:20
 */
@Service
public class BlogServiceImpl implements BlogService {


    @Resource
    private BlogMapper blogMapper;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private TimeUtils timeUtils;

    @Resource
    private TypeMapper typeMapper;

    @Resource
    private LabelMapper labelMapper;

    @Override
    public List<Blog> findAllBlog(Integer startPage) {
        String key = "blogList";
        Integer start = (startPage - 1) * 5;
        Integer end = start + 4;
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            List<Object> objects = redisUtil.lGet(key, start, end);
            return new ObjectMapper().convertValue(JSONArray.fromObject(objects), new TypeReference<List<Blog>>() {});
        }else{
            List<Blog> blogList = blogMapper.selAllBlog();
            redisUtil.lSet(key, JSONArray.fromObject(blogList),24);

            List<Blog> res = new LinkedList<>();
            for(int i=start;i<=(end >= blogList.size() ? blogList.size() - 1 : end)  ;i++){
                res.add(blogList.get(i));
            }
            return res;
        }
    }
    @Override
    public List<Blog> findAllBlogByUserId(Integer user_id,Integer pageNumber) {
        String key = "blog_user_"+user_id;
        Integer start = (pageNumber - 1) * 5;
        Integer end = start + 4;
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            List<Object> objects = redisUtil.lGet(key, start, end);
            return new ObjectMapper().convertValue(JSONArray.fromObject(objects), new TypeReference<List<Blog>>() {});
        }else{
            List<Blog> blogList = blogMapper.selAllBlogByUserId(user_id);
            redisUtil.lSet(key, JSONArray.fromObject(blogList),24);
            List<Blog> res = new LinkedList<>();
            for(int i=start;i<=(end >= blogList.size() ? blogList.size() - 1 : end)  ;i++){
                res.add(blogList.get(i));
            }
            return res;
        }

    }

    @Override
    public void addBlog(Blog blog,Integer user_id) {
        String key = "blogList";

        boolean hasKey = redisUtil.hasKey(key);
        String createTime = timeUtils.getCreateTime();
        blog.setCreatetime(createTime);
        blogMapper.insertBlog(blog);
        blogMapper.insertUser_Blog(user_id,blog.getId());
        Type type = typeMapper.selTypeByName(blog.getType());
        if(type == null){
            Type type1 = new Type();
            type1.setName(blog.getType());
            type1.setCount(1);
            typeMapper.insertType(type1);

            if(redisUtil.hasKey("typeList")){
                redisUtil.lSet("typeList",JSONArray.fromObject(type1),24);
            }
        }else{
            long remove = redisUtil.lRemove("typeList",1,JSONArray.fromObject(type).get(0));
            type.setCount(type.getCount()+1);
            redisUtil.lSet("typeList",JSONArray.fromObject(type),24);
            typeMapper.addTypeCount(blog.getType());
        }

        String[] labels = blog.getLabel().split(",");
        for (int i=0;i<labels.length;i++){

            Label label = labelMapper.selLabelByName(labels[i]);
            if(label == null){
                Label label1 = new Label();
                label1.setName(labels[i]);
                label1.setCount(1);
                labelMapper.insertLabel(label1);
                if(redisUtil.hasKey("labelList")){
                    redisUtil.lSet("labelList",JSONArray.fromObject(label1),24);
                }
            }else{
                redisUtil.lRemove("labelList",1,JSONArray.fromObject(label).get(0));
                label.setCount(label.getCount()+1);
                redisUtil.lSet("labelList",JSONArray.fromObject(label),24);
                labelMapper.addLabelCount(label.getName());
            }
        }
        if(hasKey){
            redisUtil.lSet(key,JSONArray.fromObject(blog),24);
        }
        String k = "blog_user_"+user_id;
        if(redisUtil.hasKey(k)){
            redisUtil.lSet(k,JSONArray.fromObject(blog),24);
        }
    }

    @Override
    public List<Type> findAllType() {
        String key = "typeList";
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            List<Object> objects = redisUtil.lGet(key, 0, -1);
            return new ObjectMapper().convertValue(JSONArray.fromObject(objects), new TypeReference<List<Type>>() {});
        }
        List<Type> typeList = typeMapper.selAllType();
        redisUtil.lSet(key,JSONArray.fromObject(typeList),24);
        return typeList;
    }

    @Override
    public List<Label> findAllLabel() {
        String key = "labelList";
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            List<Object> objects = redisUtil.lGet(key, 0, -1);
            return new ObjectMapper().convertValue(JSONArray.fromObject(objects), new TypeReference<List<Label>>() {});
        }
        List<Label> labelList= labelMapper.selAllLabel();
        redisUtil.lSet(key,JSONArray.fromObject(labelList),24);
        return labelList;
    }

    @Override
    public List<Recommend> findRecommendBlog() {

        String key = "recommendList";
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            List<Object> objects = redisUtil.lGet(key, 0, -1);
            return new ObjectMapper().convertValue(JSONArray.fromObject(objects), new TypeReference<List<Recommend>>() {});
        }
        List<Recommend> recommendList= blogMapper.selRecommendBlog();
        redisUtil.lSet(key,JSONArray.fromObject(recommendList),24);
        return recommendList;
    }

    @Override
    public Blog findBlogById(Integer id) {
        String key = "blog_"+id;
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            return new ObjectMapper().convertValue(redisUtil.get(key),Blog.class);
        }
        Blog blog = blogMapper.selBlogById(id);
        redisUtil.set(key,blog);
        return blog;
    }

    @Override
    public List<Blog> findRecentBlog() {
        String key = "recentBlog";
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            List<Object> objects = redisUtil.lGet(key, 0, -1);
            return new ObjectMapper().convertValue(JSONArray.fromObject(objects), new TypeReference<List<Blog>>() {});
        }
        List<Blog> blogList = blogMapper.selRecentBlog();
        redisUtil.lSet(key,JSONArray.fromObject(blogList),24);
        return blogList          ;
    }

    @Override
    public List<Blog> findBlogByCondition(Blog blog, String starTime, String endTime, Integer pageNumber, String keywords,Integer user_id) {

        return blogMapper.selBlogByCondition(blog,starTime,endTime,(pageNumber - 1) * 5,keywords,user_id);
    }

}