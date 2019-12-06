package com.wass.hr.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 调薪实体类
 * @author wass
 */
public class AjustSalary implements Serializable {

    private Long ajustSalaryId;//凋薪主键ID
    private Date adjustSalaryDate;//调薪日期
    private int beforAdjustSalary;//调薪前薪资
    private int afterAdjustSalary;//调薪后薪资
    private String adjustSalaryReason;//调薪原因
    private String remark;//备注

    public Long getAjustSalaryId() {
        return ajustSalaryId;
    }

    public void setAjustSalaryId(Long ajustSalaryId) {
        this.ajustSalaryId = ajustSalaryId;
    }

    public Date getAdjustSalaryDate() {
        return adjustSalaryDate;
    }

    public void setAdjustSalaryDate(Date adjustSalaryDate) {
        this.adjustSalaryDate = adjustSalaryDate;
    }

    public int getBeforAdjustSalary() {
        return beforAdjustSalary;
    }

    public void setBeforAdjustSalary(int beforAdjustSalary) {
        this.beforAdjustSalary = beforAdjustSalary;
    }

    public int getAfterAdjustSalary() {
        return afterAdjustSalary;
    }

    public void setAfterAdjustSalary(int afterAdjustSalary) {
        this.afterAdjustSalary = afterAdjustSalary;
    }

    public String getAdjustSalaryReason() {
        return adjustSalaryReason;
    }

    public void setAdjustSalaryReason(String adjustSalaryReason) {
        this.adjustSalaryReason = adjustSalaryReason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
