package com.springboot.keyan.controller;


import com.springboot.keyan.entity.Registration;
import com.springboot.keyan.service.IRegistrationService;
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
@RequestMapping("/api/admin/registration")
public class RegistrationController {

    @Autowired
    private IRegistrationService service;


    /**
     * 注册申请
     * @param obj
     * @return
     */
    @RequestMapping("/applyRegister")
    public ResultView applyRegister(Registration obj) {
        return this.service.applyRegister(obj);
    }

}
