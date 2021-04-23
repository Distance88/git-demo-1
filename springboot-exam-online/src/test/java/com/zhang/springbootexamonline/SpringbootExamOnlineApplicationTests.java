package com.zhang.springbootexamonline;

import com.zhang.mapper.ExamMapper;
import com.zhang.pojo.Choise;
import com.zhang.pojo.Exam;
import com.zhang.pojo.Student;
import com.zhang.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
class SpringbootExamOnlineApplicationTests {


    @Resource
    private StudentServiceImpl studentService;

    @Resource
    private ExamMapper examMapper;

    @Test
    void contextLoads() {

    }

}
