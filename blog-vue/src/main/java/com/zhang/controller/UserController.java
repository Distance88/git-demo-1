package com.zhang.controller;

import com.zhang.pojo.User;
import com.zhang.service.UserService;
import com.zhang.service.impl.UserServiceImpl;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author Distance
 * @since 2020-10-08 20:52:46
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserServiceImpl userService;

    @RequestMapping("login")
    public JSONObject login(User user){
        JSONObject object = new JSONObject();

        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());

        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            object.put("code",200);
            object.put("msg","登陆成功!");
        }catch (IncorrectCredentialsException e){
            object.put("code",500);
            object.put("msg","密码错误!");
        }catch (UnknownAccountException e){
            object.put("code",500);
            object.put("msg","账号不存在!");
        }

        return object;
    }
}