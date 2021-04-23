package com.zhang.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhang.mapper.MenuMapper;
import com.zhang.mapper.UserMapper;
import com.zhang.pojo.Menu;
import com.zhang.pojo.User;
import com.zhang.service.UserService;
import com.zhang.utils.RedisUtil;
import net.sf.json.JSONArray;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * (User)表服务接口
 *
 * @author Distance
 * @since 2020-10-26 16:21:40
 */
@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserMapper userMapper;

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public User findUserByUserName(String username) {

        return userMapper.selUserByUserName(username);
    }

    @Override
    public void changeUserInfoByUserId(User user) {
        userMapper.updateUserInfoByUserId(user);
    }

    public List<Menu> findMenuByUserName(String username){
        String key = "menu_"+username;
        boolean hasKey = redisUtil.hasKey(key);
        if(hasKey){
            List<Object> objects = redisUtil.lGet(key, 0, -1);
            return new ObjectMapper().convertValue(JSONArray.fromObject(objects), new TypeReference<List<Menu>>() {});
        }else{
            List<Menu> menus = userMapper.findMenuByUserName(username);
            List<Menu> menuList = new LinkedList<>();
            for(Menu menu:menus){
                List<Menu> childs = menuMapper.findChilds(menu.getId());
                menu.setChilds(childs);
                menuList.add(menu);
            }
            redisUtil.lSet(key, JSONArray.fromObject(menuList),24);
            return menuList;
        }

    }
}