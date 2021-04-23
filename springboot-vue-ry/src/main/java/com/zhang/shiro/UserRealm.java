package com.zhang.shiro;

import com.zhang.pojo.User;
import com.zhang.service.UserService;
import com.zhang.utils.JwtUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Author: Distance
 * Date: 2021/03/17/8:22
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;


    /**
     * 必须重写此方法，不然会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String token = (String) authenticationToken.getPrincipal();

        String username = jwtUtils.getUsername(token);

        if (username == null) {
            throw new AuthenticationException("token invalid");
        }

        User user = userService.findUserByUserName(username);
        if (user == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (! jwtUtils.verify(token, username, user.getPassword())) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "userRealm");
    }
}
