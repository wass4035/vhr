package com.wass.hr.service;

import com.wass.hr.Basic.service.BaseService;
import com.wass.hr.entity.Message;
import com.wass.hr.entity.Salary;

/**
 * 工资服务接口
 *
 * @author wass
 */
public interface SalaryService extends BaseService<Salary,Long> {
    /**
     * 查询员工工资信息
     * @return
     */
    public Message getSalaryList();

    /**
     * 新增员工工资信息
     * @param salary
     * @return
     */
    public Message addSalary(Salary salary);

    /**
     * 修改员工工资信息
     * @param salary
     * @return
     */
    public Message modifySalary(Salary salary);

    /**
     * 删除员工工资信息
     * @param salaryId
     * @return
     */
    public Message delSalary(Long salaryId);

}
