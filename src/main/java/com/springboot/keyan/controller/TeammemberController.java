package com.springboot.keyan.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.keyan.entity.Registration;
import com.springboot.keyan.entity.Teammember;
import com.springboot.keyan.entity.Userlogin;
import com.springboot.keyan.entity.vo.TeammemberView;
import com.springboot.keyan.service.ITeammemberService;
import com.springboot.keyan.service.IUserloginService;
import com.springboot.keyan.util.ResultView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/api/admin/teammember")
public class TeammemberController {

    @Autowired
    private ITeammemberService service;

    @Autowired
    private IUserloginService userloginService;


    /**
     * 获取当前团队成员信息
     * @return
     */
    @RequestMapping("/getInfo")
    public ResultView getInfo() {
        Userlogin userlogin=this.userloginService.getById(StpUtil.getLoginIdAsInt());
        QueryWrapper<Teammember> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("memid",userlogin.getUserid());
        Teammember teammember=this.service.getOne(queryWrapper);
        //TeammemberView teammemberView=new TeammemberView();
        //BeanUtils.copyProperties(teammember,teammemberView);
        //teammemberView.setUsername(userlogin.getUsername());
        return ResultView.ok(teammember);
    }

    /**
     * 更新当前成员信息
     * @param teammember
     * @return
     */
    @RequestMapping("/updateTeam")
    public ResultView updateTeam(Teammember teammember) {
        return this.service.updateTeam(teammember);
    }


}
