package com.wass.hr.controller;

import com.wass.hr.Basic.controller.BaseController;
import com.wass.hr.entity.AjustSalary;
import com.wass.hr.entity.Message;
import com.wass.hr.service.AjustSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 调薪控制层--对外接口类
 *
 * @author wass
 */
@RestController("/ajustSalary")
public class AjustSalaryController extends BaseController {

    @Autowired
    private AjustSalaryService ajustSalaryService;

    /***
     * 查询调薪信息
     * @return
     */
    @RequestMapping("/getAjustSalaryList")
    public Message getAjustSalaryList(){
        return ajustSalaryService.getAjustSalaryList();
    }

    /**
     * 新增调薪信息
     * @param ajustSalary
     * @return
     */
    @RequestMapping("/addAjustSalary")
    public Message addAjustSalary(AjustSalary ajustSalary){
        Message msg = null;

        msg = ajustSalaryService.addAjustSalary(ajustSalary);

        return msg;
    }

    /**
     * 修改调薪信息
     * @param ajustSalary
     * @return
     */
    @RequestMapping("/modifyAjustSalary")
    public Message modifyAjustSalary(AjustSalary ajustSalary){
        Message msg = null;
        msg = ajustSalaryService.modifyAjustSalary(ajustSalary);
        return msg;
    }

    /**
     * 删除调薪信息
     * @param ajustSalaryId  调薪信息ID
     * @return
     */
    @RequestMapping("/delAjustSalary")
    public Message delAjustSalary(Long ajustSalaryId){
        Message msg = null;
        msg = ajustSalaryService.delAjustSalary(ajustSalaryId);
        return msg;
    }
}
