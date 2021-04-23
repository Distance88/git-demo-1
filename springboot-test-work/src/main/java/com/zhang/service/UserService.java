package com.zhang.service;

import com.zhang.pojo.User;

/**
 * (User)表服务接口
 *
 * @author Distance
 * @since 2021-04-22 22:33:12
 */
public interface UserService {

    User findUserByName(String name);
}