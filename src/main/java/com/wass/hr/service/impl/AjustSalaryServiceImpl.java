package com.wass.hr.service.impl;

import com.wass.hr.Basic.persistence.GenericMapper;
import com.wass.hr.Basic.service.impl.BaseServiceImpl;
import com.wass.hr.entity.AjustSalary;
import com.wass.hr.entity.Message;
import com.wass.hr.mapper.AjustSalaryMapper;
import com.wass.hr.service.AjustSalaryService;
import com.wass.hr.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 调薪信息服务实现类
 *
 * @author wass
 */
@Service
public class AjustSalaryServiceImpl extends BaseServiceImpl<AjustSalary> implements AjustSalaryService {

    @Autowired
    private AjustSalaryMapper ajustSalaryMapper;
    @Override
    protected GenericMapper<AjustSalary, Long> getMapper() {
        return ajustSalaryMapper;
    }

    /**
     * 查询调薪信息
     * @return
     */
    public Message getAjustSalaryList() {
        return null;
    }

    /**
     * 新增调薪信息
     * @param ajustSalary
     * @return
     */
    public Message addAjustSalary(AjustSalary ajustSalary) {
        Message msg = null;
        ajustSalary.setAjustSalaryId(AppUtil.generateId());
        int addNum = ajustSalaryMapper.insert(ajustSalary);
        if(addNum == 0){
            msg = Message.error("新增调薪信息失败！");
        } else {
            msg = Message.success("新增调薪信息成功！");
        }
        return msg;
    }

    /**
     * 修改调薪信息
     * @param ajustSalary
     * @return
     */
    @Override
    public Message modifyAjustSalary(AjustSalary ajustSalary) {
        Message msg = null;
        int modNum = ajustSalaryMapper.update(ajustSalary);
        if(modNum == 0){
            msg = Message.error("修改调薪信息失败！");
        } else {
            msg = Message.success("修改调薪信息成功！");
        }
        return msg;
    }

    /**
     * 删除调薪信息
     * @param ajustSalaryId
     * @return
     */
    @Override
    public Message delAjustSalary(Long ajustSalaryId) {
        Message msg = null;
        int delNum = ajustSalaryMapper.delete(ajustSalaryId);
        if(delNum == 0){
            msg = Message.error("删除调薪信息失败！");
        } else {
            msg = Message.success("删除调薪信息成功！");
        }
        return msg;
    }

}
