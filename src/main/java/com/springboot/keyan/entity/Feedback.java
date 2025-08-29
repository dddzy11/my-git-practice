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
 * 反馈表
 * </p>
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Feedback extends Model {
    //mybatis的Model类作为基类，可以CRUD方法
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "feedbackid", type = IdType.AUTO)
    private Integer feedbackid;

    /**
     * 用户id
     */
    private Integer userid;

    /**
     * 反馈标题
     */
    private String quetitle;

    /**
     * 反馈内容
     */
    private String quecontent;

    /**
     * 反馈时间
     */
    private Date quetime;

    /**
     * 1待处理，.2已处理，3关闭
     */
    private Integer state;

    /**
     * 处理内容
     */
    private String reply;

    /**
     * 处理时间
     */
    private Date replytime;

    /**
     * 处理人ID
     */
    private Integer replyuserid;


}
