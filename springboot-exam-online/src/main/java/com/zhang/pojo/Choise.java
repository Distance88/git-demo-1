package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * (Choise)实体类
 *
 * @author Distance
 * @since 2021-01-24 19:06:22
 */
@Data
@Getter
@Setter
public class Choise implements Serializable {
    private static final long serialVersionUID = 601947528690004133L;

    
    private Integer id;
    
    private String question;
    
    private String answer;
    
    private String optiona;
    
    private String optionb;
    
    private String optionc;
    
    private String optiond;
    
    private Integer questiontype;
    
    private String type;
}