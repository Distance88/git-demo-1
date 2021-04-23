package com.zhang.controller;

import com.zhang.pojo.User;
import com.zhang.service.UserService;
import com.zhang.service.impl.UserServiceImpl;
import com.zhang.utils.JwtUtils;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author Distance
 * @since 2020-09-16 19:32:03
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserServiceImpl userService;

    @Resource
    protected JwtUtils jwtUtils;

    @RequestMapping("login")
    public JSONObject login(User user){

        JSONObject object = new JSONObject();

        User userResult = userService.findUserByUserNameAndPwd(user.getUsername(), user.getPassword());

        object.put("code",200);
        object.put("msg","获取成功");
        object.put("data",userResult);
        return object;
    }

    @RequestMapping("findUserList")
    public JSONObject findUserList(){
        JSONObject object = new JSONObject();

        List<User> userList = userService.findAllUserSimpleInfo();
        if(userList.size() == 0){
            object.put("code",500);
            object.put("msg","暂无数据!");
            return object;
        }
        object.put("code",200);
        object.put("msg","获取数据成功!");
        object.put("userList",userList);
        object.put("length",userList.size());
        return object;
    }
}