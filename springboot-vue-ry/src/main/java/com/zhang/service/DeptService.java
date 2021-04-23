package com.zhang.service;

import com.zhang.pojo.Dept;

import java.util.List;

/**
 * 部门表(Dept)表服务接口
 *
 * @author Distance
 * @since 2021-03-21 09:56:22
 */
public interface DeptService {

    List<Dept> findAllDept();

    List<Dept> findDeptByCondition(Dept dept);
}