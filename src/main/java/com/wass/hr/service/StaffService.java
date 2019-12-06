package com.wass.hr.service;

import com.wass.hr.Basic.service.BaseService;
import com.wass.hr.entity.Message;
import com.wass.hr.entity.Staff;
import org.springframework.stereotype.Service;

/**
 * 员工信息服务接口
 */
public interface StaffService extends BaseService<Staff,Long> {
    /**
     * 查询员工信息
     * @return
     */
    public Message getStaffList();

    /**
     * 新增工员信息
     * @param staff   员工信息
     * @return
     */
    public Message addStaff(Staff staff);

    /**
     * 修改员工信息
     * @param staff   员工信息
     * @return
     */
    public Message modifyStaff(Staff staff);

    /**
     * 删除员工信息
     * @param staffId   员工ID
     * @return
     */
    public Message delStaff(Long staffId);
}
