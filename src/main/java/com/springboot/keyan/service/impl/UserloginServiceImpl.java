package com.springboot.keyan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.keyan.entity.Userlogin;
import com.springboot.keyan.mapper.UserloginMapper;
import com.springboot.keyan.service.IUserloginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class UserloginServiceImpl extends ServiceImpl<UserloginMapper, Userlogin> implements IUserloginService {

    @Override
    public Userlogin login(Userlogin obj) {
        QueryWrapper<Userlogin> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",obj.getUsername());
        queryWrapper.eq("password",obj.getPassword());
        Userlogin userlogin=this.getOne(queryWrapper);
        return userlogin;
    }


}
