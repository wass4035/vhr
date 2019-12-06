package com.wass.hr.entity;

import java.io.Serializable;

/**
 * 工资实体类
 *
 * @author wass
 */
public class Salary implements Serializable {

    private Long salaryId;//工资表主键ID
    private Long staffId;//员工ID
    private Long deptId;//部门ID
    private Long bonus;//奖金
    private Long lunchSalary;//午餐补助
    private Long trafficSalary;//交通补助

    private Long basicSalary;//基本工资
    private Long allalary;//实发工资

    public Long getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Long salaryId) {
        this.salaryId = salaryId;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getBonus() {
        return bonus;
    }

    public void setBonus(Long bonus) {
        this.bonus = bonus;
    }

    public Long getLunchSalary() {
        return lunchSalary;
    }

    public void setLunchSalary(Long lunchSalary) {
        this.lunchSalary = lunchSalary;
    }

    public Long getTrafficSalary() {
        return trafficSalary;
    }

    public void setTrafficSalary(Long trafficSalary) {
        this.trafficSalary = trafficSalary;
    }

    public Long getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Long basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Long getAllalary() {
        return allalary;
    }

    public void setAllalary(Long allalary) {
        this.allalary = allalary;
    }
}
