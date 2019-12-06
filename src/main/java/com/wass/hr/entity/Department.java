package com.wass.hr.entity;

import java.io.Serializable;

/**
 * 部门信息实体类
 * @author wass
 */
public class Department implements Serializable {
    private Long dept_id;//部门ID
    private String dept_name;//部门名称
    private int dept_pid;//上级部门ID
    private String dept_remark;//部门备注

    public Long getDept_id() {
        return dept_id;
    }

    public void setDept_id(Long dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public int getDept_pid() {
        return dept_pid;
    }

    public void setDept_pid(int dept_pid) {
        this.dept_pid = dept_pid;
    }

    public String getDept_remark() {
        return dept_remark;
    }

    public void setDept_remark(String dept_remark) {
        this.dept_remark = dept_remark;
    }
}
