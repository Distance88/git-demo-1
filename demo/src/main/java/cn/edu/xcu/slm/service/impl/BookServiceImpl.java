package cn.edu.xcu.slm.service.impl;

import cn.edu.xcu.slm.entity.Book;
import cn.edu.xcu.slm.mapper.BookMapper;
import cn.edu.xcu.slm.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangyaohang
 * @since 2021-03-25
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

}
