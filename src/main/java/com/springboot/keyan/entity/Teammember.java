package com.springboot.keyan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Teammember extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "teamid", type = IdType.AUTO)
    private Integer teamid;

    /**
     * 成员ID
     */
    private Integer memid;

    /**
     * 成员名称
     */
    private String memname;

    /**
     * 职务
     */
    private String job;

    /**
     * 个人信息
     */
    private String meminfo;

    /**
     * 研究方向
     */
    private String searchdir;

    /**
     * 科研介绍
     */
    private String searchinfo;

    /**
     * 联系方式
     */
    private String phonenum;

    /**
     * 学术背景
     */
    private String searchbg;

    /**
     * 科研成果
     */
    private String searchresults;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 0,待审核1.同意，2拒绝
     */
    private Integer state;

    /**
     * 审核意见
     */
    private String opinion;

    /**
     * 审核人
     */
    private Integer audituserid;


}
