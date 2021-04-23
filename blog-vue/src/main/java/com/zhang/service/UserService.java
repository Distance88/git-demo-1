package com.zhang.service;

import com.zhang.pojo.User;

/**
 * (User)表服务接口
 *
 * @author Distance
 * @since 2020-10-08 20:52:46
 */
public interface UserService {

    User findUserByUserName(String username);
}