package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


/**
 * (Menu)实体类
 *
 * @author Distance
 * @since 2020-11-05 13:58:03
 */
@Data
@Getter
@Setter
public class Menu implements Serializable {
    private static final long serialVersionUID = -97975562696395761L;

    
    private Integer id;
    
    private String name;
    
    private String path;
    
    private String icon;
    
    private String title;
    
    private Integer pid;
    
    private Integer uid;

    private List<Menu> childs;
}