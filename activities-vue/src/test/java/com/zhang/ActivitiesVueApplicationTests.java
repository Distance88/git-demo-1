package com.zhang;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhang.mapper.InfoMapper;
import com.zhang.pojo.Info;
import com.zhang.pojo.ProAnswer;
import com.zhang.pojo.Problem;
import com.zhang.service.AnswerService;
import com.zhang.service.InfoService;
import com.zhang.service.impl.ProblemServiceImpl;
import com.zhang.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.relational.core.sql.In;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

@SpringBootTest
class ActivitiesVueApplicationTests {

    @Resource
    private ProblemServiceImpl problemService;

    @Resource
    private InfoService infoService;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private InfoMapper infoMapper;

    @Resource
    private AnswerService answerService;

    @Test
    void contextLoads() throws IOException {
        System.out.println('=');
    }

}
