package com.zhang.service.impl;

import com.zhang.mapper.StudentMapper;
import com.zhang.pojo.Student;
import com.zhang.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Student)表服务接口
 *
 * @author Distance
 * @since 2021-01-21 17:22:58
 */
@Service
public class StudentServiceImpl implements StudentService {


    @Resource
    private StudentMapper studentMapper;

    @Override
    public Student findStudentByUserName(String username) {
        return studentMapper.selStudentByUserName(username);
    }
}