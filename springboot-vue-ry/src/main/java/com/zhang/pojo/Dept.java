package com.zhang.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;
import java.util.List;


/**
 * 部门表(Dept)实体类
 *
 * @author Distance
 * @since 2021-03-21 09:56:22
 */
@Data
@Getter
@Setter
public class Dept implements Serializable {
    private static final long serialVersionUID = -52372515085659102L;

    private Integer id;

    private Integer parentId;

    @TableField(select = false)
    private String ancestors;

    private String name;

    private Integer orderNum;

    @TableField(select = false)
    private String leader;

    @TableField(select = false)
    private String phone;

    @TableField(select = false)
    private String email;

    private String status;

    @TableField(select = false)
    private String delFlag;

    @TableField(select = false)
    private String createBy;

    private String createTime;

    @TableField(select = false)
    private String updateBy;

    @TableField(select = false)
    private String updateTime;

    @TableField(exist = false)
    private List<Dept> children;

    @TableField(exist = false)
    private String startTime;

    @TableField(exist = false)
    private String endTime;
}