package com.springboot.keyan.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
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
public class Userlogin extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId
    private Integer userid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 1.管理员2.成员管理3.用户
     */
    private Integer type;

    /**
     * 注册时间
     */
    private Date regtime;

    /**
     * 1.未激活，2.激活
     */
    private Integer state;


}
