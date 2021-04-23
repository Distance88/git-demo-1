package com.zhang.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhang.mapper.UserMapper;
import com.zhang.pojo.User;
import com.zhang.service.UserService;
import com.zhang.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * (User)表服务接口
 *
 * @author Distance
 * @since 2020-10-08 20:52:46
 */
@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RedisUtil redisUtil;
    @Override
    public User findUserByUserName(String username) {
        String key = "user_"+username;
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            ObjectMapper objectMapper = new ObjectMapper();
            Object user = redisUtil.get(key);
            System.out.println("从缓存中读取---");
            return objectMapper.convertValue(user,User.class);
        }else {
            User user = userMapper.selUserByUserName(username);
            redisUtil.set(key,user,15);
            System.out.println("从数据库中读取---");
            return user;
        }
    }
}