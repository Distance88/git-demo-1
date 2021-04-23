package com.zhang.mapper;

import com.zhang.pojo.Student;
import org.apache.ibatis.annotations.Select;

/**
 * (Student)表数据库访问层
 *
 * @author Distance
 * @since 2021-01-21 17:22:57
 */
public interface StudentMapper {

    Student selStudentByUserName(String username);

}