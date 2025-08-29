package com.springboot.keyan.service;

import com.springboot.keyan.entity.Userlogin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IUserloginService extends IService<Userlogin> {

    /**
     * 登录
     * @param obj
     * @return
     */
    Userlogin login(Userlogin obj);



}
