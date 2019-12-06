package com.wass.hr.controller;

import com.wass.hr.Basic.controller.BaseController;
import com.wass.hr.entity.Message;
import com.wass.hr.entity.RewardsPunishment;
import com.wass.hr.service.RewardsPunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 奖惩对外接口类
 *
 * @author wass
 */
@RestController("/rewardsPunishment")
public class RewardsPunishmentController extends BaseController {

    @Autowired
    private RewardsPunishmentService rewardsPunishmentService;

    /**
     * 查询奖惩信息
     * @return
     */
    @RequestMapping("/getRewardsPunishmentList")
    public Message getRewardsPunishmentList(){
        Message msg = null;
        msg = rewardsPunishmentService.getRewardsPunishmentList();
        return msg;
    }

    /**
     * 新增奖惩信息
     * @param rewardsPunishment
     * @return
     */
    @RequestMapping("/addRewardsPunishment")
    public Message addRewardsPunishment(RewardsPunishment rewardsPunishment){
        Message msg = null;
        msg = rewardsPunishmentService.addRewardsPunishment(rewardsPunishment);
        return msg;
    }

    /**
     * 修改奖惩信息
     * @param rewardsPunishment
     * @return
     */
    @RequestMapping("/modifyRewardsPunishment")
    public Message modifyRewardsPunishment(RewardsPunishment rewardsPunishment){
        Message msg = null;
        msg = rewardsPunishmentService.modifyRewardsPunishment(rewardsPunishment);
        return msg;
    }

    /**
     * 删除奖惩信息
     * @param rpsmtId
     * @return
     */
    @RequestMapping("/delRewardsPunishment")
    public Message delRewardsPunishment(Long rpsmtId){
        Message msg = null;
        msg = rewardsPunishmentService.delRewardsPunishment(rpsmtId);
        return msg;
    }

}
