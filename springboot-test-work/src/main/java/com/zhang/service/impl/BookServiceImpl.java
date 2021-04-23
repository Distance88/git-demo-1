package com.zhang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.mapper.BookMapper;
import com.zhang.pojo.Book;
import com.zhang.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Book)表服务接口
 *
 * @author Distance
 * @since 2021-04-22 22:32:34
 */
@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public Page<Book> findBookList(String name, Integer tid, Integer current, Integer size) {

        Page<Book> page = new Page<>(current,size);

        QueryWrapper<Book> wrapper = new QueryWrapper<>();

        wrapper.eq("name",name)
               .or()
               .eq("tid",tid);



        return (Page<Book>) bookMapper.selectPage(page,wrapper);
    }
}