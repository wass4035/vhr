package com.wass.hr.service.impl;

import com.wass.hr.Basic.persistence.GenericMapper;
import com.wass.hr.Basic.service.impl.BaseServiceImpl;
import com.wass.hr.entity.Message;
import com.wass.hr.entity.RewardsPunishment;
import com.wass.hr.mapper.RewardsPunishmentMapper;
import com.wass.hr.service.RewardsPunishmentService;
import com.wass.hr.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 奖惩制度服务实现类
 *
 * @author wass
 */

@Service
public class RewardsPunishmentServiceImpl extends BaseServiceImpl<RewardsPunishment> implements RewardsPunishmentService {

    @Autowired
    private RewardsPunishmentMapper rewardsPunishmentMapper;
    @Override
    protected GenericMapper<RewardsPunishment, Long> getMapper() {
        return rewardsPunishmentMapper;
    }

    /**
     * 查询奖惩信息
     * @return
     */
    public Message getRewardsPunishmentList() {
        return null;
    }

    /**
     * 新增奖惩信息
     * @param rewardsPunishment
     * @return
     */
    public Message addRewardsPunishment(RewardsPunishment rewardsPunishment) {
        Message msg = null;
        rewardsPunishment.setRpsmtId(AppUtil.generateId());
        int addNum = rewardsPunishmentMapper.insert(rewardsPunishment);
        if(addNum == 0){
            msg = Message.error("新增奖惩信息失败！");
        } else {
            msg = Message.success("新增奖惩信息成功！");
        }
        return msg;
    }

    /**
     * 修改奖惩信息
     * @param rewardsPunishment
     * @return
     */
    public Message modifyRewardsPunishment(RewardsPunishment rewardsPunishment) {
        Message msg = null;
        int modNum = rewardsPunishmentMapper.update(rewardsPunishment);
        if(modNum == 0){
            msg = Message.error("修改奖惩信息失败！");
        } else {
            msg = Message.success("修改奖惩信息成功！");
        }
        return msg;
    }

    /**
     * 删除奖惩信息
     * @param rpsmtId
     * @return
     */
    public Message delRewardsPunishment(Long rpsmtId) {
        Message msg = null;
        int delNum = rewardsPunishmentMapper.delete(rpsmtId);
        if(delNum == 0){
            msg = Message.error("删除奖惩信息失败！");
        } else {
            msg = Message.success("删除奖惩信息成功！");
        }
        return msg;
    }
}
