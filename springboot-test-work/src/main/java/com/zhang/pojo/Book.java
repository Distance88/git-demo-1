package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * (Book)实体类
 *
 * @author Distance
 * @since 2021-04-22 22:32:32
 */
@Data
@Getter
@Setter
public class Book implements Serializable {
    private static final long serialVersionUID = 784160788914979910L;

    
    private Integer id;
    
    private String name;
    
    private String author;
    
    private Integer tid;
    
    private Double price;
    
    private String descri;
    
    private String photo;
    
    private String pubdate;
}