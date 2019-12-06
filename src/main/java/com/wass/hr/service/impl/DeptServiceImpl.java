package com.wass.hr.service.impl;

import com.wass.hr.Basic.persistence.GenericMapper;
import com.wass.hr.Basic.service.impl.BaseServiceImpl;
import com.wass.hr.entity.Department;
import com.wass.hr.entity.Message;
import com.wass.hr.mapper.DeptMapper;
import com.wass.hr.service.DeptService;
import com.wass.hr.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeptServiceImpl extends BaseServiceImpl<Department> implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    protected GenericMapper<Department, Long> getMapper() {
        return deptMapper;
    }

    /**
     * 获取部门信息
     * @return
     * @param deptId 部门ID
     * @throws Exception
     */
    public Message getDeptList(String deptId){
        Map<String, Object> map = new HashMap<>();
        map.put("deptId", deptId);
        List<Department> listdept = deptMapper.getDeptList(map);
        Message msg = new Message();
        msg.putBody("deptlist",listdept);
        return msg;
    }

    /**
     * 新增部门信息
     * @param dept
     * @return
     */
    public int addDept(Department dept){
        dept.setDept_id(AppUtil.generateId());
       return  this.deptMapper.insert(dept);
    }

    /**
     * 修改部门信息
     * @param dept
     * @return
     */
    public int modifyDept(Department dept){
        return deptMapper.update(dept);
    }

    public int delDept(Long deptId){
        return deptMapper.delete(deptId);
    }

}
