package com.zhang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhang.pojo.Dept;
import org.springframework.stereotype.Repository;

/**
 * 部门表(Dept)表数据库访问层
 *
 * @author Distance
 * @since 2021-03-21 09:56:22
 */
@Repository
public interface DeptMapper extends BaseMapper<Dept> {


}