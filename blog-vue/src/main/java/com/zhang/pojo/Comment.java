package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


/**
 * (Comment)实体类
 *
 * @author Distance
 * @since 2020-10-06 13:12:16
 */
@Data
@Getter
@Setter
public class Comment implements Serializable {
    private static final long serialVersionUID = 207394455161275343L;

    
    private Integer id;
    
    private Integer pid;
    
    private Integer blogid;
    
    private String author;
    
    private String replyname;
    
    private String content;
    
    private String medate;

    private List<Comment> childs;
}