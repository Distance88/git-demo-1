package com.zhang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhang.mapper.UserMapper;
import com.zhang.pojo.User;
import com.zhang.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (User)表服务接口
 *
 * @author Distance
 * @since 2021-04-22 22:33:12
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /*
    * @Description: 根据name属性获取User
    * @author: 张耀行
    * @date: 2021/4/22 22:43
    * @param name: name
    * @Return: User
    */
    @Override
    public User findUserByName(String name) {


        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.eq("name",name);

        User user = userMapper.selectOne(wrapper);


        return user;
    }
}