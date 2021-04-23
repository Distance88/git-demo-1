package cn.edu.xcu.slm.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Author: Distance
 * Date: 2021/03/25/9:36
 */
@Configuration
@MapperScan("cn.edu.xcu.slm.mapper")
public class MyBatisConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {

        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();


        return paginationInterceptor;
    }
}
