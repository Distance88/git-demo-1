package com.zhang.controller;

import com.zhang.pojo.Role;
import com.zhang.service.RoleService;
import com.zhang.service.impl.RoleServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Role)表控制层
 *
 * @author Distance
 * @since 2021-04-22 22:32:57
 */
@RestController
@RequestMapping("role")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private RoleServiceImpl roleService;


}