package com.zhang.controller;

import com.zhang.pojo.User;
import com.zhang.service.UserService;
import com.zhang.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author Distance
 * @since 2021-04-22 22:33:12
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserServiceImpl userService;


}