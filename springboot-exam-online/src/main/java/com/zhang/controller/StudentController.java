package com.zhang.controller;

import com.zhang.pojo.Student;
import com.zhang.service.StudentService;
import com.zhang.service.impl.StudentServiceImpl;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Student)表控制层
 *
 * @author Distance
 * @since 2021-01-21 17:22:59
 */
@RestController
@RequestMapping("student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentServiceImpl studentService;


    @RequestMapping("login")
    public JSONObject login(Student student){
        JSONObject object = new JSONObject();

        UsernamePasswordToken token = new UsernamePasswordToken(student.getUsername(),student.getPassword());

        Subject subject = SecurityUtils.getSubject();

        try{
            subject.login(token);
            object.put("code",200);
            object.put("msg","登陆成功!");
            object.put("student",studentService.findStudentByUserName(student.getUsername()));
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