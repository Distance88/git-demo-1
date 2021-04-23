package com.zhang;

import com.zhang.mapper.LabelMapper;
import com.zhang.pojo.Blog;
import com.zhang.pojo.Label;
import com.zhang.pojo.Message;
import com.zhang.pojo.User;
import com.zhang.service.BlogService;
import com.zhang.service.MessageService;
import com.zhang.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
class BlogVueApplicationTests {

    @Resource
    private MessageService messageService;

    @Resource
    private BlogService blogService;
    
    @Resource
    private UserService userService;
    @Test
    void contextLoads() {
        List<Blog> blogList = blogService.findBlogByType("Linux");
        System.out.println(blogList);
    }
}
