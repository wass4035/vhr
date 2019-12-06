package com.wass.hr.service.impl;

import com.wass.hr.Basic.persistence.GenericMapper;
import com.wass.hr.Basic.service.impl.BaseServiceImpl;
import com.wass.hr.entity.Message;
import com.wass.hr.entity.StaffRemove;
import com.wass.hr.mapper.StaffRemoveMapper;
import com.wass.hr.service.StaffRemoveService;
import com.wass.hr.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 员工调动信息服务实现类
 *
 * @author wass
 */
@Service
public class StaffRemoveServiceimpl extends BaseServiceImpl<StaffRemove> implements StaffRemoveService {

    @Autowired
    private StaffRemoveMapper staffRemoveMapper;
    @Override
    protected GenericMapper<StaffRemove, Long> getMapper() {
        return staffRemoveMapper;
    }

    @Override
    public Message getStaffRemoveList() {

        return null;
    }

    /**
     * 新增员工调动信息
     * @param staffRemove
     * @return
     */
    public Message addStaffRemove(StaffRemove staffRemove) {
        Message msg = null;
        staffRemove.setStaffRemoveId(AppUtil.generateId());
        int addNum = staffRemoveMapper.insert(staffRemove);
        if(addNum == 0){
            msg = Message.error("添加员工调动信息失败");
        } else {
            msg = Message.success("添加员工调动信息成功");
        }
        return msg;
    }

    /**
     * 修改员工调动信息
     * @param staffRemove
     * @return
     */
    public Message modifyStaffRemove(StaffRemove staffRemove) {
        Message msg = null;
        int modNum = staffRemoveMapper.update(staffRemove);
        if(modNum == 0){
            msg = Message.error("修改员工调动信息失败");
        } else {
            msg = Message.success("修改员工调动信息成功");
        }
        return msg;
    }

    /**
     * 删除员工调动信息
     * @param staffRemoveId
     * @return
     */
    public Message delStaffRemove(Long staffRemoveId) {
        Message msg = null;
        int delNum = staffRemoveMapper.delete(staffRemoveId);
        if(delNum == 0){
            msg = Message.error("删除员工调动信息失败");
        } else {
            msg = Message.success("删除员工调动信息成功");
        }
        return msg;
    }
}
