package com.zhang.shiro;


import com.zhang.filter.JwtFilter;
import com.zhang.shiro.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Auther: Distance
 * Date: 2020/09/16/19:39
 */
@Configuration
public class ShiroConfig{



    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultSecurityManager")DefaultWebSecurityManager defaultSecurityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultSecurityManager);

        Map<String, Filter> filterMap = new LinkedHashMap<>();

        filterMap.put("jwt",new JwtFilter());

        shiroFilterFactoryBean.setFilters(filterMap);

        shiroFilterFactoryBean.setFilters(filterMap);

        Map<String, String> filterRuleMap = new LinkedHashMap<>();
        // 所有请求通过我们自己的JWT Filter

        filterRuleMap.put("/user/login", "anon");
        filterRuleMap.put("/**", "jwt");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterRuleMap);
        return shiroFilterFactoryBean;
    }

    @Bean(name = "defaultSecurityManager")
    public DefaultWebSecurityManager getSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean(name = "userRealm")
    public UserRealm getUserRealm(){
        return new UserRealm();
    }
}
