package com.zhang.service.impl;

import com.zhang.SpringbootVueRyApplication;
import com.zhang.pojo.User;
import com.zhang.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Author: Distance
 * Date: 2021/04/22/21:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootVueRyApplication.class})
class UserServiceImplTest {

    @Resource
    private UserServiceImpl userServiceImpl;

    @Test
    void findUserByUserName() {


        List<User> userList = userServiceImpl.findUserByDeptId(1);


        userList.forEach(System.out::println);
    }
}