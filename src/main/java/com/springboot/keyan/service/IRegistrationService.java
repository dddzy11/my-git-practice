package com.springboot.keyan.service;

import com.springboot.keyan.entity.Registration;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.keyan.util.ResultView;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IRegistrationService extends IService<Registration> {

    /**
     * 处理注册申请
     * @param obj
     * @return
     */
    ResultView applyRegister(Registration obj);



}
