package com.zhang.controller;

import com.zhang.pojo.Post;
import com.zhang.restful.Response;
import com.zhang.restful.ResponseResult;
import com.zhang.service.PostService;
import com.zhang.service.impl.PostServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 岗位信息表(Post)表控制层
 *
 * @author Distance
 * @since 2021-03-23 09:44:56
 */
@RestController
@RequestMapping("post")
public class PostController {
    /**
     * 服务对象
     */
    @Resource
    private PostServiceImpl postService;

    @RequestMapping("findpostList")
    public ResponseResult<List<Post>> findpostList(){

        return Response.makeOKRsp(postService.findAllPost());
    }


    @RequestMapping("findPostByCondition")
    public ResponseResult<List<Post>> findPostByCondition(Post post){

        return Response.makeOKRsp(postService.findPostByCondition(post));
    }


}