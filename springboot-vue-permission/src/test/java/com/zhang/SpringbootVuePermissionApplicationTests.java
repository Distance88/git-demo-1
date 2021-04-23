package com.zhang;

import com.zhang.pojo.User;
import com.zhang.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringbootVuePermissionApplicationTests {


    @Resource
    private UserService userService;
    @Test
    void contextLoads() {
        System.out.println(userService.findUserByUserName("admin"));
    }

    @Test
    void findUserInfo(){
        User user = userService.findUserInfoByUserName("admin");
        System.out.println(user);
    }

    @Test
    void findAllUser(){
        List<User> userList = userService.findAllUserSimpleInfo();
        System.out.println(userList);
    }
}
