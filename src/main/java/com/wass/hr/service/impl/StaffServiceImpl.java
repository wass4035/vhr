package com.wass.hr.service.impl;

import com.wass.hr.Basic.persistence.GenericMapper;
import com.wass.hr.Basic.service.impl.BaseServiceImpl;
import com.wass.hr.entity.Message;
import com.wass.hr.entity.Staff;
import com.wass.hr.mapper.StaffMapper;
import com.wass.hr.service.StaffService;
import com.wass.hr.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 员工信息服务类
 * @author wass
 */
@Service
public class StaffServiceImpl extends BaseServiceImpl<Staff> implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    protected GenericMapper<Staff, Long> getMapper() {
        return staffMapper;
    }

    /**
     * 查询员工信息
     * @return
     */
    public Message getStaffList() {
        Message msg = null;
        List<Staff> staffList = staffMapper.getList();
        msg.putBody("content",staffList);
        msg.setType(Message.Type.success);
        return msg;
    }

    /**
     *
     * 新增员工信息
     * @param staff   员工信息
     * @return
     */
    public Message addStaff(Staff staff) {
        Message msg = null;
        staff.setStaff_id(AppUtil.generateId());
        int addNum = staffMapper.insert(staff);
        if(addNum == 0 ){
            msg = Message.error("添加员工信息失败");
        } else {
            msg = Message.success("添加员工信息成功");
        }
        return msg;
    }

    /**
     * 修改员工信息
     * @param staff   员工信息
     * @return
     */
    public Message modifyStaff(Staff staff) {
        Message msg = null;
        int modNum = staffMapper.update(staff);
        if(modNum == 0){
            msg = Message.error("修改员工信息失败");
        } else {
            msg = Message.success("修改员工信息成功");
        }
        return msg;
    }

    /**
     * 删除员工信息
     * @param staffId   员工ID
     * @return
     */
    public Message delStaff(Long staffId) {
        Message msg = null;
        int delNum = staffMapper.delete(staffId);
        if(delNum == 0){
            msg = Message.error("删除员工信息失败");
        } else {
            msg = Message.success("删除员工信息成功");
        }
        return msg;
    }
}
