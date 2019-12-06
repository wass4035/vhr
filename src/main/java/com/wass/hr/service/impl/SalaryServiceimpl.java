package com.wass.hr.service.impl;

import com.wass.hr.Basic.persistence.GenericMapper;
import com.wass.hr.Basic.service.impl.BaseServiceImpl;
import com.wass.hr.entity.Message;
import com.wass.hr.entity.Salary;
import com.wass.hr.mapper.SalaryMapper;
import com.wass.hr.service.SalaryService;
import com.wass.hr.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 员工工资服务实现类
 *
 * @author wass
 */
@Service
public class SalaryServiceimpl extends BaseServiceImpl<Salary> implements SalaryService {

    @Autowired
    private SalaryMapper salaryMapper;

    @Override
    protected GenericMapper<Salary, Long> getMapper() {
        return null;
    }

    /**
     * 查询工资信息
     * @return
     */
    public Message getSalaryList() {
        return null;
    }

    /**
     * 新增工资信息
     * @param salary
     * @return
     */
    public Message addSalary(Salary salary) {
        Message msg = null;
        salary.setSalaryId(AppUtil.generateId());
        int addNum = salaryMapper.insert(salary);
        if(addNum == 0){
            msg = Message.error("添加工资信息失败！");
        } else {
            msg = Message.success("添加工资信息成功!");
        }
        return msg;
    }

    /**
     * 修改工资信息
     * @param salary
     * @return
     */
    public Message modifySalary(Salary salary) {
        Message msg = null;
        int modNum = salaryMapper.update(salary);
        if(modNum == 0){
            msg = Message.error("修改工资信息失败！");
        } else {
            msg = Message.success("修改工资信息成功!");
        }
        return msg;
    }

    /**
     * 删除工资信息
     * @param salaryId
     * @return
     */
    public Message delSalary(Long salaryId) {
        Message msg = null;
        int delNum = salaryMapper.delete(salaryId);
        if(delNum == 0){
            msg = Message.error("删除工资信息失败！");
        } else {
            msg = Message.success("删除工资信息成功!");
        }
        return msg;
    }
}
