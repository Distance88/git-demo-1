package com.zhang.shiro;

import com.zhang.mapper.StudentMapper;
import com.zhang.pojo.Student;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Author: Distance
 * Date: 2021/01/21/18:35
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    private StudentMapper studentMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String username= (String) authenticationToken.getPrincipal();

        Student student = studentMapper.selStudentByUserName(username);

        if(student == null){
            return null;
        }
        return new SimpleAuthenticationInfo(student,student.getPassword(),"");
    }
}
