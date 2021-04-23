package com.zhang.controller;

import com.zhang.pojo.Blank;
import com.zhang.service.BlankService;
import com.zhang.service.impl.BlankServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Blank)表控制层
 *
 * @author Distance
 * @since 2021-01-24 19:06:31
 */
@RestController
@RequestMapping("blank")
public class BlankController {
    /**
     * 服务对象
     */
    @Resource
    private BlankServiceImpl blankService;


}