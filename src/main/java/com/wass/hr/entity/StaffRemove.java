package com.wass.hr.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工调动实体类
 *
 * @author wass
 */
public class StaffRemove implements Serializable {

    private Long staffRemoveId;//员工调动信息ID
    private Long afterRemoveDeptId;//员工调动后部门
    private String afterRemoveJob;//员工调动后工作
    private Date removeDate;//调动日期
    private String removeReason;//调动原因
    private String remark;//备注

    public Long getStaffRemoveId() {
        return staffRemoveId;
    }

    public void setStaffRemoveId(Long staffRemoveId) {
        this.staffRemoveId = staffRemoveId;
    }

    public Long getAfterRemoveDeptId() {
        return afterRemoveDeptId;
    }

    public void setAfterRemoveDeptId(Long afterRemoveDeptId) {
        this.afterRemoveDeptId = afterRemoveDeptId;
    }

    public String getAfterRemoveJob() {
        return afterRemoveJob;
    }

    public void setAfterRemoveJob(String afterRemoveJob) {
        this.afterRemoveJob = afterRemoveJob;
    }

    public Date getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(Date removeDate) {
        this.removeDate = removeDate;
    }

    public String getRemoveReason() {
        return removeReason;
    }

    public void setRemoveReason(String removeReason) {
        this.removeReason = removeReason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
