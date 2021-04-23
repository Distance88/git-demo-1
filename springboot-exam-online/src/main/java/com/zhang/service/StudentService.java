package com.zhang.service;

import com.zhang.pojo.Student;

/**
 * (Student)表服务接口
 *
 * @author Distance
 * @since 2021-01-21 17:22:58
 */
public interface StudentService {

    Student findStudentByUserName(String username);

}