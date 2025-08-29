package com.springboot.keyan.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springboot.keyan.entity.Feedback;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.keyan.entity.vo.FeedbackView;

import java.util.List;

/**
 * <p>
 * 反馈表 Mapper 接口
 * </p>
 *
 */
public interface FeedbackMapper extends BaseMapper<Feedback> {
    //分页查询反馈信息
    List<FeedbackView> getPageList(IPage iPage, Feedback obj);


}
