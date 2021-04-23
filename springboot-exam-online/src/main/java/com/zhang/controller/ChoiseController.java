package com.zhang.controller;

import com.zhang.pojo.Choise;
import com.zhang.service.ChoiseService;
import com.zhang.service.impl.ChoiseServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Choise)表控制层
 *
 * @author Distance
 * @since 2021-01-24 19:06:22
 */
@RestController
@RequestMapping("choise")
public class ChoiseController {
    /**
     * 服务对象
     */
    @Resource
    private ChoiseServiceImpl choiseService;


}