package com.zhang.controller;

import com.zhang.mapper.MenuMapper;
import com.zhang.mapper.UserMapper;
import com.zhang.pojo.Menu;
import com.zhang.pojo.User;
import com.zhang.service.OssService;
import com.zhang.service.UserService;
import com.zhang.service.impl.UserServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import netscape.javascript.JSObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * (User)表控制层
 *
 * @author Distance
 * @since 2020-10-26 16:21:40
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
    private UserMapper userMapper;

    @Resource
    private OssService ossService;

    @RequestMapping("login")
    public JSONObject login(User user){
        JSONObject object = new JSONObject();

        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            object.put("code",200);
            user = userService.findUserByUserName(user.getUsername());
            List<Menu> menuList = userService.findMenuByUserName(user.getUsername());
            object.put("user",user);
            object.put("menuList",menuList);
            object.put("msg","登陆成功!");
        }catch (UnknownAccountException e){
            object.put("code",500);
            object.put("msg","账号不存在!");
        }catch (IncorrectCredentialsException e){
            object.put("code",500);
            object.put("msg","密码错误!");
        }

        return object;
    }

    @RequestMapping("changeUserInfoByUserId")
    public JSONObject changeUserInfoByUserId(User user){
        JSONObject object = new JSONObject();
        userService.changeUserInfoByUserId(user);
        object.put("code",200);
        object.put("msg","修改成功!");
        return object;
    }

    @RequestMapping("changePhoto")
    public JSONObject changePhoto(MultipartFile multipartFile,Integer id){

        JSONObject object = new JSONObject();
        String photo = ossService.uploadFile(multipartFile);
        userMapper.changePhoto(photo,id);
        object.put("code",200);
        object.put("msg","更换成功!");
        object.put("photo",photo);
        return object;
    }
}