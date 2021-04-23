package com.zhang.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.pojo.Book;
import com.zhang.restful.Response;
import com.zhang.restful.ResponseResult;
import com.zhang.service.BookService;
import com.zhang.service.impl.BookServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Book)表控制层
 *
 * @author Distance
 * @since 2021-04-22 22:32:34
 */
@RestController
@RequestMapping("book")
@Api(value = "图书模块")
public class BookController {
    /**
     * 服务对象
     */
    @Resource
    private BookServiceImpl bookService;

    @ApiOperation(value = "书籍列表")
    @RequestMapping("list")
    public ResponseResult<Page<Book>> list(
            @ApiParam(value = "搜索书籍名")@RequestParam(defaultValue = "",required = false)String name,
            @ApiParam(value = "搜索书类型")@RequestParam(defaultValue = "-1",required = false)Integer tid,
            @ApiParam(value = "页码")@RequestParam(defaultValue = "1",required = false)Integer current,
            @ApiParam(value = "每页大小")@RequestParam(defaultValue = "2",required = false)Integer size){

        return Response.makeOKRsp(bookService.findBookList(name, tid, current, size));
    }
}