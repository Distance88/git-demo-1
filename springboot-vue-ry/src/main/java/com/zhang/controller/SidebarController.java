package com.zhang.controller;

import com.zhang.pojo.Sidebar;
import com.zhang.service.SidebarService;
import com.zhang.service.impl.SidebarServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Sidebar)表控制层
 *
 * @author Distance
 * @since 2021-03-18 09:20:53
 */
@RestController
@RequestMapping("sidebar")
public class SidebarController {
    /**
     * 服务对象
     */
    @Resource
    private SidebarServiceImpl sidebarService;


}