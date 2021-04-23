package com.zhang.service;

import com.zhang.pojo.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author Distance
 * @since 2020-09-16 19:32:02
 */
public interface UserService {

    User findUserByUserName(String username);

    User findUserInfoByUserName(String username);

    List<User> findAllUserSimpleInfo();

    User findUserByUserNameAndPwd(String username,String password);
}