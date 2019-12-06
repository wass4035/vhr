package com.wass.hr.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 奖惩制度实体类
 *
 * @author wass
 */
public class RewardsPunishment implements Serializable {

    private Long rpsmtId;//奖惩表ID
    private Date rpsmtDate;//奖惩日期

    private String rpsmtReason;//奖惩原因
    private String rpsmtPoint;///奖惩分数
    private String rpsmtType;//奖惩类型
    private String remark;//备注

    public Long getRpsmtId() {
        return rpsmtId;
    }

    public void setRpsmtId(Long rpsmtId) {
        this.rpsmtId = rpsmtId;
    }

    public Date getRpsmtDate() {
        return rpsmtDate;
    }

    public void setRpsmtDate(Date rpsmtDate) {
        this.rpsmtDate = rpsmtDate;
    }

    public String getRpsmtReason() {
        return rpsmtReason;
    }

    public void setRpsmtReason(String rpsmtReason) {
        this.rpsmtReason = rpsmtReason;
    }

    public String getRpsmtPoint() {
        return rpsmtPoint;
    }

    public void setRpsmtPoint(String rpsmtPoint) {
        this.rpsmtPoint = rpsmtPoint;
    }

    public String getRpsmtType() {
        return rpsmtType;
    }

    public void setRpsmtType(String rpsmtType) {
        this.rpsmtType = rpsmtType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
