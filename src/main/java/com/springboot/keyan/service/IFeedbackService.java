package com.springboot.keyan.service;

import com.springboot.keyan.entity.Feedback;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.keyan.qpage.QPage;
import com.springboot.keyan.util.ResultView;

/**
 * <p>
 * 反馈表 服务类
 * </p>
 *
 */
public interface IFeedbackService extends IService<Feedback> {

    /**
     * 分页列表
     * @param qPage
     * @param obj
     * @return
     */
    ResultView getPageList(QPage qPage, Feedback obj);

    /**
     * 回复
     * @param obj
     * @return
     */
    ResultView huihu(Feedback obj);


    /**
     * 新增反馈问题
     * @param obj
     * @return
     */
    ResultView add(Feedback obj);


}
