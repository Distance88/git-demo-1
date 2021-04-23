package cn.edu.xcu.slm.controller;


import cn.edu.xcu.slm.entity.Type;
import cn.edu.xcu.slm.service.ITypeService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangyaohang
 * @since 2021-03-25
 */
@RestController
@RequestMapping("/type")
public class TypeController {

    @Resource
    private ITypeService iTypeService;

    @RequestMapping("/findAll")
    public List<Type> findAll(){

        return iTypeService.list();
    }
}

