package com.zhang.controller;

import com.zhang.pojo.Type;
import com.zhang.service.TypeService;
import com.zhang.service.impl.TypeServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Type)表控制层
 *
 * @author Distance
 * @since 2020-11-07 09:52:29
 */
@RestController
@RequestMapping("type")
public class TypeController {
    /**
     * 服务对象
     */
    @Resource
    private TypeServiceImpl typeService;


}