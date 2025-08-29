package com.springboot.keyan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.keyan.entity.Registration;
import com.springboot.keyan.entity.Teammember;
import com.springboot.keyan.entity.Userlogin;
import com.springboot.keyan.mapper.RegistrationMapper;
import com.springboot.keyan.service.IRegistrationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.keyan.service.ITeammemberService;
import com.springboot.keyan.service.IUserloginService;
import com.springboot.keyan.util.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class RegistrationServiceImpl extends ServiceImpl<RegistrationMapper, Registration> implements IRegistrationService {

    @Autowired
    private ITeammemberService teammemberService;

    @Autowired
    private IUserloginService userloginService;

    @Transactional
    @Override
    public ResultView applyRegister(Registration obj) {
        //检测账号是否重复注册过
        QueryWrapper<Registration> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",obj.getUsername());
        List<Registration> registrationList=this.list(queryWrapper);
        if(registrationList!=null&&registrationList.size()>=1){
            return ResultView.error("当前账号重复注册");
        }
        obj.setAppltime(new Date());
        obj.setType(2);
        obj.setState(1);//需要修改时，将状态修改为0，待审核
        this.save(obj);
        //// 发送注册信息给管理员审核
        //    sendRegistrationInfoToAdmin(obj);
        //    return ResultView.ok();
        //同时插入登录表
        Userlogin userlogin=new Userlogin();
        userlogin.setUserid(obj.getRegisuserid());
        userlogin.setPassword(obj.getPassword());
        userlogin.setUsername(obj.getUsername());
        userlogin.setRegtime(new Date());
        userlogin.setType(2);
        userlogin.setState(1);
        this.userloginService.save(userlogin);
        //同时插入成员表
        Teammember teammember=new Teammember();
        teammember.setMemname(obj.getUsername());
        teammember.setState(1);
        teammember.setMemid(obj.getRegisuserid());
        this.teammemberService.save(teammember);
        return ResultView.ok();

    }



}
