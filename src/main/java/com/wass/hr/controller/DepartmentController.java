package com.wass.hr.controller;

import com.wass.hr.Basic.controller.BaseController;
import com.wass.hr.entity.Department;
import com.wass.hr.entity.Message;
import com.wass.hr.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 部门信息对外接口类  --控制层
 *
 * @author wass
 */
@RestController("/dept")
public class DepartmentController extends BaseController {

    @Autowired
	private DeptService deptService;

    /**
     * 查询所有部门信息
     * @return
     */
	@RequestMapping("/getDept")
	public Message getDeptList(Department dept){
        Message msg = new Message();
//		msg = deptService.getDeptList(deptId);
		return msg;
	}

	/**
	 * 新增部门信息
	 * @param dept   部门信息
	 * @return
	 */
	@RequestMapping("/addDept")
	public Message addDept(Department dept){
		Message msg = new Message();

		int addNum = deptService.addDept(dept);
		if(addNum == 0){
			msg = Message.error("添加部门信息失败！");
		} else {
			msg =  Message.success("添加部门信息成功！");
		}
		return msg;
	}

	/**
	 * 修改部门信息
	 * @param dept    部门信息
 	 * @return
	 */
	@RequestMapping("/modifyDept")
	public Message modifyDept(Department dept){
		Message msg = new Message();
		int modNum = deptService.modifyDept(dept);
		if(modNum == 0){
			msg = Message.error("修改部门信息失败！");
		} else {
			msg =  Message.success("修改部门信息成功！");
		}
		return msg;
	}

	/**
	 * 删除部门信息
	 * @param deptId   部门ID
	 * @return
	 */
	@RequestMapping("/delDept")
	public Message delDept(Long deptId){
		Message msg = new Message();
		int delNum = deptService.delDept(deptId);
		if(delNum == 0){
			msg = Message.error("删除部门信息失败！");
		} else {
			msg = Message.success("删除部门信息成功！");
		}
		return msg;
	}

}
