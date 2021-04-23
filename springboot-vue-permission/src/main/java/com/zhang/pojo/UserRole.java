package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * (UserRole)实体类
 *
 * @author Distance
 * @since 2020-09-16 19:31:24
 */
@Data
@Getter
@Setter
public class UserRole implements Serializable {
    private static final long serialVersionUID = -29435932481010842L;

    
    private Integer id;
    
    private Integer userId;
    
    private Integer roleId;
}