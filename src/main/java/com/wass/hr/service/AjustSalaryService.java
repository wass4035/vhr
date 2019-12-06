package com.wass.hr.service;

import com.wass.hr.Basic.service.BaseService;
import com.wass.hr.entity.AjustSalary;
import com.wass.hr.entity.Message;

/**
 * 调薪服务接口类
 * @author wass
 */
public interface AjustSalaryService extends BaseService<AjustSalary,Long> {
    /**
     * 查询调薪信息
     * @return
     */
    public Message getAjustSalaryList();

    /**
     * 新增调薪信息
     * @param ajustSalary
     * @return
     */
    public Message addAjustSalary(AjustSalary ajustSalary);

    /**
     * 修改调薪信息
     * @param ajustSalary
     * @return
     */
    public Message modifyAjustSalary(AjustSalary ajustSalary);

    /**
     * 删除调薪信息
     * @param ajustSalaryId
     * @return
     */
    public  Message delAjustSalary(Long ajustSalaryId);
}
