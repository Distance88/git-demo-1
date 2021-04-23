package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


/**
 * (Message)实体类
 *
 * @author Distance
 * @since 2020-09-22 20:58:48
 */
@Data
@Getter
@Setter
public class Message implements Serializable {
    private static final long serialVersionUID = -52258385707149143L;

    
    private Integer id;
    
    private Integer pid;
    
    private String author;
    
    private String email;
    
    private String content;
    
    private String medate;

    private String replyname;


    private List<Message> childs;
}