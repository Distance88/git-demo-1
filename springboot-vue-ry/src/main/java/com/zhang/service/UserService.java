package com.zhang.service;

import com.zhang.pojo.User;
import org.apache.shiro.SecurityUtils;

import java.util.List;

/**
 * 用户信息表(User)表服务接口
 *
 * @author Distance
 * @since 2021-03-16 20:56:49
 */
public interface UserService {

    User findUserByUserName(String username);

    User findUserByUserNameAndPwd(User user);

    List<User> findAllUserSimpleInfo();

    List<User> findUserByCondition(User user);

    List<User> findUserByDeptId(Integer deptId);

    void insertUser(User user);

    void deleteById(Integer id);
}