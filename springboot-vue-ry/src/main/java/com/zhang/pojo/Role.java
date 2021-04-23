package com.zhang.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * 角色信息表(Role)实体类
 *
 * @author Distance
 * @since 2021-03-23 11:02:45
 */
@Data
@Getter
@Setter
public class Role implements Serializable {
    private static final long serialVersionUID = -69760546634259245L;

    /**
    * 角色ID
    */
    private Long id;
    /**
    * 角色名称
    */
    private String name;
    /**
    * 角色权限字符串
    */
    private String permkey;
    /**
    * 显示顺序
    */
    private Integer sort;
    /**
    * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
    */
    @TableField(select = false)
    private String scope;
    /**
    * 角色状态（0正常 1停用）
    */
    private String status;
    /**
    * 删除标志（0代表存在 2代表删除）
    */
    @TableField(select = false)
    private String delFlag;
    /**
    * 创建者
    */
    @TableField(select = false)
    private String createBy;
    /**
    * 创建时间
    */
    private String createTime;
    /**
    * 更新者
    */
    @TableField(select = false)
    private String updateBy;
    /**
    * 更新时间
    */
    @TableField(select = false)
    private String updateTime;
    /**
    * 备注
    */
    private String remark;
}