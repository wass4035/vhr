package com.wass.hr.controller;

import com.wass.hr.Basic.controller.BaseController;
import com.wass.hr.entity.Message;
import com.wass.hr.entity.StaffRemove;
import com.wass.hr.service.StaffRemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wass
 */
@RestController("/staffRemove")
public class StaffRemoveController extends BaseController {

    @Autowired
    private StaffRemoveService staffRemoveService;

    /**
     * 查询员工调动信息
     * @return
     */
    @RequestMapping("/getStaffRemoveList")
    public Message getStaffRemoveList(){
        return staffRemoveService.getStaffRemoveList();
    }

    /**
     * 新增员工调动信息
     * @param staffRemove
     * @return
     */
    @RequestMapping("/addStaffRemove")
    public Message addStaffRemove(StaffRemove staffRemove){
        Message msg = null;
        msg = staffRemoveService.addStaffRemove(staffRemove);
        return msg;
    }

    /**
     * 修改员工调动信息
     * @param staffRemove
     * @return
     */
    @RequestMapping("/modifyStaffRemove")
    public Message modifyStaffRemove(StaffRemove staffRemove){
        Message msg = null;
        msg = staffRemoveService.modifyStaffRemove(staffRemove);
        return msg;
    }

    /**
     * 删除员工调动信息
     * @param staffRemoveId
     * @return
     */
    @RequestMapping("/delStaffRemove")
    public Message delStaffRemove(Long staffRemoveId){
        Message msg = null;
        msg = staffRemoveService.delStaffRemove(staffRemoveId);
        return msg;
    }
}
