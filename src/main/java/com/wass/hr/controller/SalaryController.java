package com.wass.hr.controller;

import com.wass.hr.Basic.controller.BaseController;
import com.wass.hr.entity.Message;
import com.wass.hr.entity.Salary;
import com.wass.hr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 工资信息对外接口  控制层
 *
 * @author wass
 */
@RestController("/salary")
public class SalaryController extends BaseController {

    @Autowired
    private SalaryService salaryService;

    /**
     * 查询工资信息
     * @return
     */
    @RequestMapping("/getSalaryList")
    public Message getSalaryList(){
        Message msg = null;
        msg = salaryService.getSalaryList();
        return msg;
    }

    /**
     * 新增工资信息
     * @param salary
     * @return
     */
    @RequestMapping("/addSalary")
    public Message addSalary(Salary salary){
        Message msg = null;
        msg = salaryService.addSalary(salary);
        return msg;
    }

    /**
     * 修改工资信息
     * @param salary
     * @return
     */
    @RequestMapping("/modifySalary")
    public Message modifySalary(Salary salary){
        Message msg = null;
        msg = salaryService.modifySalary(salary);
        return msg;
    }

    /**
     * 删除工资信息
     * @param salaryId
     * @return
     */
    @RequestMapping("/delSalary")
    public Message delSalary(Long salaryId){
        Message msg = null;
        msg = salaryService.delSalary(salaryId);
        return msg;
    }
}
