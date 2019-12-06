package com.wass.hr.service;

import com.wass.hr.Basic.service.BaseService;
import com.wass.hr.entity.Message;
import com.wass.hr.entity.StaffRemove;

/**
 * 员工调动信息服务接口
 *
 * @author wass
 */
public interface StaffRemoveService extends BaseService<StaffRemove,Long> {
    /**
     * 查询 员工调动信息
     * @return
     */
    public Message getStaffRemoveList();

    /**
     * 新增员工调动信息
     * @param staffRemove
     * @return
     */
    public Message addStaffRemove(StaffRemove staffRemove);

    /**
     * 修改员工调动信息
     * @param staffRemove
     * @return
     */
    public Message modifyStaffRemove(StaffRemove staffRemove);

    /**
     * 删除员工调动信息
     * @param staffRemoveId
     * @return
     */
    public Message delStaffRemove(Long staffRemoveId);
}
