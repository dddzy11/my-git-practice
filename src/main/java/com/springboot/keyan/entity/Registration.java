package com.springboot.keyan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Registration extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "regisuserid", type = IdType.AUTO)
    private Integer regisuserid;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户类型1.管理员，2.用户
     */
    private Integer type;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String reasons;

    /**
     * 申请时间
     */
    private Date appltime;

    /**
     * 0,待审核1.同意，2拒绝
     */
    private Integer state;

    /**
     * 审核意见
     */
    private String stateans;

    /**
     * 审核人ID
     */
    private Integer audituserid;


}
