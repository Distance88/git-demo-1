package com.zhang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhang.mapper.DeptMapper;
import com.zhang.mapper.UserMapper;
import com.zhang.pojo.Dept;
import com.zhang.pojo.User;
import com.zhang.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户信息表(User)表服务接口
 *
 * @author Distance
 * @since 2021-03-16 20:56:50
 */
@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserMapper userMapper;

    @Resource
    private DeptMapper deptMapper;

    @Override
    public User findUserByUserName(String username) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("username",username));
    }

    @Override
    public User findUserByUserNameAndPwd(User user) {

        Map<String,String> map = new HashMap<>();

        map.put("username",user.getUsername());
        map.put("password",user.getPassword());
        return userMapper.selectOne(new QueryWrapper<User>().allEq(map));
    }

    @Override
    public List<User> findAllUserSimpleInfo() {

        List<User> userList = userMapper.selectList(null);

        return userList;
    }

    @Override
    public List<User> findUserByCondition(User user) {


        QueryWrapper<User> wrapper = new QueryWrapper<User>();

        wrapper.like("username",user.getKeyWorld())
                .or()
                .between("create_time",user.getStartTime(),user.getEndTime())
                .or()
                .like("nickname",user.getKeyWorld());

        List<User> userList = userMapper.selectList(wrapper);

        return userList;
    }

    @Override
    public List<User> findUserByDeptId(Integer deptId) {

        QueryWrapper<Dept> wrapper = new QueryWrapper<Dept>();

        wrapper.select("id").like("ancestors", deptId);

        List<Dept> deptList = deptMapper.selectList(wrapper);
        List<Integer> ids = new ArrayList<>();
        if(deptList.size() == 0){
            ids.add(deptId);
        }


        for(int i=0;i<deptList.size();i++){

            ids.add(deptList.get(i).getId());
        }
        List<User> userList = userMapper.selectList(new QueryWrapper<User>().in("dept_id",ids));
        return userList;
    }

    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }
}