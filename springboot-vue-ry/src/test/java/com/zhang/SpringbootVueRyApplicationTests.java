package com.zhang;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhang.mapper.UserMapper;
import com.zhang.pojo.Dept;
import com.zhang.pojo.User;
import com.zhang.service.DeptService;
import com.zhang.utils.TimeUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootVueRyApplicationTests {

    @Resource
    private TimeUtils timeUtils;

    @Resource
    private DeptService deptService;


    @Test
    void contextLoads() {

    }



}
