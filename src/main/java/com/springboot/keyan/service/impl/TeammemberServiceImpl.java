package com.springboot.keyan.service.impl;

import com.springboot.keyan.entity.Teammember;
import com.springboot.keyan.mapper.TeammemberMapper;
import com.springboot.keyan.service.ITeammemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.keyan.util.ResultView;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class TeammemberServiceImpl extends ServiceImpl<TeammemberMapper, Teammember> implements ITeammemberService {
    @Override
    public ResultView updateTeam(Teammember teammember) {
        teammember.setUpdatetime(new Date());
        this.updateById(teammember);
        return ResultView.ok();
    }
}
