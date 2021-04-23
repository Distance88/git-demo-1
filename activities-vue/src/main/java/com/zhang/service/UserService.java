package com.zhang.service;

import com.zhang.pojo.User;

/**
 * (User)表服务接口
 *
 * @author Distance
 * @since 2020-10-26 16:21:40
 */
public interface UserService {

    User findUserByUserName(String username);

    void changeUserInfoByUserId(User user);
}