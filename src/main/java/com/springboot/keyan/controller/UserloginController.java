package com.springboot.keyan.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.springboot.keyan.entity.Registration;
import com.springboot.keyan.entity.Userlogin;
import com.springboot.keyan.service.IUserloginService;
import com.springboot.keyan.util.ResultView;
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
@RequestMapping("/api/admin/userlogin")
public class UserloginController {

    @Autowired
    private IUserloginService service;

    /**
     * 账号登录
     * @param obj
     * @return
     */
    @RequestMapping("/login")
    public ResultView login(Userlogin obj) {
        Userlogin userlogin=this.service.login(obj);
        if(userlogin==null){
            return ResultView.error("账号密码错误");
        }
        //进行授权注入sa-token权限框架
        StpUtil.login(userlogin.getUserid());
        //注入用户session-保持session信息共享-保持session底层代码共享
        StpUtil.getSession().set(userlogin.getUserid()+"",userlogin);
        return ResultView.ok(StpUtil.getTokenValue());
    }




}
