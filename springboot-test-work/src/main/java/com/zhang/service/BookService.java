package com.zhang.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.pojo.Book;

/**
 * (Book)表服务接口
 *
 * @author Distance
 * @since 2021-04-22 22:32:34
 */
public interface BookService {

    Page<Book> findBookList(String name,Integer tid,Integer current,Integer size);

}