package com.wass.hr.service;

import com.wass.hr.Basic.service.BaseService;
import com.wass.hr.entity.Message;
import com.wass.hr.entity.RewardsPunishment;

/**
 * 奖惩信息服务类接口
 *
 * @author wass
 */
public interface RewardsPunishmentService extends BaseService<RewardsPunishment,Long> {
    /**
     * 查询奖惩信息
     * @return
     */
    public Message getRewardsPunishmentList();

    /**
     * 新增奖惩信息
     * @param rewardsPunishment
     * @return
     */
    public Message addRewardsPunishment(RewardsPunishment rewardsPunishment);

    /**
     * 修改奖惩信息
     * @param rewardsPunishment
     * @return
     */
    public Message modifyRewardsPunishment(RewardsPunishment rewardsPunishment);

    /**
     *
     * 删除奖惩信息
     * @param rpsmtId
     * @return
     */
    public Message delRewardsPunishment(Long rpsmtId);
}
