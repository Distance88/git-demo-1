package com.zhang.service.impl;

import com.zhang.SpringbootTestWorkApplication;
import com.zhang.pojo.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Author: Distance
 * Date: 2021/04/22/22:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootTestWorkApplication.class})
class UserServiceImplTest {

    @Resource
    private UserServiceImpl userServiceImpl;

    @Test
    void findUserByName() {

        User user = userServiceImpl.findUserByName("admin");

        Assert.assertEquals(java.util.Optional.of(user.getAge()), java.util.Optional.of(23));

    }
}