package com.springboot.keyan.controller;


import com.springboot.keyan.entity.Feedback;
import com.springboot.keyan.qpage.QPage;
import com.springboot.keyan.service.IFeedbackService;
import com.springboot.keyan.util.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 反馈表 前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/api/admin/feedback")
public class FeedbackController {

    @Autowired
    private IFeedbackService service;

    /**
     * 列表分页
     * @param obj
     * @return
     */
    @GetMapping("/getPageList")
    public ResultView getPageList(QPage qPage, Feedback obj) {
        return this.service.getPageList(qPage,obj);
    }

    /**
     * 获取问题详情
     * @param obj
     * @return
     */
    @RequestMapping("/getId")
    public ResultView getId(Feedback obj) {
        return ResultView.ok(this.service.getById(obj.getFeedbackid()));
    }

    /**
     * 新增反馈问题
     * @param obj
     * @return
     */
    @RequestMapping("/add")
    public ResultView add(Feedback obj) {
        return this.service.add(obj);
    }


    /**
     * 回复反馈问题
     * @param obj
     * @return
     */
    @RequestMapping("/up")
    public ResultView up(Feedback obj) {
        return this.service.huihu(obj);
    }




}
