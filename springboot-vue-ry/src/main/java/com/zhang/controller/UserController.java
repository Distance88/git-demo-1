package com.zhang.controller;

import com.zhang.pojo.User;
import com.zhang.restful.Response;
import com.zhang.restful.ResponseResult;
import com.zhang.service.SidebarService;
import com.zhang.service.impl.UserServiceImpl;
import com.zhang.utils.JwtUtils;
import net.sf.json.JSONObject;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 用户信息表(User)表控制层
 *
 * @author Distance
 * @since 2021-03-16 20:56:50
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
    private SidebarService sidebarService;

    @Autowired
    private JwtUtils jwtUtils;

    @RequestMapping("login")
    public JSONObject login(User user) throws UnsupportedEncodingException {

        JSONObject object = new JSONObject();


        User findUser = userService.findUserByUserNameAndPwd(user);

        if(findUser != null){

            object.put("code",200);
            object.put("msg","登陆成功");
            object.put("token",jwtUtils.sign(user.getUsername(),"123456"));
            object.put("sideBar",sidebarService.findAllSideBar());

            return object;

        }else {
            throw new UnauthorizedException();
        }

    }

    @RequestMapping("findUserList")
    public ResponseResult<List<User>> findUserList(){
        return Response.makeOKRsp(userService.findAllUserSimpleInfo());
    }

    @RequestMapping("findUserByCondition")
    public ResponseResult<List<User>> findUserByCondition(User user){
        return Response.makeOKRsp(userService.findUserByCondition(user));
    }

    @RequestMapping("findUserByDeptId")
    public ResponseResult<List<User>> findUserByDeptName(Integer deptId){

        return Response.makeOKRsp(userService.findUserByDeptId(deptId));
    }

    @RequestMapping("insertUser")
    public ResponseResult insertUser(User user){

        System.out.println(user);

        userService.insertUser(user);

        return Response.makeOKRsp();
    }

    @RequestMapping("deleteById")
    public ResponseResult deleteUserById(Integer id){
        userService.deleteById(id);

        return Response.makeOKRsp();
    }

}