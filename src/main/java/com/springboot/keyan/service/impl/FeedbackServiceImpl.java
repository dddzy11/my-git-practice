package com.springboot.keyan.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.keyan.entity.Feedback;
import com.springboot.keyan.entity.vo.FeedbackView;
import com.springboot.keyan.mapper.FeedbackMapper;
import com.springboot.keyan.qpage.QPage;
import com.springboot.keyan.service.IFeedbackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.keyan.util.ResultView;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 反馈表 服务实现类
 * </p>
 *
 */
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements IFeedbackService {

//分页查询
    @Override
    public ResultView getPageList(QPage qPage, Feedback obj) {
        IPage iPage = new Page(qPage.getOffset(), qPage.getLimit());
        List<FeedbackView> mapList = this.baseMapper.getPageList(iPage,obj);
        return ResultView.ok(iPage.setRecords(mapList));
    }
//回复
    @Override
    public ResultView huihu(Feedback obj) {
        obj.setReplytime(new Date());
        this.updateById(obj);
        return ResultView.ok();
    }
//新增
    @Override
    public ResultView add(Feedback obj) {
        obj.setUserid(StpUtil.getLoginIdAsInt());
        obj.setState(1);
        obj.setQuetime(new Date());
        this.save(obj);
        return ResultView.ok();
    }
}
