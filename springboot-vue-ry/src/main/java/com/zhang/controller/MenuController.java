package com.zhang.controller;

import com.zhang.pojo.Menu;
import com.zhang.restful.Response;
import com.zhang.restful.ResponseResult;
import com.zhang.service.MenuService;
import com.zhang.service.impl.MenuServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单权限表(Menu)表控制层
 *
 * @author Distance
 * @since 2021-03-22 15:46:07
 */
@RestController
@RequestMapping("menu")
public class MenuController {
    /**
     * 服务对象
     */
    @Resource
    private MenuServiceImpl menuService;


    @RequestMapping("getMenuList")
    public ResponseResult<List<Menu>> getMenuList(){


        return Response.makeOKRsp(menuService.findAllMenu());
    }


}