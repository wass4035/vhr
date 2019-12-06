package com.wass.hr.service;

import com.wass.hr.Basic.service.BaseService;
import com.wass.hr.entity.Department;
import com.wass.hr.entity.Message;

/**
 * 部门信息操作接口类
 */
public interface DeptService extends BaseService<Department,Long> {
    /**
     * 获取部门信息
     * @param deptId
     * @return
     */
    public Message getDeptList(String deptId);

    /**
     * 新增部门信息
     * @param dept
     * @return
     */
    public int addDept(Department dept);

    /**
     * 修改部门信息
     * @param dept
     * @return
     */
    public int modifyDept(Department dept);
    /**
     * 删除部门信息
     * @param deptId
     * @return
     */
    public int delDept(Long deptId);

}
