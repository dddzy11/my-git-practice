package com.springboot.keyan.service;

import com.springboot.keyan.entity.Teammember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.keyan.util.ResultView;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface ITeammemberService extends IService<Teammember> {

    /**
     * 更新成员信息
     * @param teammember
     * @return
     */
    ResultView updateTeam(Teammember teammember);



}
