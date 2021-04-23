package com.zhang.service.impl;

import com.zhang.mapper.RoleMapper;
import com.zhang.mapper.UserMapper;
import com.zhang.pojo.Role;
import com.zhang.pojo.User;
import com.zhang.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * (User)表服务接口
 *
 * @author Distance
 * @since 2020-09-16 19:32:03
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Override
    public User findUserByUserName(String username) {
        return userMapper.selUserByUserName(username);
    }

    @Override
    public User findUserInfoByUserName(String username) {
        User user = userMapper.selUserByUserName(username);
        List<Role> roleList = roleMapper.findRoleListByUserId(user.getId());
        user.setRoleList(roleList);
        return user;
    }

    @Override
    public List<User> findAllUserSimpleInfo() {
        List<User> userArray = userMapper.selAllUser();
        List<User> userList = new LinkedList<>();
        for (User user: userArray) {
            List<Role> roleList = roleMapper.findRoleListByUserId(user.getId());
            user.setRoleList(roleList);
            userList.add(user);
        }
        return userList;
    }

    @Override
    public User findUserByUserNameAndPwd(String username, String password) {
        return userMapper.selUserByUserNameAndPwd(username,password);
    }
}