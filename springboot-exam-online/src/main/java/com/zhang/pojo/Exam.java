package com.zhang.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;
import java.util.List;


/**
 * (Exam)实体类
 *
 * @author Distance
 * @since 2021-01-24 18:46:28
 */
@Data
@Getter
@Setter
public class Exam implements Serializable {
    private static final long serialVersionUID = 182111476974351515L;

    
    private String id;
    
    private String starttime;
    
    private String endtime;
    
    private Integer examtype;
    
    private Integer xzt1;
    
    private Integer xzt2;
    
    private Integer xzt3;
    
    private Integer xzt4;
    
    private Integer xzt5;
    
    private Integer tkt1;
    
    private Integer tkt2;
    
    private Integer tkt3;
    
    private Integer tkt4;
    
    private Integer tkt5;

    private Integer choiceIds[];

    private Integer blankIds[];

}